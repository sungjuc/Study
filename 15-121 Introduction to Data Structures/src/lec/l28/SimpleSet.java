package lec.l28;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class SimpleSet<E> implements Set<E> {

	public static void main(String[] args) {
		SimpleSet<String> set = new SimpleSet<String>();
		set.add("Joe");
		set.add("Jon");
		set.add("Tilman");
		set.add("Satheesh");

		System.out.println(set);
		System.out.println("Contains Joe? " + set.contains("Joe"));
		System.out.println("Contains Homer? " + set.contains("Homer"));
	}

	private List<E> list;

	public SimpleSet() {
		list = new ArrayList<E>();
	}

	@Override
	public boolean add(E arg0) {
		return list.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		
		for(E e : list) {
			if(e.equals(arg0))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
