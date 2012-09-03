package lec.l26;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

public class Grid extends ComponentAdapter
{
  private Color[][] colors;
  private String[][] images;
  private int cellWidth;
  private int cellHeight;
  private Color lineColor;
  private DrawWindow window;
  
  public Grid(int numRows, int numCols)
  {
    cellWidth = 800 / numCols;
    cellHeight = 600 / numRows;
    if (cellWidth > cellHeight)
      cellWidth = cellHeight;
    else
      cellHeight = cellWidth;    

    init(numRows, numCols, true);
  }
  
  public Grid(int numRows, int numCols, int cellWidth, int cellHeight)
  {
    this.cellWidth = cellWidth;
    this.cellHeight = cellHeight;
    init(numRows, numCols, false);
  }
  
  private void init(int numRows, int numCols, boolean allowResize)
  {
    window = new DrawWindow(numCols * cellWidth, numRows * cellHeight);
    window.setTitle("Grid");
    if (allowResize)
    {
      window.setResizable(true);
      window.addComponentListener(this);
    }
    else
      window.setResizable(false);
    colors = new Color[numRows][numCols];
    images = new String[numRows][numCols];
    lineColor = null;
    for (int row = 0; row < numRows; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        colors[row][col] = new Color(0, 0, 0);
        images[row][col] = null;
      }
    }
    drawAllCells();
  }
  
  private void drawAllCells()
  {
    for (int row = 0; row < getNumRows(); row++)
    {
      for (int col = 0; col < getNumCols(); col++)
        drawCell(row, col);
    }
  }
  
  public Grid(String imageFileName)
  {
    BufferedImage image;
    URL url = Grid.class.getResource(imageFileName);
    if (url == null)
      throw new RuntimeException("cannot find file:  " + imageFileName);
    try
    {
      image = ImageIO.read(url);
    }
    catch(IOException e)
    {
      throw new RuntimeException("unable to read from file:  " + imageFileName);
    }
    
    cellWidth = 1;
    cellHeight = 1;
    init(image.getHeight(), image.getWidth(), false);

    for (int row = 0; row < getNumRows(); row++)
    {
      for (int col = 0; col < getNumCols(); col++)
      {
        int c = image.getRGB(col, row);
        int red = (c & 0x00ff0000) >> 16;
        int green = (c & 0x0000ff00) >> 8;
        int blue = c & 0x000000ff;
        setColor(row, col, new Color(red, green, blue));
      }
    }

    window.setTitle(imageFileName);
  }
  
  public int getNumRows()
  {
    return colors.length;
  }
  
  public int getNumCols()
  {
    return colors[0].length;
  }
  
  public boolean isValid(int row, int col)
  {
    return row >= 0 && row < getNumRows() && col >= 0 && col < getNumCols();
  }
  
  private void checkLoc(int row, int col)
  {
    if (!isValid(row, col))
      throw new RuntimeException("invalid location " + loc(row, col));
  }
  
  private String loc(int row, int col)
  {
    return "(" + row + ", " + col + ")";
  }
  
  public Color getColor(int row, int col)
  {
    checkLoc(row, col);
    return colors[row][col];
  }
  
  private void drawCell(int row, int col)
  {
    window.setColor(colors[row][col]);
    window.setFill(true);
    int x = col * cellWidth;
    int y = row * cellHeight;
    window.drawRectangle(x, y, cellWidth, cellHeight);
    String imageFile = images[row][col];
    if (imageFile != null)
    {
      URL url = Grid.class.getResource(imageFile);
      if (url == null)
        throw new RuntimeException("Cannot find file:  " + imageFile);
      ImageIcon icon = new ImageIcon(url);
      Image image = icon.getImage();
      int originalImageWidth = image.getWidth(null);
      int originalImageHeight = image.getHeight(null);
      int imageX;
      int imageY;
      int drawImageWidth;
      int drawImageHeight;
      if (originalImageWidth * cellHeight > originalImageHeight * cellWidth)
      {
        //wide image
        drawImageWidth = cellWidth;
        imageX = x;
        drawImageHeight = drawImageWidth * originalImageHeight / originalImageWidth;
        imageY = y + (cellHeight - drawImageHeight) / 2;
      }
      else
      {
        //tall image
        drawImageHeight = cellHeight;
        imageY = y;
        drawImageWidth = drawImageHeight * originalImageWidth / originalImageHeight;
        imageX = x + (cellWidth - drawImageWidth) / 2;
      }
      window.drawImage(imageX, imageY, drawImageWidth, drawImageHeight, image);
    }
    if (lineColor != null)
    {
      window.setColor(lineColor);
      window.setFill(false);
      window.drawRectangle(x, y, cellWidth, cellHeight);
    }
  }
  
  private boolean validColor(int n)
  {
    return n >= 0 && n <= 255;
  }
  
  public void setColor(int row, int col, Color color)
  {
    checkLoc(row, col);
    Color oldColor = colors[row][col];
    if (color.equals(oldColor))
      //same color.  do nothing
      return;
    colors[row][col] = color;
    drawCell(row, col);
  }
  
  public void setImage(int row, int col, String image)
  {
    checkLoc(row, col);
    String oldImage = images[row][col];
    if (oldImage == null && image == null ||
        oldImage != null && image != null && image.equals(oldImage))
      //same image.  do nothing.
      return;
    images[row][col] = image;
    drawCell(row, col);
  }
  
  public String getImage(int row, int col)
  {
    checkLoc(row, col);
    return images[row][col];
  }
  
  public void setLineColor(Color c)
  {
    lineColor = c;
    for (int row = 0; row < getNumRows(); row++)
    {
      for (int col = 0; col < getNumCols(); col++)
        drawCell(row, col);
    }
  }
  
  //returns {row, col} of last mouse click, or null if no click since last call to checkMouse
  public int[] checkMouse()
  {
    int[] click = window.checkMouse();
    if (click == null)
      return null;
    else
      return new int[]{click[1] / cellHeight, click[0] / cellWidth};
  }

  public void setTitle(String title)
  {
    window.setTitle(title);
  }
  
  public void componentResized(ComponentEvent e)
  {
    cellWidth = window.getWidth() / getNumCols();
    cellHeight = window.getHeight() / getNumRows();
    if (cellWidth > cellHeight)
      cellWidth = cellHeight;
    else
      cellHeight = cellWidth;
    window.resizeImage();
    drawAllCells();
  }
  
  public void showMessageDialog(String message)
  {
    JOptionPane.showMessageDialog(window, message);
  }
}