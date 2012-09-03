package lec.l29;

public class SimpleMapTest {
	public static void main(String[] args) {
		SimpleMap<String, Integer> map = new SimpleMap<String, Integer>();
		System.out.println(map);
		map.put("one", new Integer(1));
		System.out.println(map);
		map.put("two", new Integer(2));
		System.out.println(map);
		System.out.println(map.remove("two"));
		System.out.println(map);
		System.out.println(map.get("one"));
		map.put("one", new Integer(100000));
		System.out.println(map);

		map.remove("one");
		System.out.println(map);
		map.put("one", new Integer(1));
		System.out.println(map);
		map.put("two", new Integer(2));
		System.out.println(map);
	}
}