import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InvalidDiceValueException extends Exception {
	public InvalidDiceValueException(int dieValue) {
		super("Di[c]e result [" + dieValue + "] invalid\n");
	}
}

public class DicePanel extends JApplet {

	private class DicePanelDisplay extends JPanel {   // Defines the display panel.
		Graphics graphics;
		BaseDieClass die1,die2;

		public DicePanelDisplay() {
			super();

			try {
				die1 = new BaseDieClass(g);
				die1.setLayout(BaseDieClass.LEFT);
				die1.paintByNumber(randomDieNumber());

				die2 = new BaseDieClass(g);
				die2.setLayout(BaseDieClass.RIGHT);
				die2.paintByNumber(randomDieNumber());
			} catch (InvalidDiceValueException e) {
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
	}

	private DicePanelDisplay displayPanel;

	private class ButtonHandler implements ActionListener {  // The event listener.
		public void actionPerformed(ActionEvent e) {
			roll();
			displayPanel.repaint(); // Paint display panel with new message.
		}
	}

	public void roll() {
		BaseDieClass die1=null, die2=null;

		try {
			for(int i=0; i<randomNumberTo(10); i++) {
				if (die1 != null) {
					die1.dispose();	
				}
				die1.paintByNumber(randomDieNumber());
			}

			for(int i=0; i<randomNumberTo(10); i++) {
				if (die2 != null) {
					die2.dispose();	
				}
				die2.paintByNumber(randomDieNumber());
			}
		} catch(InvalidDiceValueException e) {
		
		}
		repaint();
	}

	public static int randomNumberTo(int maxNumber) throws InvalidDiceValueException {
		int res;
		res = (((int)(100 * Math.random())) % maxNumber)+1;

		if(res < 1 || res > maxNumber) {
			throw new InvalidDiceValueException(res);
		}
		return res;
	}

	public static int randomDieNumber() throws InvalidDiceValueException {
		return randomNumberTo(6);
	}

	public DicePanel() { }

	public void init() {
		BaseDieClass die1,die2;
		displayPanel = new DicePanelDisplay();
		JButton rollButton;

		displayPanel.setLayout(new BorderLayout());
/*		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(displayPanel, BorderLayout.CENTER);*/
		displayPanel.setLayout(new BorderLayout());
		rollButton = new JButton("Roll");

		ButtonHandler listener = new ButtonHandler();
		rollButton.addActionListener(listener);

//		content.add(rollButton, BorderLayout.SOUTH);
		displayPanel.add(rollButton, BorderLayout.SOUTH);
		this.setContentPane(displayPanel);

//		this.setContentPane(content);
	}

}
