package week5

object week5 {

  def removeAt[T](xs: List[T], n: Int): List[T] = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](xs: List[T], n: Int)List[T]
  removeAt(List('a', 'b', 'c', 'd'), 1)           //> res0: List[Char] = List(a, c, d)

  /*def flatten(xs: List[Any]): List[Any] = xs match {
  	case List() =>
  	case xs => xs.head match{
  		case p:List[Any] => flatten(p)::flatten(xs.tail)
  		case p:Any => p::flatten(xs.tail)
  	}
  }

  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  */
}