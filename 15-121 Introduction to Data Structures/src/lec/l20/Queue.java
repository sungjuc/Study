package lec.l20;

public interface Queue<E> {
	public void enqueue(E data);

	public E dequeue();

	public E peek();

	public boolean isEmpty();
}