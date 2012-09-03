package lec.l26;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import javax.swing.*;

public class DrawWindow extends JComponent implements MouseListener
{
  private JFrame frame;
  private BufferedImage image;
  private Color color;
  private boolean filled;
  private int fontSize;
  private Point click;
  
  public DrawWindow(int width, int height)
  {
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    color = Color.BLACK;
    filled = false;
    fontSize = 12;
    click = null;
    
    frame = new JFrame();
    frame.setTitle("Draw");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout());
    
    this.setPreferredSize(new Dimension(width, height));
    this.addMouseListener(this);
    frame.getContentPane().add(this, BorderLayout.CENTER);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  public void setTitle(String title)
  {
    frame.setTitle(title);
  }
  
  public void setColor(Color c)
  {
    color = c;
  }
  
  public void setFill(boolean isFilled)
  {
    filled = isFilled;
  }
  
  public void setFont(int size)
  {
    fontSize = size;
  }
  
  public void drawLine(int x1, int y1, int x2, int y2)
  {
    Graphics g = image.getGraphics();
    g.setColor(color);
    g.drawLine(x1, y1, x2, y2);
    repaint();
  }
  
  public void drawRectangle(int x, int y, int width, int height)
  {
    Graphics g = image.getGraphics();
    g.setColor(color);
    if (filled)
      g.fillRect(x, y, width, height);
    else
      g.drawRect(x, y, width, height);
    repaint();
  }
  
  public void drawOval(int x, int y, int width, int height)
  {
    Graphics g = image.getGraphics();
    g.setColor(color);
    if (filled)
      g.fillOval(x, y, width, height);
    else
      g.drawOval(x, y, width, height);
    repaint();
  }
  
  public void drawText(int x, int y, String text)
  {
    Graphics g = image.getGraphics();
    g.setColor(color);
    Font font = new Font(null, Font.PLAIN, fontSize);
    g.setFont(font);
    FontMetrics metrics = g.getFontMetrics();
    int actualX = x - metrics.stringWidth(text) / 2;
    int actualY = y + metrics.getAscent() / 2;
    g.drawString(text, actualX, actualY);
    repaint();
  }
  
  public void drawImage(int x, int y, int width, int height, String file)
  {
    URL url = DrawWindow.class.getResource(file);
    if (url == null)
      throw new RuntimeException("Cannot find file:  " + file);
    ImageIcon icon = new ImageIcon(url);
    drawImage(x, y, width, height, icon.getImage());
  }

  public void drawImage(int x, int y, int width, int height, Image imageToDraw)
  {
    Graphics g = image.getGraphics();
    g.drawImage(imageToDraw, x, y, width, height, null);
    repaint();
  }

  public int[] checkMouse()
  {
    if (click == null)
      return null;
    
    Point temp = click;
    click = null;
    return new int[]{(int)temp.getX(), (int)temp.getY()};
  }
  
  public void paintComponent(Graphics g)
  {
    g.drawImage(image, 0, 0, null);
  }

  public void mouseExited(MouseEvent e)
  {
  }
  
  public void mouseEntered(MouseEvent e)
  {
  }
  
  public void mouseReleased(MouseEvent e)
  {
  }
  
  public void mousePressed(MouseEvent e)
  {
    click = e.getPoint();
  }
  
  public void mouseClicked(MouseEvent e)
  {
  }
  
  public Color getColor(int x, int y)
  {
    int c = image.getRGB(x, y);
    int red = (c & 0x00ff0000) >> 16;
    int green = (c & 0x0000ff00) >> 8;
    int blue = c & 0x000000ff;
    return new Color(red, green, blue);
  }
  
  public void setResizable(boolean enable)
  {
    frame.setResizable(enable);
  }
  
  public void resizeImage()
  {
    int width = getWidth();
    int height = getHeight();
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
  }
}