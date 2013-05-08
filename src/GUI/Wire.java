package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Wire extends JPanel {
	
	Color color;

	/**
	 * Create the panel.
	 */
	public Wire() {
		setOpaque(false);
	}
	
	public void setColor(Color c){
		color = c;
	}
	

	public static void main(String [] args){
		Wire p = new VerticalWire();
		p.setColor(Color.pink);
		JFrame app = new JFrame ();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.add(p);
	}


}
