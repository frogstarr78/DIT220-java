import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DiceApplet extends JApplet {
	DicePanel3 dicePanel;

	public void init() {
		dicePanel = new DicePanel3();

		setContentPane(dicePanel);
	}

}
