package lec.l04;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ArrayListTest extends TestCase {
	public void testArrayList() {
		ArrayList<String> names;
		names = new ArrayList<String>();

		names.add("Daves");
		names.add("Margaret");
		System.out.println(names.toString());

		names.set(0, "Tom");
		System.out.println(names.toString());

		names.add(1, "Jim");
		System.out.println(names.toString());

		names.remove(1);
		System.out.println(names.toString());
	}
}
