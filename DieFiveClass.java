import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DieFiveClass extends BaseDieClass {
	public DieFiveClass (Graphics g, int x, int y) {
		super(g, 5, x, y);	
	}	
	protected void paintPips() {
		this.graphics.fillOval(this.xCoord+25, this.yCoord+25, 10, 10);
		this.graphics.fillOval(this.xCoord+25, this.yCoord+85, 10, 10);
		this.graphics.fillOval(this.xCoord+55, this.yCoord+55, 10, 10);
		this.graphics.fillOval(this.xCoord+85, this.yCoord+25, 10, 10);
		this.graphics.fillOval(this.xCoord+85, this.yCoord+85, 10, 10);
	}
}
