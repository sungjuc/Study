package lec.l28;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SetMapUtils {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Joe");
		set.add("Jon");
		set.add("Tilman");
		set.add("Satheesh");
		
		
		System.out.println(SetMapUtils.countStringsOfLength(set, 3));
		System.out.println(SetMapUtils.countStringsOfLengthUsingFor(set, 3));


		List<Integer> dups = new ArrayList<Integer>();
		dups.add(new Integer(10));
		dups.add(new Integer(11));
		dups.add(new Integer(12));
		dups.add(new Integer(10));
		dups.add(new Integer(13));


		List<Integer> nodups = new ArrayList<Integer>();
		nodups.add(new Integer(10));
		nodups.add(new Integer(11));
		nodups.add(new Integer(12));
		nodups.add(new Integer(13));
		nodups.add(new Integer(14));

		System.out.println("Dups: " + SetMapUtils.hasDuplicates(dups));
		System.out.println("No Dups: " + SetMapUtils.hasDuplicates(nodups));


		Map<String, String> nameToSection = new HashMap<String, String>();
		nameToSection.put("Anand", "B");
		nameToSection.put("Cathy", "C");
		nameToSection.put("Greta", "A");
		nameToSection.put("Lillian", "D");
		nameToSection.put("Sanil", "D");
		nameToSection.put("Steve", "B");

		System.out.println(nameToSection);

		Map<String, Set<String>> sectionToName = SetMapUtils.convert(nameToSection);

		System.out.println(sectionToName);

		System.out.println("Total number of elements which contains B as value: " + SetMapUtils.count(nameToSection, "B"));
	}
	
	public static int countStringsOfLength(Set<String> set, int length) {
		int count = 0;

		/*for (int i = 0; i < set.size(); i++) {
			if (set.get(i).length() == length)
				count++;
		}*/
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			if(it.next().length() == length)
				count++;
		}

		return count;
	}

	public static int countStringsOfLengthUsingFor(Set<String> set, int length) {
		int count = 0;
		for (String s : set) {
			if(s.length() == length)
				count++;
		}
		return count;
	}

	public static boolean hasDuplicates(List<Integer> list) {
		Set<Integer> seen = new HashSet<Integer>();
		for (Integer value : list) {
			if(!seen.add(value))
				return true;
		}
		return false;
	}

	public static int count(Map<String, String> map, String value) {
		int count = 0;
		for (String key : map.keySet()) {
			if(map.get(key).equals(value))
				count++;
		}
		return count;
	}

	public static Map<String, Set<String>> convert(Map<String, String> nameToSection) {
		Map<String, Set<String>> sectionToName = new HashMap<String, Set<String>>();

		for (String name: nameToSection.keySet()) {
			String section = nameToSection.get(name);
			Set<String> names = sectionToName.get(section);

			if (names == null) {
				names = new HashSet<String>();
				sectionToName.put(section, names);
			}
	
			names.add(name);
		}
		
		return sectionToName;			
	}

}