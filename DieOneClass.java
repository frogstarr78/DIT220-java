import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DieOneClass extends BaseDieClass {
	public DieOneClass (Graphics g, int x, int y) {
		super(g, 1, x, y);	
	}	
	protected void paintPips() {
		this.graphics.fillOval(this.xCoord+55, this.yCoord+55, 10, 10);
	}
}
