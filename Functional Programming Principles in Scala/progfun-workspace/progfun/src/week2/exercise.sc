package week2

object exercise {
  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  factorial(4)                                    //> res0: Int = 24
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    {
      if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    }                                             //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(1, 3)                       //> res1: Int = 36

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  fact(5);                                        //> res2: Int = 120

}