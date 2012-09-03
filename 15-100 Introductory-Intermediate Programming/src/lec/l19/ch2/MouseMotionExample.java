package lec.l19.ch2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionExample extends Applet implements MouseMotionListener {

	int xpos;
	int ypos;

	int rect1xco, rect1yco, rect1width, rect1height;

	boolean rect1Active;

	public void init() {
		rect1xco = 20;
		rect1yco = 20;
		rect1width = 100;
		rect1height = 50;

		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		if (rect1Active)
			g.setColor(Color.green);
		else
			g.setColor(Color.red);

		g.fillRect(rect1xco, rect1yco, rect1width, rect1height);
		g.setColor(Color.blue);

		g.drawString("(" + xpos + "," + ypos + ")", xpos, ypos);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		xpos = me.getX();
		ypos = me.getY();

		if (xpos > rect1xco && xpos < rect1xco + rect1width && ypos > rect1yco
				&& ypos < rect1yco + rect1height)
			rect1Active = true;
		else
			rect1Active = false;

		repaint();
	}

}
