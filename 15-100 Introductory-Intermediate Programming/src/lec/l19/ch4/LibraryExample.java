package lec.l19.ch4;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import lec.l19.ch4.lib.HotSpot;
import lec.l19.ch4.lib.Loadable;
import lec.l19.ch4.lib.HotSpotListener;
import lec.l19.ch4.lib.RealMedia;

public class LibraryExample extends Applet implements Loadable, HotSpotListener {
	RealMedia rm;
	HotSpot hs1, hs2;
	int x = 1;

	public void init() {
		setLayout(null);
		setBackground(Color.black);

		rm = new RealMedia(this);
		rm.add("alien4DS.gif", "alien4");
		rm.add("alien5DS.jpg", "alien5");

		rm.add("bt1c.gif");
		rm.add("bt2c.gif");
		rm.add("bt3c.gif");

		rm.add("bt1b.gif");
		rm.add("bt2b.gif");
		rm.add("bt3b.gif");

		rm.load();
	}

	@Override
	public void startUp() {
		hs1 = new HotSpot(this);
		hs1.setImage(rm.get("bt1c.gif"), 1);
		hs1.setImage(rm.get("bt2c.gif"), 2);
		hs1.setImage(rm.get("bt3c.gif"), 3);
		hs1.setBounds(50, 250, 80, 40);

		hs2 = new HotSpot(this);
		hs2.setImage(rm.get("bt1b.gif"), 1);
		hs2.setImage(rm.get("bt2b.gif"), 2);
		hs2.setImage(rm.get("bt3b.gif"), 3);
		hs2.setBounds(170, 250, 80, 40);

		add(hs1);
		add(hs2);

		hs1.repaint();
		hs2.repaint();
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);

		if (!rm.isLoaded()) {
			g.drawString("loading file " + rm.getCurrent(), 20, 20);
			g.drawString("of " + rm.getTotalFiles(), 20, 40);
			g.drawString("Percent: " + rm.getPercent(), 20, 60);
			g.fillRect(20, 80, rm.getPercent(), 20);
		} else {
			if (x == 1)
				g.drawImage(rm.get("alien4"), 20, 20, this);
			else
				g.drawImage(rm.get("alien5"), 20, 20, this);
		}
	}

	@Override
	public void hotSpotEvent(HotSpot hs) {
		if (hs == hs1)
			x = 1;
		else
			x = 2;

		repaint();
	}

	@Override
	public AudioClip loadAudio(String fileName) {
		return getAudioClip(getCodeBase(), fileName);
	}

	@Override
	public Image loadImage(String fileName) {
		return getImage(getCodeBase(), fileName);
	}
}
