package lec.l25;

public interface Stack<E>
{
  boolean isEmpty();
  E peek();
  void push(E obj);
  E pop();
}