package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AndGate extends JPanel {

	Color color;
	
	/**
	 * Create the panel.
	 */
	public AndGate() {

	}
	
	public void setColor(Color c){
		color = c;
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(2));
		super.paintComponent(g2);
		g2.drawArc(2, 10, 50, 50, 270, 180);
		g2.drawLine(25,10,25,60);
		
	}

	public static void main(String [] args){
		AndGate p = new AndGate();
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}

}
