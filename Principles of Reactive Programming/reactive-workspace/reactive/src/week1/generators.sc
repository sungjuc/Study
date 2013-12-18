package week1
import week1._

object generators {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val integers = new Generator[Int] {
    def generate = scala.util.Random.nextInt()
  }                                               //> integers  : week1.Generator[Int] = week1.generators$$anonfun$main$1$$anon$1@
                                                  //| 1bbb60c3
  val booleans = integers.map(_ >= 0)             //> booleans  : week1.Generator[Boolean] = week1.Generator$$anon$1@596e1fb1

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)                                 //> leafs: => week1.Generator[week1.Leaf]

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)                             //> inners: => week1.Generator[week1.Inner]

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree                                    //> trees: => week1.Generator[week1.Tree]
  
  trees.generate                                  //> res0: week1.Tree = Leaf(1966244444)
}