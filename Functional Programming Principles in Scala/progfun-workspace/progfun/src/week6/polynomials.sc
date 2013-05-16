package week6

object polynomials {
  class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    def +(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }
    override def toString =
      (for ((exp, coeff) <- terms.toList.sorted) yield coeff + "x^" + exp) mkString " + "
  }

  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : week6.polynomials.Poly = 2.0x^1 + 4.0x^3 + 6.2x^5
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : week6.polynomials.Poly = 3.0x^0 + 7.0x^3
  p1 + p2                                         //> res0: week6.polynomials.Poly = 3.0x^0 + 2.0x^1 + 11.0x^3 + 6.2x^5
  p1.terms(6)                                     //> res1: Double = 0.0
}