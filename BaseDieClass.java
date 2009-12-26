import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class BaseDieClass {
	protected int xCoord, yCoord, value;
	protected Graphics graphics;
	protected static final int LEFT_DIE = 1;
	protected static final int RIGHT_DIE = 2;

	class InvalidDiceValueException extends Exception {
		public InvalidDiceValueException(int dieValue) {
			super("Di[c]e result [" + dieValue + "] invalid\n");
		}
	}

	public BaseDieClass(Graphics g, int value, int x, int y){
		super();
		this.graphics = g;
		this.value = value;
		this.xCoord = x;
		this.yCoord = y;
	}

	public void setLayout(int layout){}

	protected abstract void paintPips();

	public void paint() {
		this.graphics.drawRoundRect(this.xCoord, this.yCoord, 100, 100, 16, 16);
		this.paintPips();
	}

	public void dispose() {
		this.graphics.dispose();
	}

	public BaseDieClass getDieByValue(int value) throws InvalidDiceValueException {
		switch(value) {
			case 1:
				return new DieOneClass(this.graphics, this.xCoord, this.yCoord);
			case 2:
				return new DieTwoClass(this.graphics, this.xCoord, this.yCoord);
			case 3:
				return new DieThreeClass(this.graphics, this.xCoord, this.yCoord);
			case 4:
				return new DieFourClass(this.graphics, this.xCoord, this.yCoord);
			case 5:
				return new DieFiveClass(this.graphics, this.xCoord, this.yCoord);
			case 6:
				return new DieSixClass(this.graphics, this.xCoord, this.yCoord);
			default: 
				throw new InvalidDiceValueException(value); 
		}
	}

}
