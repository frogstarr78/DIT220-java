
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SchizophrenicCheckerBoard extends SimpleAnimationApplet2 {

/*
	Scott Noel-Hemming
	DIT220 Java Programming
	Sun Oct 15 21:01:37 PDT 2006
	Chapter 3 Program 7
*/

	public Color getBackground() {
		return Color.blue;
	}

	public Color getForeground() {
		return Color.green;
	}

	public void drawFrame(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(getForeground());

		int recWidth = getWidth();
		int recHeight = getHeight();
		int multiplier = 32;
		int offset;

		offset = getFrameNumber() % multiplier;

		for(int row=0; row<12; row++) {
			int leftSide;

			if (row % 2 == 0) {
				leftSide = -1*2*multiplier + offset;	
			} else {
				leftSide = -1*2*multiplier - offset;	
			}

			for (int col=0; col<8; col++) { 
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1)) { 
					g.setColor(getForeground());
					g.fillRect(leftSide+row*multiplier, col*multiplier, multiplier, multiplier);
				} 
			}
		}
	}
 
}
