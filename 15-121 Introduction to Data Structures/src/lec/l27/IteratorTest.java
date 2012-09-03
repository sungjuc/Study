package lec.l27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hi Joe");
		list.add("What's up");
		list.add("Bye");

		System.out.println("Printing with for loop: ");
		IteratorTest.printWithFor(list);

		System.out.println("\nPrinting with iterator");
		IteratorTest.printIteratorTest(list);

		System.out.println("\nWrong printing with iterator");
		IteratorTest.printIteratorWrong1(list);

		System.out.println("\nWrong usage of it.next()");
		IteratorTest.printHello(list);

		System.out.println("\nWrong usage of iteraotr()");
		IteratorTest.printIteratorWrong2(list);

		System.out.println("\nIllegal removal using collection's remove method during iteration");
		IteratorTest.illegalRemove(list, "Bye");
		System.out.println(list);

		list = new ArrayList<String>();
		list.add("Hi Joe");
		list.add("What's up");
		list.add("Bye");

		
		System.out.println("\nRemoval string");
		IteratorTest.remove(list, "Hi Joe");
		System.out.println(list);

		List<Integer> newList = new LinkedList<Integer>();
		newList.add(1);
		newList.add(2);
		newList.add(1);
		newList.add(3);
		newList.add(1);
		newList.add(4);
		newList.add(1);
		
		System.out.println("\nInteger List: " + newList);
		IteratorTest.removeAll(newList, 1);
		System.out.println(newList);
	}

	public static void printWithFor(List<String> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static void printIteratorTest(List<String> list) {
		Iterator<String> it = list.iterator();
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		try {
			System.out.println(it.next());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public static void printIteratorWrong1(List<String> list) {
		Iterator<String> it = list.iterator();
		String x = it.next();
		try {
			while ( x != null ) {
				System.out.println(x);
				x = it.next();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public static void printHello(List<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			if(it.next().equals("Hi Joe"))
				System.out.println(it.next());
		}
	}

	public static void printIteratorWrong2(List<String> list) {
		int count = 0;
		while(list.iterator().hasNext()) {
			count++;
			System.out.println(list.iterator().next());
			if(count > 1000)
				return;
		}
	}

	public static void illegalRemove(List<String> list, String s) {
		Iterator<String> it = list.iterator();
		int index = 0;
		try {
			while(it.hasNext()){
				if(it.next().equals(s))
					list.remove(index);
				else
					index++;
			}
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}
	}

	public static void remove(List<String> list, String s) {
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().equals(s))
				it.remove();
		}
	}

	public static void removeAll(List<Integer> list, int x) {
		Iterator<Integer> it = list.iterator();

		while(it.hasNext())
			if(it.next().equals(x))
				it.remove();			
	}
}