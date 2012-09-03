package lec.l14;

import junit.framework.TestCase;

public class ArrayListTest extends TestCase {
	private ArrayList<String> list;

	public void testArrayList() {
		list = new ArrayList<String>();
		assertNotNull(list);
	}

	public void testSize() {
		list = new ArrayList<String>();
		assertEquals(0, list.size());
	}
	
	public void testGet(){
		list = new ArrayList<String>();
		list.add("First");
		list.add("Second");
		assertEquals("First", list.get(0));
		assertEquals("Second", list.get(1));
	}
	
	public void testAdd(){
		list = new ArrayList<String>();
		list.add("First");
		assertEquals(1, list.size());
		list.add("Second");
		assertEquals(2, list.size());
	}
	
	public void testAddWithIndex(){
		list = new ArrayList<String>();
		list.add("Second");
		list.add("Fourth");
		list.add(1, "Third");
		list.add(0, "First");
		assertEquals("First", list.get(0));
		assertEquals("Second", list.get(1));
		assertEquals("Third", list.get(2));
		assertEquals("Fourth", list.get(3));
	}
}
