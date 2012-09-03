package lec.l25;

public interface Queue<E>
{
  boolean isEmpty();
  E peek();
  void enqueue(E obj);
  E dequeue();
}