package lec.l29;

public interface Iterator<E> {
	boolean hasNext();
	E next();
	void remove();
}