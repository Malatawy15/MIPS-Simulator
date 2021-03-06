package GUI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class HorizontalWire extends Wire {

	/**
	 * Create the panel.
	 */
	public HorizontalWire() {

	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.setStroke(new BasicStroke(2));
		super.paintComponent(g2);
		Dimension d = this.getSize();
		if(text == "EMPTY")
			g2.drawLine(0,d.height/2,d.width,d.height/2);
		else{
			g2.drawLine(0,d.height,d.width,d.height);
			g2.drawString(text, (getWidth()-40)/2, getHeight()-1);
		}
		
		
	}

}
