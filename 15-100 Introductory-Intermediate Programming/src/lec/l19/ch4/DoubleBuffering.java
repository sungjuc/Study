package lec.l19.ch4;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DoubleBuffering extends Applet implements MouseMotionListener {

	Graphics bufferGraphics;
	Image offscreen;
	Dimension dim;
	int curX, curY;

	public void init() {
		dim = getSize();
		addMouseMotionListener(this);
		setBackground(Color.black);
		offscreen = createImage(dim.width, dim.height);
		bufferGraphics = offscreen.getGraphics();
	}

	public void paint(Graphics g) {
		bufferGraphics.clearRect(0, 0, dim.height, dim.height);
		bufferGraphics.setColor(Color.red);
		bufferGraphics.drawString("Bad Double-buffered", 10, 10);
		bufferGraphics.fillRect(curX, curY, 20, 20);
		g.drawImage(offscreen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		curX = evt.getX();
		curY = evt.getY();
		repaint();
	}

}
