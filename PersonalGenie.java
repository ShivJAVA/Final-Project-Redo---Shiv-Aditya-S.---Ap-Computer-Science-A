package GPACK;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

public class PersonalGenie extends JPanel implements ActionListener, KeyListener {
	
	private JLabel lblNewLabel; 
	
	private JLabel lblNewLabel_1; 

	private JLabel lblNewLabel_5;
	
	private String current;
	
	private int current1 = -1;
	
	private int count = 0;
	
	private int count1 = 3;
	
	private String direction = "";
	
	private boolean isThere = false;
	
	private boolean happened = false;
	
	private TimerTask task;
	
	private Timer t1;
	
	private Timer timer;
	
	private int power;
	
	Timer t = new Timer(8, this);
	
	private int x = 100, y = 175, velx = 0, vely = -2;
	
	private ArrayList<JLabel> labels = new ArrayList<>();
	
	private ArrayList<Integer> yvals = new ArrayList<>();
	
	private ArrayList<Integer> xvals = new ArrayList<>();
	
	private boolean hasHappened;
	
	private boolean happ = true;
	
	private Timer t2;
	
	private Timer t3;
	
	private int count5 = 0;
	
	private boolean doEvery = true;
	
	private boolean happ2 = false;
	
	public PersonalGenie() {
		
		current = "temp_2_58x89.png";
		
		setBounds(30, 230, 292, 330);
		
		power = 25;
		
		t.start();
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		
		lblNewLabel = new JLabel("");
	    lblNewLabel.setBounds(100, 175, 124, 124);
		add(lblNewLabel);
		ImageIcon img = new ImageIcon(current);
		lblNewLabel.setIcon(img);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 267, 450, 16);
		add(lblNewLabel_1);
		ImageIcon img2 = new ImageIcon("292.png");
		lblNewLabel_1.setIcon(img2);
		lblNewLabel_1.setOpaque(false); 
		
		lblNewLabel_5 = new JLabel("Time Left: 0s");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(86, 284, 174, 40);
		add(lblNewLabel_5);
		

		
		t1 = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < labels.size(); i ++) {
				labels.get(i).setBounds(xvals.get(i), yvals.get(i) - 2, 60, 60);
		    if (labels.get(i).getY() == 0) {
  
		    	
		    	hasHappened = true;
		    	
				labels.get(i).setEnabled(false);
				labels.get(i).setVisible(false);
				
				}
		    yvals.set(i, yvals.get(i) - 2);
	         }
		  }
	  });
		
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				if (count == 2) {
					ImageIcon img = new ImageIcon("temp_2_58x89.png");
					lblNewLabel.setIcon(img);
					timer.stop();
					current1 = -1;
				}
			}
		});
		
		t2 = new Timer(1000, new ActionListener() {
			int count = 0;
			public void actionPerformed(ActionEvent e) {
				if (count == 1) { 
					t.start();
					t1.start();
					t2.stop();
				}
				count++;
			}
		});
		
		t3 = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				happ2 = true;
				lblNewLabel_5.setText("Time Left: " + count1 + "s"); 
				count1--;
				if (count1 == -1) {
					happ = true;
					t3.stop();
				}
				System.out.println(count1);
			}
		});

	}
	
	public void actionPerformed(ActionEvent e) {
		
			if (!isThere && happened) {
				x += velx;
				y += vely;
				if (x <= 0) {
					x = 0;
				}
				if (x >= 224) {
					x = 224;
				}
				lblNewLabel.setBounds(x, y, 124, 126);
			if (direction.equals("right")) {
			    if (current1 == 1) {
					current = "tgenierun2_58x89.png";
				}
				else if (current1 > 1 && current1 < 4) {
					current = "tgeniestill2_58x89.png";
				}
			}
			else if (direction.equals("left")) {
				if (current1 == 1) {
					current = "tgenierun1_1_58x89.png";
				}
				else if (current1 > 1 && current1 < 4) {
					current = "tgeniestill1_1_58x89.png";
				}					
			}
			
			ImageIcon img = new ImageIcon(current);
			lblNewLabel.setIcon(img);
			
			t.stop();

			}
		
		}
	
	public void right() {
		
		vely = 0;
		velx = 30;

	}
	
	public void left() {
		
		vely = 0;
		velx = -30;

	}
	
	public void keyPressed(KeyEvent e) { // which key is pressed
		int code = e.getKeyCode();
		if (doEvery) {
		if (code == KeyEvent.VK_RIGHT) {
			right();
			timer.stop();
			direction = "right";
			task = new TimerTask(){

			    public void run(){
			            current1++;
			    }
			};
			    task.run();
		//	    System.out.println(current1);
			    happened = true;
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
			timer.stop();
			direction = "left";
			task = new TimerTask(){

			    public void run(){
			            current1++;
			    }
			};
			    task.run();
		//	    System.out.println(current1);
			    happened = true;
			
		}
		if (code == KeyEvent.VK_SPACE) {
			
			happ2 = false;

			if (count5 == 1) {
			
			t3.start();
			
			}
			
			count5 = 1;
			
			if (happ) {
			
			JLabel newLabel = new JLabel();
			newLabel.setBounds(lblNewLabel.getX(), lblNewLabel.getY(), 60, 60);
			ImageIcon img1 = new ImageIcon("ezgif.com-gif-maker (1).gif");
			newLabel.setIcon(img1);
			add(newLabel);
			labels.add(newLabel);
			yvals.add(y - 25);
			xvals.add(lblNewLabel.getX());
			System.out.println(y);
			t1.start();

			
		}
			
			happ = false;
			
			count1 = 3;
			
			
			
	    }
		}
	 }
	public void keyTyped(KeyEvent e) {};
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
			t.start();
			happened = false;
			timer.start();
			count = 0;
		}
		
		if (current1 >= 3) {
			current1 = -1;
		}
		
		velx = 0;
		vely = 0;
	}

	public static void main (String [] args) {}
	
	public int returnPower() {
		return power;
	}
	public boolean hasHappened() {
		return hasHappened;
	}
	public void setHappened() {
		hasHappened = false;
	}
	public void returnEstop() {
		t.stop();
		t1.stop();
		timer.stop();
		t3.stop();
		for (int i = 0; i < labels.size(); i ++) {
			labels.get(i).setVisible(false); 
		}
	}
	public void returnEstart() {
		t.start();
		t1.start();
		timer.start();

	}
	public void stopT1() {
		t.stop();
		t1.stop();
		for (int i = 0; i < labels.size(); i ++) {
			remove(labels.get(i));
		}
		ImageIcon img = new ImageIcon("temp_2_58x89.png");
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(x, y, 124, 124);
	}
	public int getXPos() {
		return lblNewLabel.getX();
	}
	public void setLabel() {
		x = 100;
		y = 175;
		lblNewLabel.setBounds(x, y, 124, 124);
		ImageIcon img = new ImageIcon("temp_2_58x89.png");
		lblNewLabel.setIcon(img);
	}
	public void setLabel2() {
		t3.stop();
		lblNewLabel_5.setText("Time Left: " + 0 + "s"); 
		count1 = 3;
		happ = false;
		count5 = 0;
	}
	public void stopE() {
		t.stop();
		t1.stop();
		timer.stop();
		t3.stop();
		for (int i = 0; i < labels.size(); i ++) {
			labels.get(i).setVisible(false); 
		}
		doEvery = false;
		
	}
	public void startT3() {
		if (count1 >= 0 && happ2) {
		t3.start();
		}
	}
}
