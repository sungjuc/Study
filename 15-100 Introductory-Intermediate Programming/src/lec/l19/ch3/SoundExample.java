package lec.l19.ch3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SoundExample extends Applet implements MouseListener {

	AudioClip soundFile1;
	AudioClip soundFile2;

	public void init() {
		soundFile1 = getAudioClip(getDocumentBase(), "dataS.au");
		soundFile2 = getAudioClip(getDocumentBase(), "shootS.au");

		addMouseListener(this);

		setBackground(Color.yellow);
		soundFile1.play();
	}

	public void paint(Graphics g) {
		g.drawString("Click to hear a sound", 20, 20);
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		soundFile2.play();
	}

	@Override
	public void mouseEntered(MouseEvent evt) {
	}

	@Override
	public void mouseExited(MouseEvent evt) {
	}

	@Override
	public void mousePressed(MouseEvent evt) {
	}

	@Override
	public void mouseReleased(MouseEvent evt) {
	}

}
