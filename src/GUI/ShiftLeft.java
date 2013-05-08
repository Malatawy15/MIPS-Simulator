package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ShiftLeft extends JPanel {

	Color color;
	
	/**
	 * Create the panel.
	 */
	public ShiftLeft() {
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
		g2.drawOval((getWidth()-60)/2, (getHeight()-80)/2, 60, 80);
		g2.drawString("Shift", (getWidth()-30)/2, getHeight()/2 - 10);
		g2.drawString("left 2", (getWidth()-30)/2, getHeight()/2 + 10);
		
		
	}

	public static void main(String [] args){
		ShiftLeft p = new ShiftLeft();
		p.setColor(Color.pink);
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}

}
