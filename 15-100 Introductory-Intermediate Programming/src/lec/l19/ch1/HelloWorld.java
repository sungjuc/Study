package lec.l19.ch1;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorld extends Applet {

	public void init() {

	}

	public void stop() {

	}

	public void paint(Graphics g) {
		g.drawString("Hey hey hey", 20, 20);
		g.drawString("Hellooow World", 20, 40);
	}
}
