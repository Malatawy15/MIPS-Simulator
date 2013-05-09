package GUI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class VerticalWire extends Wire {

	/**
	 * Create the panel.
	 */
	public VerticalWire() {

	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(2));
		super.paintComponent(g2);
		Dimension d = this.getSize();
		if(text == "EMPTY")
			g2.drawLine(d.width/2,0,d.width/2,d.height);
		else{
			g2.drawLine(d.width,0,d.width,d.height);
			g2.drawString(text, (getWidth()-40)/2, getHeight()-5);
		}
		
		
		
	}

}
