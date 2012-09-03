package lec.l29;

public class SimpleSetTest {
	public static void main(String[] args) {
		SimpleSet<String> stringSet = new SimpleSet<String>();
		SimpleSet<Integer> integerSet = new SimpleSet<Integer>();

		stringSet.add("one");
		stringSet.add("two");
		System.out.println(stringSet);
		System.out.println("2: " + stringSet.size());
		System.out.println("true: " + stringSet.contains("one"));
		System.out.println("true: " + stringSet.contains("two"));
		System.out.println("false: " + stringSet.contains("three"));
		
		
		System.out.println("true: " + stringSet.remove("one"));
		System.out.println(stringSet);
		System.out.println("true: " + stringSet.remove("two"));
		System.out.println(stringSet);
		System.out.println("false: " + stringSet.contains("one"));
		System.out.println("false: " + stringSet.contains("two"));
		System.out.println("false: " + stringSet.contains("three"));
		System.out.println("0: " + stringSet.size());	


		stringSet.add("one");
		System.out.println(stringSet);
		System.out.println("2: " + stringSet.size());
		stringSet.add("two");
		System.out.println(stringSet);
		System.out.println("2: " + stringSet.size());
		System.out.println("true: " + stringSet.contains("one"));
		System.out.println("true: " + stringSet.contains("two"));
		System.out.println("false: " + stringSet.contains("three"));

		System.out.println("\n------------------------\n");
		integerSet.add(new Integer(1));
		System.out.println(integerSet);
		integerSet.add(new Integer(2));
		System.out.println(integerSet);
		System.out.println("false: " + integerSet.contains(new Integer(3)));
		integerSet.remove(new Integer(2));
		System.out.println(integerSet);
		integerSet.remove(new Integer(1));
		System.out.println(integerSet);
	}
}