package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class InstructionMemory extends JPanel {

	Color color;
	
	/**
	 * Create the panel.
	 */
	public InstructionMemory() {
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
		g2.drawRect((getWidth()-130)/2, (getHeight()-170)/2, 130, 170);
		g2.drawString("Instruction", (getWidth()-20)/2, getHeight()/2 + 50);
		g2.drawString("Memory", (getWidth()-20)/2, getHeight()/2 + 70);
		
		
		
	}

	public static void main(String [] args){
		InstructionMemory p = new InstructionMemory();
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}


}
