package lec.l19.ch3;

import java.applet.Applet;
import java.awt.Graphics;

public class ParameterExample extends Applet {
	String parameter1;
	int parameter2;
	int parameter3;
	int result;

	public void init() {
		parameter1 = getParameter("param1");
		parameter2 = Integer.parseInt(getParameter("param2"));
		parameter3 = Integer.parseInt(getParameter("param3"));
		result = parameter2 + parameter3;
	}

	public void paint(Graphics g) {
		g.drawString("Parameter 1 is: " + parameter1, 20, 20);
		g.drawString("Parameter 2 is: " + parameter2, 20, 40);
		g.drawString("Parameter 3 is: " + parameter3, 20, 60);
		g.drawString("Parameter 2 + parameter 3 is: " + result, 20, 80);
	}
}
