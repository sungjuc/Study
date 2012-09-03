package lec.l19.ch1;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;

public class LayoutExample extends Applet {

	Button okButton1;
	Button okButton2;
	Button okButton3;
	Button okButton4;
	Button okButton5;

	public void init() {
		setLayout(new BorderLayout());
		okButton1 = new Button("Centered Button");
		okButton2 = new Button("Cold North");
		okButton3 = new Button("Go West");
		okButton4 = new Button("At East");
		okButton5 = new Button("Hot South");
		
		add(okButton1, "Center");
		add(okButton2, "North");
		add(okButton3, "North");
		add(okButton4, "East");
		add(okButton5, "South");
	}
}
