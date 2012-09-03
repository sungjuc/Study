package lec.l04;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ArrayListUtilsTest extends TestCase {
	ArrayList<String> names;

	public void setUp() {
		names = new ArrayList<String>();
		names.add("Joe");
		names.add("Iny");
		names.add("Youngari");
		names.add("Sanjo");
	}

	public void testCount() {
		assertEquals(2, ArrayListUtils.count(names, 3));
	}

	public void testNamesWithLength() {
		assertEquals(2, ArrayListUtils.namesWithLength(names, 3).size());
		System.out.println(ArrayListUtils.namesWithLength(names, 3));
	}

	public void testRemoveNamesWithLengthWithProblem() {
		ArrayList<String> testNames = (ArrayList<String>) names.clone();
		ArrayListUtils.removeNamesWithLengthWithProblem(testNames, 3);
		System.out.println(testNames);
	}

	public void testRemoveNamesWithLength() {
		ArrayList<String> testNames = (ArrayList<String>) names.clone();
		ArrayListUtils.removeNamesWithLength(testNames, 3);
		System.out.println(testNames);
	}

	public void testRemoveNamesWithLengthWithWhile() {
		ArrayList<String> testNames = (ArrayList<String>) names.clone();
		ArrayListUtils.removeNamesWithLengthWithWhile(testNames, 3);
		System.out.println(testNames);
	}

	public void testRemoveNamesWithLengthWithBackLoop() {
		ArrayList<String> testNames = (ArrayList<String>) names.clone();
		ArrayListUtils.removeNamesWithLengthWithBackLoop(testNames, 3);
		System.out.println(testNames);
	}
}
