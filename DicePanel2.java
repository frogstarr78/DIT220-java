import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InvalidDiceValueException extends Exception {
	public InvalidDiceValueException(int dieValue) {
		super("Di[c]e result [" + dieValue + "] invalid\n");
	}
}

public class DicePanel2 extends JApplet {

	private DicePanelDisplay displayPanel;


	private class DicePanelDisplay extends JPanel {   // Defines the display panel.

		public DicePanelDisplay() {
			super();
//			BaseDieClass die1, die2;
//			try{
//			die1 = getDieByValue(randomDieNumber(), getGraphics(), 120, 10);
//			die1.paint();
//			die2 = getDieByValue(randomDieNumber(), getGraphics(), 120, 10);
//			die2.paint();
//			} catch(InvalidDiceValueException e){}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
	}
	public static int randomNumberTo(int maxNumber) throws InvalidDiceValueException {
		int res;
		res = (((int)(100 * Math.random())) % maxNumber)+1;

		if(res < 1 || res > 6) {
			throw new InvalidDiceValueException(res);
		}
		return res;
	}

	public static int randomDieNumber() throws InvalidDiceValueException {
		return randomNumberTo(6);
	}

	public BaseDieClass getDieByValue(int value, Graphics g, int xCoord, int yCoord) throws InvalidDiceValueException {
		switch(value) {
			case 1:
				return new DieOneClass(g, xCoord, yCoord);
			case 2:
				return new DieTwoClass(g, xCoord, yCoord);
			case 3:
				return new DieThreeClass(g, xCoord, yCoord);
			case 4:
				return new DieFourClass(g, xCoord, yCoord);
			case 5:
				return new DieFiveClass(g, xCoord, yCoord);
			case 6:
				return new DieSixClass(g, xCoord, yCoord);
			default: 
				throw new InvalidDiceValueException(value); 
		}
	}

	public void roll(Graphics g) {
		BaseDieClass die1, die2;

		try {
			die1 = getDieByValue(randomDieNumber(), g, 10, 10);
//			for(int i=0; i<randomNumberTo(10); i++) {
//				die1.dispose();	
//				die1 = getDieByValue(randomDieNumber(), g, 10, 10);
				die1.paint();
//			}

			die2 = getDieByValue(randomDieNumber(), g, 120, 10);
//			for(int i=0; i<randomNumberTo(10); i++) {
//				die2.dispose();	
//				die2 = getDieByValue(randomDieNumber(), g, 120, 10);
				die2.paint();
//			}
		} catch (InvalidDiceValueException e) {
		}
		displayPanel.repaint();
	}

	public DicePanel2() { }

//	private class ButtonHandler implements ActionListener {  // The event listener.
//		public void actionPerformed(ActionEvent e) {
//			roll(displayPanel.getGraphics());
//		}
//	}

	public void init() {
		displayPanel = new DicePanelDisplay();

		JPanel content = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		content.setLayout(new BorderLayout());
		content.add(displayPanel, BorderLayout.CENTER);

//		this.setContentPane(displayPanel);
		this.setContentPane(content);
		roll(displayPanel.getGraphics());
	}

}
