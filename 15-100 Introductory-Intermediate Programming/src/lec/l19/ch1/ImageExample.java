package lec.l19.ch1;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

public class ImageExample extends Applet {
	Image my_gif;
	URL base;
	MediaTracker mt;

	public void init() {
		mt = new MediaTracker(this);

		try {
			base = getDocumentBase();
		} catch (Exception e) {
		}

		my_gif = getImage(base, "imageExample.gif");
		mt.addImage(my_gif, 1);

		try {
			mt.waitForAll();
		} catch (InterruptedException e) {
		}
	}

	public void paint(Graphics g) {
		g.drawImage(my_gif, 20, 20, this);
		g.drawImage(my_gif, 20, 140, 30, 40, this);
	}
}
