package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Mux extends JPanel {

	Color color;
	/**
	 * Create the panel.
	 */
	public Mux() {
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
		g2.drawRoundRect((getWidth()-30)/2, (getHeight()-100)/2, 30, 100, 30, 30);
		g2.drawString("M", (getWidth()-10)/2, getHeight()/2 - 20);
		g2.drawString("U", (getWidth()-10)/2, getHeight()/2 );
		g2.drawString("X", (getWidth()-10)/2, getHeight()/2 + 20);
		
		
	}

	public static void main(String [] args){
		Mux p = new Mux();
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}
}
