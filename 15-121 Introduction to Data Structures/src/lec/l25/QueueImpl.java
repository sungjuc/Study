package lec.l25;

import java.util.LinkedList;

public class QueueImpl<E> implements Queue<E>
{
  private LinkedList<E> data;
  //beginning of list represents front of queue
  
  public QueueImpl()
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
  
  public void enqueue(E obj)
  {
    data.add(obj);
  }
  
  public E dequeue()
  {
    return data.remove(0);
  }
}
