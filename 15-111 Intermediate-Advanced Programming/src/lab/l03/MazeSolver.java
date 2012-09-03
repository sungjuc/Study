package lab.l03;

import java.util.ArrayList;

/*
 * This class will use recursion to solve a maze. 
 */
class MazeSolver {
	private Maze maze;
	private ArrayList<Maze.Cell> list;
	private boolean result;

	/*
	 * This is the constructor. Given a properly constructed Maze, It should set
	 * things up for the solve() method, &c to do the "real world"
	 */
	public MazeSolver(Maze maze) {
		this.maze = maze;
		this.list = new ArrayList<Maze.Cell>();
		this.result = false;
	}

	/*
	 * This is a wrapper for the recursive solve method. It should do very
	 * little -- really just call that with the right paramters. It basically
	 * exists to hide the complex paramterization from the users.
	 */
	public boolean solve() {
		result = solve_recursive(maze.getStart(), null);
		return result;
	}

	/*
	 * This is the "meat and potatoes". This method shoudl use recursion to
	 * solve the maze. It should return "true" if the maze has a solution and
	 * "false" otherwise. It should also set up the data structure so that
	 * toString() can produce the path that was used from start to finish
	 * 
	 * "current" is the current position in the maze -- this is initally start.
	 * "previous" is the cell that we came from -- this is used to stop us from
	 * going back there.
	 */

	private boolean solve_recursive(Maze.Cell current, Maze.Cell previous) {
		boolean result = false;

		if (maze.isFinish(current)) {
			list.add(current);
			return true;
		}

		if (!maze.isPath(current))
			return false;

		int row = current.getRow();
		int col = current.getCol();

		list.add(current);

		if (previous == null || row - 1 != previous.getRow())
			if (solve_recursive(new Maze.Cell(row - 1, col), current))
				return true;

		if (previous == null || col - 1 != previous.getCol())
			if (solve_recursive(new Maze.Cell(row, col - 1), current))
				return true;

		if (previous == null || row + 1 != previous.getRow())
			if (solve_recursive(new Maze.Cell(row + 1, col), current))
				return true;

		if (previous == null || col + 1 != previous.getCol())
			if (solve_recursive(new Maze.Cell(row, col + 1), current))
				return true;

		list.remove(current);

		return result;
	}

	// This should convert the maze and the path through the maze to a String.
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(maze.toString() + "\n");

		if (result) {
			sb.append("[");
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1)
					sb.append(list.get(i).toString() + ", ");
				else
					sb.append(list.get(i).toString());
			}
			sb.append("]");
		}
		return sb.toString();
	}

	// This should be your test driver
	public static void main(String args[]) throws Exception {
		Maze maze = new Maze("src/lab/l03/sampleMaze.txt");
		MazeSolver solver = new MazeSolver(maze);
		if(solver.solve())
			System.out.println("Success!!!\n");
		else
			System.out.println("Failed!!!\n");
		System.out.println(solver.toString());
		System.out.println();
		System.out.println();

		maze = new Maze("src/lab/l03/sampleMaze1.txt");
		solver = new MazeSolver(maze);
		if(solver.solve())
			System.out.println("Success!!!\n");
		else
			System.out.println("Failed!!!\n");
		System.out.println(solver.toString());

	}
}
