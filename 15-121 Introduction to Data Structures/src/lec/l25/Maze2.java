package lec.l25;

import java.awt.Color;
import java.util.*;

public class Maze2
{
  private static final int WALL = 0;
  private static final int PATH = 1;
  private static final int VISITED = 2;
  
  private static Grid display;
  
  public static void main(String[] args)
  {
    int[][] maze = init(131, 131);
    //recursiveDepthFirstSearch(maze);
    //iterativeDepthFirstSearch(maze);
    iterativeBreadthFirstSearch(maze);
  }

  //uses a recursive depth-first search to solve maze, and returns true if solvable
  public static boolean recursiveDepthFirstSearch(int[][] maze)
  {
    return recursiveDepthFirstSearch(maze, 0, 0);
  }
  
  //uses a recursive depth-first search to solve maze from (row, col), and returns true if solvable
  private static boolean recursiveDepthFirstSearch(int[][] maze, int row, int col)
  {
	if (!isValid(maze, row, col) || maze[row][col] != PATH)
		return false;

	maze[row][col] = VISITED;
	updateDisplay(maze, row, col);

	if (row == maze.length - 1 && col == maze[0].length - 1)
		return true;

	return recursiveDepthFirstSearch(maze, row - 1, col)
		|| recursiveDepthFirstSearch(maze, row, col - 1)
		|| recursiveDepthFirstSearch(maze, row + 1, col)
		|| recursiveDepthFirstSearch(maze, row, col + 1);
  }
  
  //uses an iterative depth-first search to solve maze, and returns true if solvable
  public static boolean iterativeDepthFirstSearch(int[][] maze)
  {
	Stack<Location> stack = new StackImpl<Location>();
	stack.push(new Location(0, 0));

	while(!stack.isEmpty()) {
		Location loc = stack.pop();
		int row = loc.getRow();
		int col = loc.getCol();
		if(isValid(maze, row, col) && maze[row][col] == PATH) {
			maze[row][col] = VISITED;
			updateDisplay(maze, row, col);

			if(row == maze.length - 1 && col == maze[0].length - 1) {
				return true;
			}
			
			stack.push(new Location(row + 1, col));
			stack.push(new Location(row, col + 1));
			stack.push(new Location(row - 1, col));
			stack.push(new Location(row, col - 1));
		}
		
	}

	return false;
  }

  //uses an iterative breadth-first search to solve maze, and returns true if solvable
  public static boolean iterativeBreadthFirstSearch(int[][] maze)
  {
	Queue<Location> queue = new QueueImpl<Location>();
	queue.enqueue(new Location(0, 0));
	
	while (!queue.isEmpty()) {
		Location loc = queue.dequeue();
		int row = loc.getRow();
		int col = loc.getCol();
		if (isValid(maze, row, col) && maze[row][col] == PATH) {
			maze[row][col] = VISITED;
			updateDisplay(maze, row, col);
			
			if(row == maze.length - 1 && col == maze[0].length - 1)
				return true;

			queue.enqueue(new Location(row, col - 1));
			queue.enqueue(new Location(row, col + 1));
			queue.enqueue(new Location(row - 1, col));
			queue.enqueue(new Location(row + 1, col));
		}
			
	}

	return false;
  }

  //numRows and numCols must be odd.
  public static int[][] init(int numRows, int numCols)
  {
    int[][] maze = new int[numRows][numCols];
    
    display = new Grid(maze.length, maze[0].length);
    display.setTitle("Maze");
    createMaze(maze, maze.length - 1, maze[0].length - 1);
    
    for (int row = 0; row < maze.length; row++)
    {
      for (int col = 0; col < maze[0].length; col++)
      {
        if (maze[row][col] == PATH)
          display.setColor(row, col, new Color(255, 255, 255));
        else
          display.setColor(row, col, new Color(0, 0, 0));
      }
    }
    
    return maze;
  }

  private static boolean isValid(int[][] maze, int row, int col)
  {
	return row >= 0
		&& col >= 0
		&& row < maze.length
		&& col < maze[0].length;
  }
  
  private static Location midpoint(int row, int col, Location loc)
  {
    return new Location((row + loc.getRow()) / 2, (col + loc.getCol()) / 2);
  }
  
  private static void updateDisplay(int[][] maze, int row, int col)
  {
    int state = maze[row][col];
    if (state == WALL)
      display.setColor(row, col, new Color(0, 0, 0));
    else if (state == PATH)
      display.setColor(row, col, new Color(255, 255, 255));
    else if (state == VISITED)
      display.setColor(row, col, new Color(255, 0, 0));
    pause(1);
  }
  
  private static void pause(int ms)
  {
    try{Thread.sleep(ms);}catch(Exception e){};
  }
  
  private static void createMaze(int[][] maze, int row, int col)
  {
    maze[row][col] = PATH;
    List<Location> neighbors = new ArrayList<Location>();
    neighbors.add(new Location(row - 2, col));
    neighbors.add(new Location(row, col - 2));
    neighbors.add(new Location(row, col + 2));
    neighbors.add(new Location(row + 2, col));
    Collections.shuffle(neighbors);
    for (Location neighbor : neighbors)
    {
      if (isValid(maze, neighbor.getRow(), neighbor.getCol()))
      {
        int state = maze[neighbor.getRow()][neighbor.getCol()];
        Location mid = midpoint(row, col, neighbor);
        if (state == WALL)
        {
          maze[mid.getRow()][mid.getCol()] = PATH;
          createMaze(maze, neighbor.getRow(), neighbor.getCol());
        }
      }
    }
  }
}