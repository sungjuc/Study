package lec.l25;

import java.util.LinkedList;

public class StackImpl<E> implements Stack<E>
{
  private LinkedList<E> data;
  //beginning of list represents top of stack
  
  public StackImpl()
  {
    data = new LinkedList<E>();
  }
  
  public boolean isEmpty()
  {
    return data.size() == 0;
  }
  
  public E peek()
  {
    return data.get(0);
  }
  
  public void push(E obj)
  {
    data.add(obj);
  }
  
  public E pop()
  {
    return data.poll();
  }
}