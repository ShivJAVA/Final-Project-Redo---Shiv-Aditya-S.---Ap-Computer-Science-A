package GPACK;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

import java.io.File;






public class StartScreen extends JFrame {
	
	//First Screen
	private JButton startB;
	private JPanel startP;
	private JLabel rImage;
	//
	
	
	//Second Screen
		//Lists
		private ArrayList<Integer> answered;
		private ArrayList<String> allEyes;
		private ArrayList<String> allHair;
		private ArrayList <String> allNames;
		private ArrayList<String> allHeight;
		private ArrayList<String> allGlasses;
		//
		
		//Bakcground Image
		private ImageIcon background1;
		private JLabel rImage1;
		//
		
		//Timer
		DecimalFormat dFormat = new DecimalFormat("00");
		private Timer timer;
		private Timer blinkTimer;
		private Timer correctTimer;
		private JLabel timerL; 
		private int second;
		private int secondC;
		private int minute;
		private String ddSecond;
		private String ddMinute;
		private boolean isVisible;
		private JButton timerBack;
		//
		
		//Quiz Game
		private JPanel nameGameP;
		private JButton startB2;
		private JButton doneB;
		private JButton skipB;
		private JLabel doneL;
		private JTextField answer;
		private JLabel glasses;
		private JLabel hairCol;
		private JLabel eyeCol;
		private JLabel height;
		private JLabel pointCounter;
		private JLabel correctL;
		private JLabel correctLName;
		private int randPerson;
		private int points;
		//
		
		//Music and SFX

			//Game Music
			private File file;
			private AudioInputStream audiostream;
			private Clip clip;
			//
			
			//Timer ALarm Music
			private File file1;
			private AudioInputStream audiostream1;
			private Clip clip1;
			//
			
			//WRONG-SOUND SFX
			private File file2;
			private AudioInputStream audiostream2;
			private Clip clip2;
			//
			
			//RIGHT-SOUND SFX
			private File file3;
			private AudioInputStream audiostream3;
			private Clip clip3;
		//
		
	
	//
	
	
	public StartScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		startGame();
		
		
	}
	
	public void startGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		//FRAME SETUP
		
			//NECESSARY FRAME STUFF
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // || When the red button is clicked, window closes ||
			setLocationRelativeTo(null); // || Sets the window to appear on center of the screen ||
			setLayout(new BorderLayout()); // || Sets Layout to BorderLayout ||
			pack(); // || I don't know what this does ||
			//
			
			//MY FRAME STUFF
			setResizable(true); // || User can't resize the frame ||
			setTitle("Start Screen");  // || Sets the title of FRAME ||
			 setSize(1000, 900); // || Size Preference ||
			setVisible(true); // || Makes frame visible ||
			//
		
		//
		
		
		//PANEL1 SETUP
		startP = new JPanel();
		startP.setLayout(new BorderLayout());
		add(startP, BorderLayout.CENTER);
		//
		
		playGameMusic();
		
		
		//IMAGE 1 SETUP
		ImageIcon background=new ImageIcon("G-FIGHTERF_1000x900.jpg");
	    Image img=background.getImage();
	    Image temp=img.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
	    background= new ImageIcon(temp);
	    rImage = new JLabel(background);
	    rImage.setLayout(new GridBagLayout() );
	    rImage.setBounds(0,0,1000,900);
	    startP.add(rImage);
	    //
	  
	    
	    // START BUTTON 1 SETUP
	    JButton startB = new JButton("START");
	    startB.setForeground(Color.BLACK);
	    startB.setBackground(Color.BLACK);
	    startB.setOpaque(true);
	    startB.setPreferredSize(new Dimension(400, 100));
	    startB.setFont(new Font("Sabo", Font.BOLD, 80));
	    rImage.add(startB, new GridBagConstraints());
	    //
	    
	    // NECESSARY _ DO NOT REMOVE
		
	    	// Sets Frame and all components to be visible
		 	setVisible(true);	
		 	//
		 
		 //
	    
	 
	    
	    
	    
	    //START BUTTON 1 ACTIONLISTENER
	    startB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//ERASES FRAME
				getContentPane().removeAll(); // || Removes all components ||
				repaint(); // || repaints Frame to be blank ||
				//
				
				
				//SETS UP TEXT FILES INTO ARRAY LISTS
				setFiles();
				//
				
				
				// PANEL 2 SETUP
				nameGameP = new JPanel();
				nameGameP.setLayout(null);
				nameGameP.setBackground(Color.BLACK);
				add(nameGameP);
				//
				
			    //GAME TIMER Setup
			    timer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						second--;
						
						if (second == -1) {
							
							if (minute == 0) {
								second = 0;
								minute = 0;
								
								ddSecond = dFormat.format(second); 
								ddMinute = dFormat.format(minute);
								
								timerL.setText(ddMinute + ":" + ddSecond);
								
								timer.stop();
								timerL.setVisible(false);
								pointCounter.setVisible(false);
								isVisible = false;
								doneScreen();
								blinkTimer.start();
								
								
								

							} else {
								second = 59;
								minute--;
								
								ddSecond = dFormat.format(second); 
								ddMinute = dFormat.format(minute);
								
								timerL.setText(ddMinute + ":" + ddSecond);
							}
							
						} else {
							ddSecond = dFormat.format(second); 
							ddMinute = dFormat.format(minute);
							
							timerL.setText(ddMinute + ":" + ddSecond);
						}
					}
			    	
			    	
			    });
			    //
			    
			    //BlINK TIMER SET UP
			    blinkTimer = new Timer(500, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							loopAlarmMusic();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						if (isVisible) {
							timerL.setVisible(false);
							pointCounter.setVisible(false);
							doneL.setVisible(false);
							isVisible = false;
						} else {
							timerL.setVisible(true);
							pointCounter.setVisible(true);
							doneL.setVisible(true);
							isVisible = true;
						}
						
					}
			    	
			    	
			    }); 
			    //
			    
			    //Timer Label
			    timerL = new JLabel("01:30");
			    timerL.setLayout(null);
			    timerL.setBounds(775, 15, 500, 60);
			    timerL.setFont(new Font("Arial", Font.BOLD, 60));
			    timerL.setForeground(Color.GREEN);
			    timerL.setVisible(false);
			    nameGameP.add(timerL);
			    //
			    
			    
			    //Timer BackGround
			    timerBack = new JButton();
				timerBack.setBounds(700, 0, 300, 90);
				nameGameP.add(timerBack);
				timerBack.setVisible(false);
				//
			    
			     // ANSWER TEXTFIELD
			    answer = new JTextField();
			    answer.setBounds(450, 390, 400, 90);
			    answer.setFont(new Font("Sabo", Font.BOLD, 40));
			    answer.setForeground(Color.GREEN);
			    answer.setBackground(Color.RED);
			    answer.setVisible(false);
			    answer.setEnabled(false);
			    nameGameP.add(answer);
			    //
			    
			    
			  //Question is answered in ANSWER TEXTFIELD
			    answer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String userAnswer = answer.getText();
						if (userAnswer.equals(allNames.get(randPerson))) {
							try {
								playRightSFX();
							} catch (UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							points++;
							pointCounter.setText("Points: " + points);
						} else {
							try {
								playWrongSFX();
							} catch (UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							showCorrectAnswer();
							correctTimer.start();
						}
						answer.setText("");
						setQuestion();
						
					}
			    	
			    	
			    });
			    //
			    
			    
			  //SETUP for ALL Hints
			    
			    //Glasses Hint Label
			    glasses = new JLabel("1");
				glasses.setLayout(null);
				glasses.setBounds(10, 160, 400, 400);
				glasses.setFont(new Font("Arial", Font.BOLD, 24));
				glasses.setForeground(Color.GREEN);
				glasses.setVisible(false);
				nameGameP.add(glasses);
				//
				
				
				//Hair Color Hint Label
				hairCol = new JLabel("2");
				hairCol.setLayout(null);
				hairCol.setBounds(180, 160, 400, 400);
				hairCol.setFont(new Font("Arial", Font.BOLD, 24));
				hairCol.setForeground(Color.GREEN);
				hairCol.setVisible(false);
				nameGameP.add(hairCol);
				//
				
				//Eye Color Hint Label
				eyeCol = new JLabel("3");
				eyeCol.setLayout(null);
				eyeCol.setBounds(180, 300, 400, 400);
				eyeCol.setFont(new Font("Arial", Font.BOLD, 24));
				eyeCol.setForeground(Color.GREEN);
				eyeCol.setVisible(false);
				nameGameP.add(eyeCol);
				//
				
				//Height Hint Label
				height = new JLabel("4");
				height.setLayout(null);
				height.setBounds(10, 300, 400, 400);
				height.setFont(new Font("Arial", Font.BOLD, 24));
				height.setForeground(Color.GREEN);
				height.setVisible(false);
				nameGameP.add(height);
				//

			  //
				
				
				//POINT COUNTER SET UP
				pointCounter = new JLabel("Points: ");
				pointCounter.setLayout(null);
				pointCounter.setBounds(550, 300, 400, 400);
				pointCounter.setFont(new Font("Arial", Font.BOLD, 30));
				pointCounter.setForeground(Color.GREEN);
				pointCounter.setVisible(false);
				nameGameP.add(pointCounter);
				//
				
				//SKIP BUTTON SETUP
				skipB = new JButton("SKIP");
				skipB.setForeground(Color.GREEN);
				skipB.setBackground(Color.WHITE);
				skipB.setBounds(520, 550, 300, 90);
				skipB.setFont(new Font("Arial", Font.BOLD, 60));
				skipB.setVisible(false);
			    nameGameP.add(skipB);
				//
			    
			    //Question SKIPPED
			    skipB.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							playWrongSFX();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						showCorrectAnswer();
						correctTimer.start();
						setQuestion();
						
					}
			    	
			    	
			    });
			    //
			    
			    //CORRECT ANSWER LABEL
			    correctL = new JLabel("Correct Answer WAS: ");
			    correctL.setLayout(null);
			    correctL.setBounds(10, 350, 400, 400);
			    correctL.setFont(new Font("Arial", Font.BOLD, 30));
			    correctL.setForeground(Color.GREEN);
			    correctL.setVisible(false);
				nameGameP.add(correctL);
				//
				
				// Correct Name Label
				correctLName = new JLabel();
				correctLName.setLayout(null);
				correctLName.setBounds(10, 400, 400, 400);
				correctLName.setFont(new Font("Arial", Font.BOLD, 30));
			    correctLName.setForeground(Color.GREEN);
			    correctLName.setVisible(false);
				nameGameP.add(correctLName);
			    
			    // START BUTTON 2 SETUP
			    startB2 = new JButton("BEGIN");
			    startB2.setForeground(Color.GREEN);
			    startB2.setBackground(Color.WHITE);
			    startB2.setBounds(460, 370, 430, 200);
			    startB2.setFont(new Font("Arial", Font.BOLD, 120));
			    nameGameP.add(startB2);
			    //
			    
			    
			    //GAME START
			    startB2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						points = 0;
						pointCounter.setText("Points: " + points);
						answered = new ArrayList<>();
						skipB.setVisible(true);
						timerL.setVisible(true);
						timerBack.setVisible(true);
						startB2.setVisible(false);
						startB2.setEnabled(false);
						glasses.setVisible(true);
						hairCol.setVisible(true);
						eyeCol.setVisible(true);
						height.setVisible(true);
						answer.setVisible(true);
						answer.setEnabled(true);
						pointCounter.setVisible(true);
						
						
						setQuestion();
						second = 30;
						minute = 1;
						timer.start();
						
						setVisible(true);
						
					}
			    	
			    	
			    });
			    //
			    
			    
			    //DONE LABEL
			    doneL = new JLabel();
			    doneL = new JLabel("DONE");
			    doneL.setLayout(null);
			    doneL.setBounds(95, 680, 300, 90);
			    doneL.setFont(new Font("Arial", Font.BOLD, 60));
			    doneL.setForeground(Color.RED);
			    doneL.setVisible(false);
				nameGameP.add(doneL);
				//
				
				// DONE BUTTON
				doneB = new JButton();
				doneB.setForeground(Color.RED);
				doneB.setBackground(Color.WHITE);
				doneB.setBounds(30, 680, 300, 90);
			    nameGameP.add(doneB);
			    doneB.setVisible(false);
			    doneB.setEnabled(false);
			    //
			    
			    
			    //DONE PRESSED
			    doneB.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						boolean[] blank = {false, false, false, false};
						blinkTimer.stop();
						timerL.setVisible(true);
						pointCounter.setVisible(true);
						doneL.setVisible(true);
						
						clip.stop();
						dispose();
						try {
							StartMenu kop = new StartMenu(points, 200, "Selection", "SpaceMenu.jpg", blank);
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			    	
			    	
			    });
			    //

			    
			  //IMAGE 2 SETUP
				background1=new ImageIcon("SelectionImage.jpg");
				Image img1=background1.getImage();
				Image temp1=img1.getScaledInstance(1000,900,Image.SCALE_SMOOTH);
				background1= new ImageIcon(temp1);
				JLabel rImage1 = new JLabel(background1);
				rImage1.setLayout(null);
				rImage1.setBounds(0,0,1000,900);
				nameGameP.add(rImage1);
				//
				
				
				
			// NECESSARY _ DO NOT REMOVE
				
				 // Sets Frame and all components to be visible
				 setVisible(true);	
				 //
				 
			//
			}
	    	
	    	
	    });
	    //
	
	}
	
	
	// Play Music Methods - Starts the Music
	
		//PLAYS GAME MUSIC
		public void playGameMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			file = new File("8BIT.wav");
			audiostream =  AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audiostream);
			
			clip.start();
		}
		//
		
		
		
		//PLAYS ALARM MUSIC ONCE TIME IS DONE
		public void loopAlarmMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			clip.stop();
			file1 = new File("AlarmSound.wav");
			audiostream1 =  AudioSystem.getAudioInputStream(file1);
			clip1 = AudioSystem.getClip();
			clip1.open(audiostream1);
			
			
			clip1.start();
		}
		//
		
		
		
		//PLAYS WRONG SFX WHEN QUESTION IS ANSWERED WRONG
		public void playWrongSFX() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			file2 = new File("WRONG.wav");
			audiostream2 =  AudioSystem.getAudioInputStream(file2);
			clip2 = AudioSystem.getClip();
			clip2.open(audiostream2);
			
			
			clip2.start();
		}
		//
		
		
		
		//PLAYS RIGHT SFX WHEN QUESTION IS ANSWERED CORRECTLY
		public void playRightSFX() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			file2 = new File("RIGHT.wav");
			audiostream2 =  AudioSystem.getAudioInputStream(file2);
			clip2 = AudioSystem.getClip();
			clip2.open(audiostream2);
			
			
			clip2.start();
		}
		//
	
	//
		
	public void showCorrectAnswer() {
		secondC = 0;
		correctLName.setText(allNames.get(randPerson));
		correctTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (secondC >= 1) {
					correctTimer.stop();
					secondC = 0;
					correctL.setVisible(false);
					correctLName.setVisible(false);
					
				} else {
					correctL.setVisible(true);
					correctLName.setVisible(true);
					secondC++;
				}
				
			}
	    	
	    	
	    }); 
	    //
	}
	
	//Sets up screen after DONE is pressed
	public void doneScreen() {
		correctL.setText("");
		correctLName.setText("");
		doneB.setVisible(true);
		doneB.setEnabled(true);
		skipB.setVisible(false);
		skipB.setEnabled(false);
		glasses.setVisible(false);
		hairCol.setVisible(false);
		eyeCol.setVisible(false);
		height.setVisible(false);
		answer.setVisible(false);
		answer.setEnabled(false);
		timerL.setForeground(Color.RED);
		pointCounter.setForeground(Color.RED);
		pointCounter.setText("FINAL SCORE:" + points);
		pointCounter.setBounds(90, 360, 1000, 100);
		pointCounter.setFont(new Font("Arial", Font.BOLD, 100));
		
	}
	//
	
	
	
	//Sets up a new Question for the User
	public void setQuestion() {
		randPerson = (int) (Math.random()*31);
		if (neverUsed(randPerson)) {
			glasses.setText("Glasses: " + allGlasses.get(randPerson));
			hairCol.setText("Hair Color: " + allHair.get(randPerson));
			eyeCol.setText("Eye Color: " + allEyes.get(randPerson));
			height.setText("Height: " + allHeight.get(randPerson));
		} else if (answered.size() >= 31){
			doneScreen();
			timerL.setText("00:00");
			timer.stop();
			blinkTimer.start();
		} else {
			setQuestion();
		}
	
	}
	//
	
	
	
	//SETS UP ALL THE TEXT FILES
	public void setFiles () {
	    allEyes = importFile("eye.txt");
	    allGlasses = importFile("glasses.txt");
	    allHair = importFile("hair.txt");
	    allNames = importFile("name.txt");
	    allHeight = importFile("heights.txt");
	}
	//
	
	
	
	// Checks if a person(represented as a number) has already been used
	public boolean neverUsed(int num) {
		for (int i = 0; i < answered.size(); i++) {
			if (answered.get(i) == num) {
				return false;
			}
		}
		answered.add(num);
		return true;
	}
	//
	
	
	
	// Converts STRING Text Files to ArrayLists
	public static ArrayList<String> importFile(String fileName) {
	    ArrayList<String> words = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }

	    return words;
	  }
	//
}
	

