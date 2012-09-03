package lab.l08;

/*
 * Remember, these lines just give us access to all of the
 * graphics functions, so we can take advantage of the 
 * classes that have been defined by the good folks at Sun.
 */

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 * This is the class that defines the Sketching applet
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 8
 */
public class Sketching extends Applet implements MouseListener, ActionListener,
		MouseMotionListener {
	/*
	 * When the user release the mouse, we'll make changes to these and then
	 * invoke repaint to install them
	 * 
	 * This is a technique known as "double-buffering". It will make this
	 * assignment easier to implement than drawign directly onto the active
	 * Image. And, it is also better, because the active Image will change,
	 * without the redraw being visible.
	 */
	private Graphics nextGraphics;
	private Image nextImage;

	/*
	 * Dimensions of the applet, itself These come from the HTML page's APPLET
	 * tag
	 */
	Dimension appletDim;

	/*
	 * Start and finish control points for graphics objects, such as line, oval,
	 * rectangle, etc.
	 */
	private Point start, finish;

	private ArrayList<Point> polyPoints = new ArrayList<Point>();

	CheckboxGroup menuGroup;
	Checkbox menu1;
	Checkbox menu2;
	Checkbox menu3;
	Checkbox menu4;

	CheckboxGroup colorGroup;
	Checkbox color1;
	Checkbox color2;
	Checkbox color3;
	Checkbox color4;
	Checkbox color5;

	CheckboxGroup shapeGroup;
	Checkbox shape1;
	Checkbox shape2;
	Checkbox shape3;
	Checkbox shape4;

	// Polyline and polygon related variables
	Button polygonDrawButton;
	Button polylineDrawButton;

	int[] xPoints;
	int[] yPoints;

	// Brush related variables
	int oldX = -1;
	int oldY = -1;

	// File related variables
	Image my_gif;
	URL base;
	MediaTracker mt;

	/*
	 * This method is called when the applet is initialized
	 */
	public void init() {
		appletDim = getSize(); // size of the applet, itself

		// Added to set the layout
		setLayout(new BorderLayout());

		/*
		 * Create the buffer that we'll use to store out changes to the screen,
		 * before we actually paint them onto the screen.
		 * 
		 * This involves creating a new Image, and then extracting the Graphics
		 * object, the actual screen-map, from it.
		 */
		nextImage = createImage(appletDim.width, appletDim.height);
		nextGraphics = nextImage.getGraphics();

		/*
		 * Add code here to set the foreground color to white, and then to draw
		 * a box the size of the applet. Remember, we want to draw to
		 * "nextGraphics". paint() is automatically called after init(), so we
		 * don't need to call repaint()
		 */
		setForeground(Color.white);
		nextGraphics.drawRect(0, 0, appletDim.width, appletDim.height);

		/*
		 * Then, change the color back to something different, maybe black, so
		 * that what is drawn on the screen will be visible.
		 */
		setForeground(Color.black);

		/*
		 * Instruct the applet to watch for mouse events
		 */
		addMouseListener(this);
		addMouseMotionListener(this);

		// Panel adding
		Panel menuPanel = getMenuPanel();
		add(BorderLayout.NORTH, menuPanel);

		Panel colorPanel = getColorPanel();
		add(BorderLayout.WEST, colorPanel);

		Panel shapePanel = getShapePanel();
		add(BorderLayout.EAST, shapePanel);

		Panel buttonPanel = getCommandPanel();
		add(BorderLayout.SOUTH, buttonPanel);

		polygonDrawButton.setVisible(false);
		polylineDrawButton.setVisible(false);

		// Prepare images
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

	/**
	 * Returns the panel contains the color check box.
	 * 
	 * @return the Panel object.
	 */
	private Panel getMenuPanel() {
		Panel panel = new Panel();
		panel.setBackground(Color.yellow);
		menuGroup = new CheckboxGroup();
		menu1 = new Checkbox("Shape", menuGroup, true);
		menu2 = new Checkbox("Poly", menuGroup, false);
		menu3 = new Checkbox("Brush", menuGroup, false);
		menu4 = new Checkbox("File", menuGroup, false);

		panel.setLayout(new GridLayout(1, 4));

		panel.add(menu1);
		panel.add(menu2);
		panel.add(menu3);
		panel.add(menu4);

		return panel;
	}

	/**
	 * Returns the panel contains the color check box.
	 * 
	 * @return the Panel object.
	 */
	private Panel getColorPanel() {
		Panel panel = new Panel();
		panel.setBackground(Color.cyan);
		colorGroup = new CheckboxGroup();
		color1 = new Checkbox("Black", colorGroup, true);
		color2 = new Checkbox("Red", colorGroup, false);
		color3 = new Checkbox("Green", colorGroup, false);
		color4 = new Checkbox("Yellow", colorGroup, false);
		color5 = new Checkbox("Blue", colorGroup, false);

		panel.setLayout(new GridLayout(5, 1));

		panel.add(color1);
		panel.add(color2);
		panel.add(color3);
		panel.add(color4);
		panel.add(color5);

		return panel;
	}

	/**
	 * Returns the panel contains the shape check box.
	 * 
	 * @return the Panel object.
	 */
	private Panel getShapePanel() {
		Panel panel = new Panel();

		panel.setBackground(Color.cyan);
		shapeGroup = new CheckboxGroup();
		shape1 = new Checkbox("Line", shapeGroup, true);
		shape2 = new Checkbox("Rectan", shapeGroup, false);
		shape3 = new Checkbox("Circle", shapeGroup, false);
		shape4 = new Checkbox("Oval", shapeGroup, false);

		panel.setLayout(new GridLayout(5, 1));

		panel.add(shape1);
		panel.add(shape2);
		panel.add(shape3);
		panel.add(shape4);

		return panel;
	}

	public Panel getCommandPanel() {
		Panel panel = new Panel();
		panel.setBackground(Color.gray);
		polygonDrawButton = new Button("Draw Polygon!");
		polylineDrawButton = new Button("Draw Polyline!");
		polygonDrawButton.addActionListener(this);
		polylineDrawButton.addActionListener(this);
		panel.setLayout(new GridLayout(1, 2));
		panel.add(polygonDrawButton);
		panel.add(polylineDrawButton);
		return panel;
	}

	/*
	 * This is used, sometimes automatically, and sometimes explicitly by the
	 * program, to redraw the screen In this case, we prepare "nextImage" in
	 * advance. When we want to redraw the screen, for example after a mouse
	 * event that adds an object, we adjust nextImage, and then call repaint(),
	 * which in turn calls this method.
	 */
	public void paint(Graphics g) {
		g.clearRect(0, 0, appletDim.height, appletDim.height);
		g.drawImage(nextImage, 0, 0, this);
	}

	/*
	 * If the mouse is pressed, it is a starting point. So, we want to mark it
	 * with a dot and store it for later, so we can draw the object
	 */
	public void mousePressed(MouseEvent me) {
		// Save the current position of the mouse into
		start = new Point(me.getX(), me.getY());

		// Color changes
		if (color1.getState())
			nextGraphics.setColor(Color.black);
		else if (color2.getState())
			nextGraphics.setColor(Color.red);
		else if (color3.getState())
			nextGraphics.setColor(Color.green);
		else if (color4.getState())
			nextGraphics.setColor(Color.yellow);
		else if (color5.getState())
			nextGraphics.setColor(Color.blue);

		if (menu2.getState())
			polyPoints.add(start);

		if (menu1.getState() || menu2.getState() || menu3.getState())
			if (!shape3.getState() && !shape4.getState())
				nextGraphics.drawRect(start.x, start.y, 0, 0);

		if (menu4.getState())
			// nextGraphics.drawImage(my_gif, me.getX(), me.getY(), this);
			nextGraphics.drawImage(my_gif, me.getX(), me.getY(), this);

		/*
		 * You might want to draw a dot so the user can see the original point
		 * while moving the mouse to the second point
		 * 
		 * If you want to do this, you can do it by drawing a line 1 pixel long.
		 * You want to draw onto "nextGraphics" and then call repaint() to
		 * install "nextgraphics" on the screen.
		 * 
		 * Otherwise, you can just save the point and draw the object when the
		 * user releases the mouse at the second point.
		 */
		repaint();
	}

	/*
	 * When the mouse is released it is time to draw the object. So, we find the
	 * point, set the color, and draw the right shape
	 */
	public void mouseReleased(MouseEvent me) {

		if (menu1.getState()) {
			// Save the end point
			finish = new Point(me.getX(), me.getY());

			// Draw the shape or line onto "nextGraphics"
			if (shape1.getState())
				nextGraphics.drawLine(start.x, start.y, finish.x, finish.y);
			else if (shape2.getState())
				nextGraphics.drawRect(start.x, start.y, finish.x - start.x,
						finish.y - start.y);
			else if (shape3.getState())
				nextGraphics.drawOval(start.x, start.y, finish.x - start.x,
						finish.x - start.x);
			else if (shape4.getState())
				nextGraphics.drawOval(start.x, start.y, finish.x - start.x,
						finish.y - start.y);
		}
		if (menu2.getState())
			if (polyPoints.size() > 2) {
				polygonDrawButton.setVisible(true);
				polylineDrawButton.setVisible(true);
			} else {
				polygonDrawButton.setVisible(false);
				polylineDrawButton.setVisible(false);
			}
		else {
			polygonDrawButton.setVisible(false);
			polylineDrawButton.setVisible(false);
		}

		if (menu3.getState())
			oldX = oldY = -1;

		// Call repaint, so the change can be seen.
		repaint();
	}

	/*
	 * We didn't need these actions. But, we do need to define them, or we
	 * haven't complied with the MouseAction interface.
	 */

	// This is received, if the user momentarily presses the mouse button
	public void mouseClicked(MouseEvent me) {
	}

	// This is received, if the mouse enters the applet area from outside
	public void mouseEntered(MouseEvent me) {
	}

	// This is received, if the mouse exits the applet area from outside
	public void mouseExited(MouseEvent me) {
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// polygon draw button handler
		if (evt.getSource() == polygonDrawButton) {
			int[] xPoints = new int[polyPoints.size()];
			int[] yPoints = new int[polyPoints.size()];

			for (int i = 0; i < polyPoints.size(); i++) {
				xPoints[i] = polyPoints.get(i).x;
				yPoints[i] = polyPoints.get(i).y;
			}
			nextGraphics.drawPolygon(xPoints, yPoints, polyPoints.size());
			polyPoints = new ArrayList<Point>();
		}

		// polyline draw button handler
		if (evt.getSource() == polylineDrawButton) {
			int[] xPoints = new int[polyPoints.size()];
			int[] yPoints = new int[polyPoints.size()];

			for (int i = 0; i < polyPoints.size(); i++) {
				xPoints[i] = polyPoints.get(i).x;
				yPoints[i] = polyPoints.get(i).y;
			}
			nextGraphics.drawPolyline(xPoints, yPoints, polyPoints.size());
			polyPoints = new ArrayList<Point>();
		}

		// Repaint
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent evt) {

		if (menu3.getState()) {
			if (oldX > 0 && oldY > 0)
				nextGraphics.drawLine(evt.getX(), evt.getY(), oldX, oldY);
			oldX = evt.getX();
			oldY = evt.getY();
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent evt) {

	}
}
