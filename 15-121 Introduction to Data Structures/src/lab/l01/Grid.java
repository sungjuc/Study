package lab.l01;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;

public class Grid
{
  private static Color[][] colors;
  private static String[][] images;
  private static int cellSize;
  private static Color lineColor;
  private static boolean created = false;
  
  public static void window(int numRows, int numCols)
  {
    if (numCols > numRows)
      cellSize = 600 / numCols;
    else
      cellSize = 600 / numRows;
    Draw.window(numCols * cellSize, numRows * cellSize);
    Draw.setTitle("Grid");
    colors = new Color[numRows][numCols];
    images = new String[numRows][numCols];
    lineColor = null;
    for (int row = 0; row < numRows; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        colors[row][col] = new Color(0, 0, 0);
        images[row][col] = null;
        drawCell(row, col);
      }
    }
    created = true;
  }
  
  public static void window(String imageFileName)
  {
    BufferedImage image = loadImage(imageFileName);
    window(image.getWidth(), image.getHeight());
    showImage(image);
    Draw.setTitle(imageFileName);
  }
  
  private static BufferedImage loadImage(String imageFileName)
  {
    URL url = Grid.class.getResource(imageFileName);
    if (url == null)
      throw new RuntimeException("cannot find file:  " + imageFileName);
    try
    {
      return ImageIO.read(url);
    }
    catch(IOException e)
    {
      throw new RuntimeException("unable to read from file:  " + imageFileName);
    }
  }
  
  private static void showImage(BufferedImage image)
  {
    for (int row = 0; row < getNumRows(); row++)
    {
      for (int col = 0; col < getNumCols(); col++)
      {
        int x = col * image.getWidth() / getNumCols();
        int y = row * image.getHeight() / getNumRows();
        int c = image.getRGB(x, y);
        int red = (c & 0x00ff0000) >> 16;
        int green = (c & 0x0000ff00) >> 8;
        int blue = c & 0x000000ff;
        setColor(row, col, red, green, blue);
      }
    }
  }
  
  public static int getNumRows()
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    return colors.length;
  }
  
  public static int getNumCols()
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    return colors[0].length;
  }
  
  public static boolean isValid(int row, int col)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    return col >= 0 && col < getNumCols() && row >= 0 && row < getNumRows();
  }
  
  private static void checkLoc(int row, int col)
  {
    if (!isValid(row, col))
      throw new RuntimeException("invalid location " + loc(row, col));
  }
  
  public static String loc(int row, int col)
  {
    return "(" + row + ", " + col + ")";
  }
  
  public static int getRed(int row, int col)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    checkLoc(row, col);
    return colors[row][col].getRed();
  }
  
  public static int getGreen(int row, int col)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    checkLoc(row, col);
    return colors[row][col].getGreen();
  }
  
  public static int getBlue(int row, int col)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    checkLoc(row, col);
    return colors[row][col].getBlue();
  }
  
  private static void drawCell(int row, int col)
  {
    Color color = colors[row][col];
    Draw.setColor(color.getRed(), color.getGreen(), color.getBlue());
    Draw.setFill(true);
    Draw.rectangle(col * cellSize, row * cellSize, cellSize, cellSize);
    String image = images[row][col];
    if (image != null)
      Draw.image(col * cellSize, row * cellSize, cellSize, cellSize, image);
    if (lineColor != null)
    {
      Draw.setColor(lineColor.getRed(), lineColor.getGreen(), lineColor.getBlue());
      Draw.setFill(false);
      Draw.rectangle(col * cellSize, row * cellSize, cellSize, cellSize);
    }
  }
  
  private static boolean validColor(int n)
  {
    return n >= 0 && n <= 255;
  }
  
  private static void checkColor(int red, int green, int blue)
  {
    if (!validColor(red) || !validColor(green) || !validColor(blue))
      throw new RuntimeException("invalid color " + red + ", " +
                                 green + ", " + blue);
  }
  
  public static void setColor(int row, int col, int red, int green, int blue)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    checkLoc(row, col);
    checkColor(red, green, blue);
    colors[row][col] = new Color(red, green, blue);
    drawCell(row, col);
  }
  
  public static void setImage(int row, int col, String image)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    checkLoc(row, col);
    images[row][col] = image;
    drawCell(row, col);
  }
  
  public static String getImage(int row, int col)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    checkLoc(row, col);
    return images[row][col];
  }
  
  public static void setLineColor(int red, int green, int blue)
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    if (red < 0)
      lineColor = null;
    else
      lineColor = new Color(red, green, blue);
    for (int row = 0; row < getNumRows(); row++)
    {
      for (int col = 0; col < getNumCols(); col++)
        drawCell(row, col);
    }
  }
  
  public static void pauseUntilMouse()
  {
    if (!created)
      throw new RuntimeException("Must call window method first");
    Draw.pauseUntilMouse();
  }
  
  public static int getMouseRow()
  {
    return Draw.getMouseY() / cellSize;
  }
  
  public static int getMouseCol()
  {
    return Draw.getMouseX() / cellSize;
  }
  
  public static void setTitle(String title)
  {
    Draw.setTitle(title);
  }
  
  public static void showMessageDialog(String message)
  {
    Draw.showMessageDialog(message);
  }
}