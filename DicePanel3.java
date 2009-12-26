import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

public class DicePanel3 extends JPanel {
	public int firstRoll, numberOfRolls, currentRollResult;
	public String buttonText, rollText;
	public JButton rollButton;

	public DicePanel3() {

		setLayout(new BorderLayout());

		ActionListener listener = new ButtonHandler();

		rollButton = new JButton(buttonText);
		rollButton.addActionListener(listener);
		add(rollButton, BorderLayout.SOUTH);
		localInit();
	}

	private class ButtonHandler implements ActionListener {  // The event listener.
		public void actionPerformed(ActionEvent e) {
			if(rollButton.getText() == "Yes") {
				localInit();
			}
			repaint();
		}
	}

	public void localInit () {
		firstRoll = 0;
		numberOfRolls = 0;
		buttonText = "Roll";
		rollButton.setText(buttonText);
		rollButton.repaint();
	}

	public static int randomNumberTo(int maxNumber) { 
		int res;
		res = (((int)(100 * Math.random())) % maxNumber)+1;

		return res;
	}

	public static int randomDieNumber() {
		return randomNumberTo(6);
	}

	public int roll(Graphics g, int x, int y){
		g.drawRoundRect(x, y, 100, 100, 16, 16);
		int dieNumber = randomDieNumber();

		if (dieNumber == 1 || dieNumber == 3 || dieNumber == 5) {
			g.fillOval(x+45, y+45, 10, 10); // center pip
		}
		if (dieNumber == 2 || dieNumber == 3 || dieNumber == 4 || dieNumber == 5 || dieNumber == 6) {
			g.fillOval(x+15, y+15, 10, 10); // top left pip
			g.fillOval(x+75, y+75, 10, 10); // bottom right pip
		}
		if (dieNumber == 4 || dieNumber == 5 || dieNumber == 6) {
			g.fillOval(x+75, y+15, 10, 10); // bottom left pip
			g.fillOval(x+15, y+75, 10, 10); // top right pip
		}
		if (dieNumber == 6) {
			g.fillOval(x+15, y+45, 10, 10); // center left pip
			g.fillOval(x+75, y+45, 10, 10); // center right pip
		}

		return dieNumber;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int leftDieX = 10;
		int leftDieY = 10;
		int rightDieX = 120;
		int rightDieY = 10;
		int die1, die2;

		die1 = roll(g, leftDieX, leftDieY);
		die2 = roll(g, rightDieX, rightDieY);

		numberOfRolls++;

		currentRollResult = die1 + die2;

		if( firstRoll == 0 && numberOfRolls == 1) {
			firstRoll = currentRollResult;
		}

		if(firstRoll != 0 && numberOfRolls > 1 && firstRoll == currentRollResult) {
			g.drawString("Play again?", 15, 130);
			rollButton.setText("Yes");
			rollButton.repaint();
		} else if(firstRoll != currentRollResult) {
			g.drawString("First Roll: " + firstRoll, 15, 130);
		}
	}

}
