package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class SignExtend extends JPanel {

	Color color;
	
	/**
	 * Create the panel.
	 */
	public SignExtend() {
		setOpaque(false);
	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(2));
		super.paintComponent(g2);
		g2.drawOval((getWidth()-80)/2, (getHeight()-150)/2, 80, 150);
		g2.drawString("Sign", (getWidth()-30)/2, getHeight()/2 - 10);
		g2.drawString("extend", (getWidth()-40)/2, getHeight()/2 + 10);
		
		
	}

	public static void main(String [] args){
		SignExtend p = new SignExtend();
		p.setColor(Color.yellow);
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}

}
