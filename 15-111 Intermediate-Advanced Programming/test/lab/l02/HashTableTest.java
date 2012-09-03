package lab.l02;

import junit.framework.TestCase;

public class HashTableTest extends TestCase {
	private HashTable table;
	private Item value1;
	private Item value2;

	protected void setUp() {
		table = new HashTable();
		value1 = new Item("a", "b");
		value2 = new Item("b", "c");
		table.add(value1.getKey(), value1);
	}

	public void testAdd() {
		this.setUp();
		assertTrue(table.toString().contains(
				"[" + value1.getKey() + ", " + value1.getValue() + "]"));
		table.add(value2.getKey(), value2);
		assertTrue(table.toString().contains(
				"[" + value2.getKey() + ", " + value2.getValue() + "]"));
	}

	public void testContainsKey() {
		this.setUp();
		assertTrue(table.containsKey(value1.getKey()));
		assertFalse(table.containsKey(value2.getKey()));
		table.add(value2.getKey(), value2);
		assertTrue(table.containsKey(value2.getKey()));
	}

	public void testGet() {
		this.setUp();
		assertTrue(value1.getValue().equals(table.get(value1.getKey())));
		assertTrue(value2.getKey().equals(table.get(value2.getKey())));
		table.add(value2.getKey(), value2);
		assertTrue(value2.getValue().equals(table.get(value2.getKey())));
	}
}
