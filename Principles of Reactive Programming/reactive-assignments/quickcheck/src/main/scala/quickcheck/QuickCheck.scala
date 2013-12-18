package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  // Make passes 1 and 2
  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("del1") = forAll { (a: Int, b: Int, c: Int) =>
    val h = insert(a, insert(b, insert(c, empty)))
    val min = Math.min(a, Math.min(b, c))
    val max = Math.max(a, Math.max(b, c))
    (findMin(h) == min) && (findMin(deleteMin(deleteMin(h))) == max)
  }

  // Make passes 5
  property("meld1") = forAll { (h1: H, h2: H) =>
    val h3 = meld(h1, h2)
    findMin(h3) == Math.min(findMin(h1), findMin(h2))
  }

  lazy val genHeap: Gen[H] = for {
    m <- arbitrary[Int]
    h <- oneOf(value(empty), genHeap)
  } yield insert(m, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  def checkSorted(h: H): Boolean = {
    if (isEmpty(h))
      true
    else {
      val min = findMin(h)
      val h2 = deleteMin(h)
      if (isEmpty(h2))
        true
      else {
        val min2 = findMin(h2)
        if (min <= min2) checkSorted(h2) else false
      }
    }
  }
}
