package week7

object test {
  val problem = new Pouring(Vector(4, 9))         //> problem  : week7.Pouring = week7.Pouring@5975d6ab
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.test.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Pour(0,
                                                  //| 1), Pour(1,0))
  problem.solutions(10)                           //> res1: Stream[week7.test.problem.Path] = Stream()
}