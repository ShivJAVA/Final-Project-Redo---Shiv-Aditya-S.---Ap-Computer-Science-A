package GPACK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GenieTeams extends JPanel implements ActionListener, KeyListener {
	
	private JLabel lblNewLabel;
	
	private JLabel lblNewLabel_1;
	
	private boolean happ = true;
	
	private ArrayList<JLabel> labels = new ArrayList<>();
	
	private ArrayList<Integer> vals = new ArrayList<>();
	
	private boolean hasHappened;
	
	private int power;
	
	private Timer t3;
	
	private int count1 = 3;
	
	private int count5 = 0;
	
	Timer t = new Timer(10, this);
	
	private int vely = 0;
	
	private boolean happ2 = false;
	
	public GenieTeams() {
		
		power = 13;
		
		addKeyListener(this);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		
		lblNewLabel = new JLabel("");
	    lblNewLabel.setBounds(370, 400, 124, 126);
		add(lblNewLabel);
		ImageIcon img = new ImageIcon("temp_2_58x89.png");
		lblNewLabel.setIcon(img);
		
		lblNewLabel_1 = new JLabel("Time Left: 0s");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(350, 525, 150, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(350, 500, 160, 16);
		add(lblNewLabel_2);
		ImageIcon img2 = new ImageIcon("platform1_126-removebg.png");
		lblNewLabel_2.setIcon(img2);
		
		t3 = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				happ2 = true;
				lblNewLabel_1.setText("Time Left: " + count1 + "s"); 
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
		
		for (int i = 0; i < labels.size(); i ++) {
			labels.get(i).setBounds(370, vals.get(i) + vely, 60, 60);
		    if (labels.get(i).getY() == 230) {
		    	
		    	hasHappened = true;
		    	
				labels.get(i).setEnabled(false);
				labels.get(i).setVisible(false);
				
				}
		    vals.set(i, vals.get(i) + vely);
		}
		
	}
	public void space() {
		
		vely = -2;	
	}
	
	public void keyPressed(KeyEvent e) { //which key is pressed
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_SPACE) {
			
			happ2 = false;
			
			if (count5 == 1) {
				
			t3.start();
			
			}
			
			System.out.println(happ);
			
			count5 = 1;
			
			if (happ) {
				
			space();
			t.start();
			JLabel newLabel = new JLabel();
			newLabel.setBounds(370, 380, 60, 60);
			ImageIcon img1 = new ImageIcon("ezgif.com-gif-maker (1).gif");
			newLabel.setIcon(img1);
			add(newLabel);
			labels.add(newLabel);
			vals.add(380);
			
			}
			
			happ = false;
			
			count1 = 3;
			
		}
	}
	public void keyTyped(KeyEvent e) {};
	public void keyReleased(KeyEvent e) {}

	public void returnEstop() {
		t.stop();
		t3.stop();
	}
	public void returnEstart() {
		t.start();
	}
	public boolean getHappened() {
		return hasHappened;
	}
	public void setHappened() {
		hasHappened = false;
	}
	public int getPower() {
		return power;
	}
	public void setLabel2() {
		t3.stop();
		lblNewLabel_1.setText("Time Left: " + 0 + "s"); 
		count1 = 3;
		happ = true;
		count5 = 0;
	}
	public void startT3() {
		if (count1 >= 0 && happ2) {
		t3.start();
		}
	}
}
