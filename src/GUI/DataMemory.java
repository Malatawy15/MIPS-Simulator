package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DataMemory extends JPanel {

	Color color;
	
	/**
	 * Create the panel.
	 */
	public DataMemory() {
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
		g2.drawRect((getWidth()-150)/2, (getHeight()-200)/2, 150, 200);
		g2.drawString("Data Memory", getWidth()/2 - 20, getHeight()/2 + 80);
		
		
		
	}

	public static void main(String [] args){
		DataMemory p = new DataMemory();
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}

}
