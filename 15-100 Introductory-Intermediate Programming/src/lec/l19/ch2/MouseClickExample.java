package lec.l19.ch2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClickExample extends Applet implements MouseListener {

	int xpos;
	int ypos;

	int rect1xco, rect1yco, rect1width, rect1height;

	boolean mouseEntered;
	boolean rect1Clicked;

	public void init() {
		rect1xco = 20;
		rect1yco = 20;
		rect1width = 100;
		rect1height = 50;

		addMouseListener(this);
	}

	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(rect1xco, rect1yco, rect1width, rect1height);
		g.setColor(Color.red);

		g.drawString("(" + xpos + "," + ypos + ")", xpos, ypos);

		if (rect1Clicked)
			g.drawString("You clicked in the rectangle", 20, 120);
		else
			g.drawString("You clicked outside of the rectangle", 20, 120);

		if (mouseEntered)
			g.drawString("Mouse is in the applet area", 20, 160);
		else
			g.drawString("Mouse is outside the applet area", 20, 160);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		xpos = me.getX();
		ypos = me.getY();

		if (xpos > rect1xco && xpos < rect1xco + rect1width && ypos > rect1yco
				&& ypos < rect1height + rect1yco)
			rect1Clicked = true;
		else
			rect1Clicked = false;

		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		mouseEntered = true;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseEntered = false;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
