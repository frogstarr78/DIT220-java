import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckerBoard extends JApplet {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Sun Oct 15 21:01:41 PDT 2006
	Chapter 3 Program 6
*/

	public void paint(Graphics g) {
		String color = getParameter("COLOR");
		Color colr;
		int rectWidth = 256, rectHeight = 256, multiplier = 32;

		g.setColor(Color.magenta);
		g.fillRect(0,0,rectWidth,rectHeight);

		for(int row=0; row<8; row++) {
			for (int col=0; col<8; col++) { 
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1)) { 
					g.setColor(Color.green);
					g.fillRect(row*multiplier, col*multiplier, multiplier, multiplier);
				} 
			}
		}
	}
 
}
