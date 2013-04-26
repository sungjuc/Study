package week2
import math.abs

object exercise3 {
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      println(next)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double

  def sqrt(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1.0)      //> sqrt: (x: Double)Double

  sqrt(2)                                         //> 1.5
                                                  //| 1.4166666666666665
                                                  //| 1.4142156862745097
                                                  //| 1.4142135623746899
                                                  //| res0: Double = 1.4142135623746899
}