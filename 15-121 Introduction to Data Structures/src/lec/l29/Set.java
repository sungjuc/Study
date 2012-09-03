package lec.l29;

public interface Set<E> {
	int size();
	boolean contains(Object obj);
	boolean add(E obj);
	boolean remove(Object obj);
	Iterator<E> iterator();
}