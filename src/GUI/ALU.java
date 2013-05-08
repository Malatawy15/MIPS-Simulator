package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ALU extends JPanel {

	Color color;
	/**
	 * Create the panel.
	 */
	public ALU() {
		setOpaque(false);
	}
	
	public void setColor(Color c){
		color = c;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(2));
		super.paintComponent(g2);
		int width = (getWidth() - 100)/2;
		int height = (getHeight() - 160)/2;
		int[] x = { width, width+100, width+100, width, width, width+20, width};
		int[] y = { height, height+40, height+120, height+160, height+100, height+80, height+60};
		g2.drawPolygon(x, y, 7);
		g2.drawString("ALU", width+30, height+80);
	}

	public static void main(String[] args) {
		ALU p = new ALU();
		p.setColor(Color.red);
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(p);
		app.setSize(500, 500);
		app.setVisible(true);
	}

}
