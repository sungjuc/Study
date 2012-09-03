package lab.l03;

import junit.framework.TestCase;

public class CellTest extends TestCase {
	private Maze.Cell cell13First = null;
	private Maze.Cell cell13Second = null;
	private Maze.Cell cell25 = null;

	protected void setUp() {
		cell13First = new Maze.Cell(1, 3);
		cell13Second = new Maze.Cell(1, 3);
		cell25 = new Maze.Cell(2, 5);
	}

	public void testCell() {
		Maze.Cell testCell = new Maze.Cell(1, 2);
		assertNotNull(testCell);
	}

	public void testGetCol() {
		assertEquals(3, cell13First.getCol());
		assertEquals(3, cell13Second.getCol());
		assertEquals(5, cell25.getCol());
	}

	public void testGetRow() {
		assertEquals(1, cell13First.getRow());
		assertEquals(1, cell13Second.getRow());
		assertEquals(2, cell25.getRow());
	}

	public void testEquals() {
		assertTrue(cell13First.isEqual(cell13Second));
		assertFalse(cell13First.isEqual(cell25));
	}

	public void testToString() {
		assertEquals("(" + 1 + "," + 3 + ")", cell13First.toString());
		assertEquals("(" + 1 + "," + 3 + ")", cell13Second.toString());
		assertEquals("(" + 2 + "," + 5 + ")", cell25.toString());
		System.out.println(cell25.toString());
	}
}
