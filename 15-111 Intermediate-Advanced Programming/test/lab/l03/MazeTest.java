package lab.l03;

import junit.framework.TestCase;
import lab.l03.Maze.InvalidMazeFileException;

public class MazeTest extends TestCase {
	Maze maze;

	protected void setUp() {
		try {
			maze = new Maze("src/lab/l03/sampleMaze.txt");
		} catch (InvalidMazeFileException imfe) {
			imfe.printStackTrace();
		}
	}

	public void testGetFinish() {
		assertEquals("(4,0)", maze.getFinish().toString());
	}

	public void testGetStart() {
		assertEquals("(1,5)", maze.getStart().toString());
	}

	public void testIsFinish() {
		assertTrue(maze.isFinish(new Maze.Cell(4, 0)));
		assertFalse(maze.isFinish(new Maze.Cell(4, 1)));
	}

	public void testIsStart() {
		assertTrue(maze.isStart(new Maze.Cell(1, 5)));
		assertFalse(maze.isStart(new Maze.Cell(4, 1)));
	}

	public void testIsPath() {
		assertTrue(maze.isPath(new Maze.Cell(3, 0)));
		assertFalse(maze.isPath(new Maze.Cell(3, 5)));
	}

	public void testToString() {
		System.out.println(maze.toString());
		String expected = "  012345\n0 X  XXX\n1 XX X S\n2 XX X X\n3      X\n4 FX XXX\n5 X    X\n";
		assertEquals(expected, maze.toString());
	}
}
