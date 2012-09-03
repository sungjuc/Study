package lab.l06;

import java.util.LinkedList;

/**
 * The class represents the Set collection.
 * 
 * @author sungju.cho
 * @version 15-100 Introductory/Intermediate Programming Lab 6
 */
class Set {

	private LinkedList<Object> list;

	/*
	 * This exception is thrown by various methods of the Set class.
	 * 
	 * The constructor takes a string that describes the specific situation
	 */
	public class SetException extends Exception {
		public SetException(String s) {
			super(s);
		}
	}

	/*
	 * Declare any instance variables here
	 */

	/*
	 * This is the default constructor. It just creates an empty set. Basically,
	 * it creates an empty linked list.
	 */
	public Set() {
		list = new LinkedList<Object>();
	}

	/*
	 * This is a copy constructor. It creates a new set from an old set
	 */
	public Set(Set original) throws SetException {
		this();
		addItems(original);
	}

	/*
	 * Returns the items in the set as a string
	 */
	public String toString() {
		if (list.size() < 1)
			return "There is no element in the Set.";

		StringBuilder sb = new StringBuilder();

		for (Object item : list) {
			if (sb.length() > 0)
				sb.append(", ").append("[").append(item.toString()).append("]");
			else
				sb.append("[").append(item.toString()).append("]");
		}
		return sb.toString();
	}

	/*
	 * Returns true if the item is in the set and false otherwise
	 */
	public boolean member(Object item) {
		for (Object element : list)
			if (element.equals(item))
				return true;

		return false;
	}

	/*
	 * This method should add an item to the set. It should throw an exception
	 * if the item is already in the set.
	 * 
	 * Specifically, you should define a SetException and throw this exception.
	 * When you create a new instance of this exception, you should set its
	 * value to "Item already in set."
	 */

	public void addItem(Object item) throws SetException {
		if (member(item))
			throw new SetException("Item already in set.");

		list.add(item);
	}

	/*
	 * This method should add all of the items from the newItems set into the
	 * original set. It should throw an exception upon discovering that any
	 * requested item is already in the set.
	 * 
	 * Specifically, you should define a SetException and throw this exception.
	 * When you create a new instance of this exception, you should set its
	 * value to "Item already in set."
	 */

	public void addItems(Set newItems) throws SetException {
		boolean exceptionFlag = false;
		for (Object element : newItems.list) {
			try {
				addItem(element);
			} catch (SetException se) {
				exceptionFlag = true;
			}
		}
		if (exceptionFlag)
			throw new SetException("Item already in set.");
	}

	/*
	 * This method should remove an item from the set. It should throw an
	 * exception if the item is not in the set.
	 * 
	 * Specifically, you should define a SetException and throw this exception.
	 * When you create a new instance of this exception, you should set its
	 * value to "Item not already in set."
	 */

	public void removeItem(Object item) throws SetException {
		for (Object element : list)
			if (element.equals(item)) {
				list.remove(item);
				return;
			}

		throw new SetException("Item not already in set.");
	}

	/*
	 * This method should remove all of the items in the "items" Set from the
	 * current set. It should throw an exception upon discovering that any of
	 * the specified items is not in the target set.
	 * 
	 * Specifically, you should define a SetException and throw this exception.
	 * When you create a new instance of this exception, you should set its
	 * value to "Item not already in set."
	 */

	public void removeItems(Set items) throws SetException {
		for (Object element : items.list) {
			if (member(element))
				removeItem(element);
			else
				throw new SetException("Item not already in set.");
		}

	}

	/*
	 * This returns a new set that contains every element in the original set
	 * and the set provided by the user
	 */
	public Set union(Set in_set) throws SetException {
		Set union = new Set(this);
		for (Object element : in_set.list) {
			if (!member(element))
				union.addItem(element);
		}
		return union;
	}

	/*
	 * This returns a new set that contains only those elements in the original
	 * set and the set provided by the user
	 */
	public Set intersection(Set in_set) throws SetException {
		Set intersection = new Set();
		for (Object element : in_set.list) {
			if (member(element))
				intersection.addItem(element);
		}
		return intersection;
	}

	/*
	 * This returns a new set that contains only those elements in the original
	 * set or the set provided by the user, but not both.
	 */
	public Set xor(Set in_set) throws SetException {
		Set temp = union(in_set);
		temp.removeItems(intersection(in_set));

		return temp;
	}

	/*
	 * This returns true if the specified set is a proper subset of the target
	 * set and false otherwise.
	 */
	public boolean subset(Set subset) throws SetException {
		for (Object element : subset.list)
			if (!member(element))
				return false;

		return true;
	}

	/*
	 * This should be a test driver. It should perform no user or file I/O
	 * whatsoever. Instead, it should be a static test set that convinces us
	 * that your Set class works. It should test all of the special cases, all
	 * of the boundary cases, and the common cases.
	 */
	public static void main(String[] argv) throws SetException {
		String[] professor = new String[] { "Kesden", "Atkeson", "Reddy" };
		String[] lecturer = new String[] { "Kesden", "Atkeson", "Joe", "Reddy" };
		String[] students = new String[] { "SungPil", "Joe", "Pom" };

		// Test for constructor
		Set professorSet = new Set();
		System.out
				.println("-------------------------------------- Test for constructor");
		System.out.println("No data in the Set: " + professorSet.toString());

		// Test for addItem
		for (String prof : professor)
			professorSet.addItem(prof);
		System.out
				.println("-------------------------------------- Test for addItem");
		System.out.println("Professors in the Set: " + professorSet.toString());

		// Test for copy constructor
		Set professorCopySet = new Set(professorSet);
		System.out
				.println("-------------------------------------- Test for copy constructor");
		System.out.println("Professors copy Set: "
				+ professorCopySet.toString());

		// Test for addItems with Exception
		Set lecturerSet = new Set();
		for (String lect : lecturer)
			lecturerSet.addItem(lect);
		Set teacherSet = new Set();
		teacherSet.addItems(professorSet);
		try {
			teacherSet.addItems(lecturerSet);
		} catch (SetException se) {
			System.out.println(se.toString());
		}
		System.out
				.println("-------------------------------------- Test for addItems");
		System.out.println("Teacher Set: " + teacherSet.toString());

		// Test for removeItem
		teacherSet.removeItem("Joe");
		System.out
				.println("-------------------------------------- Test for removeItem");
		System.out.println("Joe left CMU: " + teacherSet.toString());

		// Test for removeItems
		teacherSet.removeItems(professorSet);
		System.out
				.println("-------------------------------------- Test for removeItems");
		System.out
				.println("Professor is not teacher: " + teacherSet.toString());

		// Test for member
		System.out
				.println("-------------------------------------- Test for memeber");
		System.out.println("Joe is professor?: " + professorSet.member("Joe"));
		System.out.println("Joe is lecturer?: " + lecturerSet.member("Joe"));

		// Test for intersection
		System.out
				.println("-------------------------------------- Test for intersection");
		Set intersectionSet = professorSet.intersection(lecturerSet);
		System.out
				.println("The person who is proferssor as well as lecturer?: "
						+ intersectionSet.toString());

		// Test for union
		System.out
				.println("-------------------------------------- Test for union");
		Set unionSet = professorSet.union(lecturerSet);
		System.out.println("The person who is proferssor or lecturer?: "
				+ unionSet.toString());

		// Test for subset
		System.out
				.println("-------------------------------------- Test for subset");
		System.out
				.println("Does the group of lecturer is the subset of the group of professor?: "
						+ professorSet.subset(lecturerSet));
		System.out
				.println("Does the group of professor is the subset of the group of lecturer?: "
						+ lecturerSet.subset(professorSet));

		// Test for xor
		System.out
				.println("-------------------------------------- Test for xor");
		Set xor = professorSet.xor(lecturerSet);
		System.out
				.println("The person who is only professor or only lecturer: "
						+ xor.toString());
		System.out
				.println("----------------------------------------------------");
	}
}
