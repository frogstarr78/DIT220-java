import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorldApplet extends JApplet {
	   
	private String currentMessage = "Hello World!"; // Currently displayed message.
	private MessageDisplay displayPanel;  // The panel where the message is displayed.

	private class MessageDisplay extends JPanel {   // Defines the display panel.
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(currentMessage, 20, 30);
		}
	}

	public void init() {

	displayPanel = new MessageDisplay();

	JPanel content = new JPanel();
	content.setLayout(new BorderLayout());
	content.add(displayPanel, BorderLayout.CENTER);

	setContentPane(content);
	}

}
