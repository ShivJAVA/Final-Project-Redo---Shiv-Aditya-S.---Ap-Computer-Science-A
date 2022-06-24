package GPACK;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GenieRunnerL2 extends JFrame implements ActionListener, KeyListener {
	private String imgString;
	private int berriesNum;
	private boolean[] b = {false, false, false, false};
	private GenieTeams s;
	private File file;
	private AudioInputStream audiostream;
	private Clip clip;
	private PersonalGenie s1;
	
	private PersonalGenie panel;

	private JLabel lblNewLabel_5;
	
	private int width = 287;
	
	private int width1 = 287;
	
	private int width2 = 182;
	
	private int width3 = 182;
	
	private int width4 = 173;
	
	private Timer t;
	private Timer t1;
	private Timer t2;
	private Timer t4;
	
	private JPanel panel_13;
	private JPanel panel_14;
	
	private WalkingGoblinL3[][] g2;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_8;
	
	private int count7;
	
	private boolean case1 = true;
	private JPanel panel_9;
	private JPanel panel_17;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	
	public GenieRunnerL2(int berries, boolean[] bought, String Bimg) {
		imgString = Bimg;
		b = bought;
		berriesNum = berries;
		JFrame f = new JFrame();
		
		f.getContentPane().setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		try {
			playGameMusic();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		panel_14 = new JPanel();
		panel_14.setBounds(513, 230, 287, 39);
		f.getContentPane().add(panel_14);
		panel_14.setBackground(Color.BLUE);
		
		panel_13 = new JPanel();
		panel_13.setBackground(Color.LIGHT_GRAY);
		panel_13.setBounds(513, 230, 287, 39);
		f.getContentPane().add(panel_13);
		panel_13.setLayout(null);
		
		panel_16 = new JPanel();
		panel_16.setBackground(Color.BLUE);
		panel_16.setBounds(15, 230, 287, 39);
		f.getContentPane().add(panel_16);
		
		panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_15.setBounds(15, 230, 287, 39);
		f.getContentPane().add(panel_15);
		panel_15.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(80, 563, 175, 18);
		f.getContentPane().add(panel_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(80, 563, 175, 18);
		f.getContentPane().add(panel_1);
		
		s = new GenieTeams();
		s.setBackground(Color.DARK_GRAY);
		s.setBounds(0, 0, 888, 609);
		f.getContentPane().add(s);
		
		s.addKeyListener(this);
		s.setFocusTraversalKeysEnabled(false);
      
		s.setFocusable(false);
		s1 = new PersonalGenie();
		s1.setBackground(Color.PINK);
		s1.setBounds(30, 230, 292, 330);
		s1.setOpaque(false);
		s.add(s1);
		s1.addKeyListener(this);
		s1.setFocusTraversalKeysEnabled(false);
		s1.setFocusable(true);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(320, 0, 160, 200);
		s.add(lblNewLabel_5);
		panel = new PersonalGenie();
		panel.setBackground(Color.PINK);
		panel.setBounds(493, 230, 292, 321);
		s.add(panel);
		panel.setOpaque(false);
		panel.addKeyListener(this);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setFocusable(false);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(554, 563, 182, 18);
		s.add(panel_4);
		panel_4.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setBackground(Color.ORANGE);
		panel_8.setBounds(0, 0, 182, 18);
		panel_4.add(panel_8);
		
		ImageIcon img1 = new ImageIcon("demonking10.png");
		lblNewLabel_5.setIcon(img1);
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(320, 230, 173, 39);
		s.add(panel_9);
		panel_9.setLayout(null);
		
		panel_17 = new JPanel();
		panel_17.setBounds(0, 0, 173, 39);
		panel_9.add(panel_17);
		panel_17.setBackground(Color.BLUE);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(44, 28, 219, 190);
		s.add(lblNewLabel_1);
		panel_17.setVisible(false);
		
		ImageIcon img = new ImageIcon("Screen_Shot_2022-06-24_at_8.41.11_AM_219x190-removebg-preview.png");
		lblNewLabel_1.setIcon(img);
		
		ImageIcon img2 = new ImageIcon("redx.png");
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(492, 28, 219, 190);
		s.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(img);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(291, 28, 219, 190);
		s.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(img);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(44, 28, 219, 190);
		s.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(img2);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(275, 28, 219, 190);
		s.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(img2);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(506, 28, 219, 190);
		s.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(img2);
		
		
		lblNewLabel_1.setVisible(false); 
		lblNewLabel_2.setVisible(false); 
		lblNewLabel_3.setVisible(false); 
		lblNewLabel_6.setVisible(false); 
		lblNewLabel_7.setVisible(false);
		lblNewLabel_8.setVisible(false); 
		
		boolean isThere = true;
		
		g2 = new WalkingGoblinL3[4][2];
		
		int x = 0;
		
		int y = 0;
		
		for (int i = 0; i < 728; i = i + 160) {
			isThere = true;
			y = 0;
			for (int j = 0; j < 200; j = j + 115) {
					if (i == 320) {
						isThere = false;
					}
					if (isThere) {
					WalkingGoblinL3 g = new WalkingGoblinL3();
					if (y == 1) {
					g.setBounds(i, j, 160, 300);	
					}
					else {
					g.setBounds(i, j, 160, 115);
					}
					g.setFocusable(false); 
					s.add(g);
					g.setBackground(Color.DARK_GRAY);
					g2[x][y] = g;
					y++;
				}
			}
			if (isThere) {
			x++;
			}
		}
		
		for (int i = 0; i < g2.length; i++) {
			for (int j = 0; j < g2[0].length; j++) {						
				if (j == 1) {
				g2[i][j].setDoable(true);
				}
				else if (j == 0) {
				g2[i][j].setDoable(false);
				}
			}
		}
		
		panel_16.setVisible(false);
		panel_15.setVisible(false);
		panel_13.setVisible(false);
		panel_14.setVisible(false);
		panel_1.setVisible(false);
		panel_2.setVisible(false);
		panel_4.setVisible(false);
		panel_8.setVisible(false);
		panel_9.setVisible(false);
				
		t = new Timer(1, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (s1.hasHappened()) {
					width = width - s1.returnPower();
					panel_16.setBounds(15, 230, width, 39);
				    if (width <= 0) {
						for (int i = 0; i < g2.length; i++) {
							for (int j = 0; j < g2[0].length; j++) {						
								if (i == 0 && j == 0 || i == 1 && j == 0) {
								g2[i][j].setInvisible();
								}
							}
						}
					s1.stopE();
					for (int i = 0; i < g2.length; i++) {
						for (int j = 0; j < g2[0].length; j++) {						
							if (i == 0 && j == 0 || i == 1 && j == 0) {
							g2[i][j].stopE();
							}
						}
					}
					lblNewLabel_1.setVisible(true); 
					s1.setHappened();
					count7++;
					}
				    else if (width == 187) {
					for (int i = 0; i < g2.length; i++) {
						for (int j = 0; j < g2[0].length; j++) {						
							if (i == 0 && j == 1 || i == 1 && j == 1) {
							g2[i][j].setInvisible();
							}
							if (j == 0 && i == 0 || j == 0 && i == 1) {
							g2[i][j].setDoable(true);
							g2[i][j].setBounds(g2[i][j].getX(), g2[i][j].getY(), 160, 300);
							}
							else if (j == 1 && i == 0 || j == 1 && i == 1) {
							g2[i][j].setDoable(false);	
							g2[i][j].setBounds(g2[i][j].getX(), g2[i][j].getY(), 160, 115);
							}
				     	 }	
					   }
					s1.setBounds(30, 115, 292, 445); // absolute values
					panel_2.setBounds(80, 450, 182, 18);
					panel_1.setBounds(80, 450, 182, 18);
					s1.stopT1();
					s1.setHappened();
					}
					s1.setHappened();
				}
				if (g2[1][0].getHappened() && s1.getXPos() >= 160 && s1.getXPos() <= 190
				|| g2[0][0].getHappened() && s1.getXPos() <= 40 && s1.getXPos() >= 10) {
					width2 = width2 - g2[1][0].getPower();
					panel_2.setBounds(80, panel_2.getY(), width2, 18);		
					if (width2 <= 0) {
						lblNewLabel_6.setVisible(true);
						count7--;
						for (int i = 0; i < g2.length; i++) {
							for (int j = 0; j < g2[0].length; j++) {						
								if (i == 0 && j == 0 || i == 1 && j == 0 || i == 1 && j == 1 || i == 0 && j == 1) {
								g2[i][j].stopE();
								g2[i][j].setVisible(false);
								}
							}
						}
						s1.stopE();
					}
				}
				g2[1][0].setHappened();
				g2[0][0].setHappened();
				if (g2[1][1].getHappened() && s1.getXPos() >= 160 && s1.getXPos() <= 190
				|| g2[0][1].getHappened() && s1.getXPos() <= 40 && s1.getXPos() >= 10) {
					width2 = width2 - g2[0][1].getPower();
					panel_2.setBounds(80, panel_2.getY(), width2, 18);
					if (width2 <= 0) {
						lblNewLabel_6.setVisible(true);
						count7--;
						for (int i = 0; i < g2.length; i++) {
							for (int j = 0; j < g2[0].length; j++) {						
								if (i == 0 && j == 0 || i == 1 && j == 0 || i == 1 && j == 1 || i == 0 && j == 1) {
								g2[i][j].stopE();
								g2[i][j].setVisible(false);
								}
							}
						}
						s1.stopE();
					}
				}
				g2[0][1].setHappened();
				g2[1][1].setHappened();
			}
		});
		
		t1 = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.hasHappened()) {
					width1 = width1 - panel.returnPower();
					panel_14.setBounds(513, 230, width1, 39);
				    if (width1 <= 0) {
						for (int i = 0; i < g2.length; i++) {
							for (int j = 0; j < g2[0].length; j++) {						
								if (i == 2 && j == 0 || i == 3 && j == 0) {
								g2[i][j].setInvisible();
								}
							}
						}
					panel.stopE();
					for (int i = 0; i < g2.length; i++) {
						for (int j = 0; j < g2[0].length; j++) {						
							if (i == 2 && j == 0 || i == 3 && j == 0) {
							g2[i][j].stopE();
							}
						}
					}
					count7++;
				    lblNewLabel_2.setVisible(true); 
					panel.setHappened();
					}
				    else if (width1 == 187) {
					for (int i = 0; i < g2.length; i++) {
						for (int j = 0; j < g2[0].length; j++) {						
							if (i == 2 && j == 1 || i == 3 && j == 1) {
							g2[i][j].setInvisible();
							}
							if (j == 0 && i == 2 || j == 0 && i == 3) {
							g2[i][j].setDoable(true);
							g2[i][j].setBounds(g2[i][j].getX(), g2[i][j].getY(), 160, 300);
							}
							else if (j == 1 && i == 2 || j == 1 && i == 3) {
							g2[i][j].setDoable(false);
							g2[i][j].setBounds(g2[i][j].getX(), g2[i][j].getY(), 160, 115);
							}
				     	 }	
					   }
					panel.setBounds(493, 115, 292, 445); // absolute values
					panel_4.setBounds(554, 450, 182, 18);
					panel.stopT1();
					panel.setHappened();
					}
					panel.setHappened();
				}
				
				if (g2[3][0].getHappened() && panel.getXPos() >= 160 && panel.getXPos() <= 190
				|| g2[2][0].getHappened() && panel.getXPos() <= 40 && panel.getXPos() >= 10) {
					width3 = width3 - g2[2][0].getPower();
					panel_8.setBounds(0, panel_8.getY(), width3, 18);
					if (width3 <= 0) {
						lblNewLabel_8.setVisible(true);
						count7--;
						for (int i = 0; i < g2.length; i++) {
							for (int j = 0; j < g2[0].length; j++) {						
								if (i == 2 && j == 0 || i == 3 && j == 0 || i == 2 && j == 1 || i == 3 && j == 1) {
								g2[i][j].stopE();
								g2[i][j].setVisible(false);
								}
							}
						}
						panel.stopE();
					}
				}
				g2[2][0].setHappened();
				g2[3][0].setHappened();
				if (g2[3][1].getHappened() && panel.getXPos() >= 190 && panel.getXPos() <= 195
				||  g2[2][1].getHappened() && panel.getXPos() <= 40 && panel.getXPos() >= 35) {
					width3 = width3 - g2[2][1].getPower();
					panel_8.setBounds(0, panel_8.getY(), width3, 18);
					if (width3 <= 0) {
						lblNewLabel_8.setVisible(true);
						count7--;
						for (int i = 0; i < g2.length; i++) {
							for (int j = 0; j < g2[0].length; j++) {						
								if (i == 2 && j == 0 || i == 3 && j == 0 || i == 2 && j == 1 || i == 3 && j == 1) {
								g2[i][j].stopE();
								g2[i][j].setVisible(false);
								}
							}
						}
						panel.stopE();
					}
				}
				g2[2][1].setHappened();
				g2[3][1].setHappened();
			}
		});
		
		t2 = new Timer(1, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (s.getHappened()) {
					width4 = width4 - s.getPower();
					panel_17.setBounds(0, 0, width4, 39);
					if (width4 <= 0) {
						count7++;
						lblNewLabel_5.setVisible(false);
						lblNewLabel_3.setVisible(true); 
					}
				}
				s.setHappened();
			}
			
		});
		
		t.start();
		
		t4 = new Timer(1, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (count7 == 2 || count7 == -2) {
	
					f.dispose();
					JFrame frame = new JFrame();
					frame.getContentPane().setLayout(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setSize(240, 120);
					JButton newButton = new JButton("Back Home");
					newButton.setBounds(10, 20, 100, 20);
					frame.add(newButton);
					
					newButton.addActionListener(new ActionListener() {
						

						@Override
						public void actionPerformed(ActionEvent e) {
							clip.stop();
							frame.dispose();
							try {
								StartMenu kop = new StartMenu(0, berriesNum, "Level 1", imgString, b);
							} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
					});
					if (count7 == 2) {
						JLabel label = new JLabel();
						label.setBounds(10, 3, 240, 120);
						label.setText("Congratulations, you won!");
						label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
						frame.getContentPane().add(label);
					}
					else if (count7 == -2) {
						JLabel label = new JLabel();
						label.setBounds(10, 3, 240, 120);
						label.setText("Sorry, you lost.");
						label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
						frame.getContentPane().add(label);
					}
					t4.stop();
				}
				
			}
		});
		
		t4.start();
		
		f.setVisible(true);
		f.setSize(888, 609);
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_A) {
     			s1.setFocusable(true);
				s.setFocusable(false);
				panel.setFocusable(false);
				panel.setFocusable(true);
				panel.setLabel();
				panel.setLabel2();
				t.start();
				t2.stop();
				t1.stop();
		}
		if (code == KeyEvent.VK_D) {
				panel.setFocusable(true);
				s.setFocusable(false);
				s1.setFocusable(false);
				s1.setLabel(); 
				s1.setLabel2();
				t.stop();
				t2.stop();
				t1.start();
			}
		if (code == KeyEvent.VK_S) {
				s.setFocusable(true);
				s1.setFocusable(false);
				panel.setFocusable(false);
				panel.setLabel();
				s1.setLabel();
				s1.setLabel2();
				panel.setLabel2();
				t.stop();
				t2.start();
				t1.stop();
			}
		if (code == KeyEvent.VK_ESCAPE) {
			s1.returnEstop();
			s.returnEstop();
			panel.returnEstop();
			for (int i = 0; i < g2.length; i++) {
				for (int j = 0; j < g2[0].length; j++) {						
					g2[i][j].returnEstop();
				}
			}
			panel_16.setVisible(true);
			panel_15.setVisible(true);
			panel_13.setVisible(true);
			panel_14.setVisible(true);
			panel_1.setVisible(true);
			panel_2.setVisible(true);
			panel_4.setVisible(true);
			panel_8.setVisible(true);
			panel_9.setVisible(true);
			panel_17.setVisible(true);
		}
	}
	public void keyTyped(KeyEvent e) {};
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (case1) {
			s1.returnEstart();
			s.returnEstart();
			panel.returnEstart();
			if (s1.isFocusable()) {
				s1.startT3();
			}
			else if (panel.isFocusable()) {
				panel.startT3();
			}
			else if (s.isFocusable()) {
				s.startT3();
			}
			
			for (int i = 0; i < g2.length; i++) {
				for (int j = 0; j < g2[0].length; j++) {						
					g2[i][j].returnEstart();
				}
			}
		}
			panel_16.setVisible(false);
			panel_15.setVisible(false);
			panel_13.setVisible(false);
			panel_14.setVisible(false);
			panel_1.setVisible(false);
			panel_2.setVisible(false);
			panel_4.setVisible(false);
			panel_8.setVisible(false);
			panel_9.setVisible(false);
			panel_17.setVisible(false);
		}
	}
	public void actionPerformed(ActionEvent e) {}
	
	public void playGameMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		file = new File("8BIT.wav");
		audiostream =  AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audiostream);
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
}
