package week6

object maps {
  val romanNumerals = Map("I" -> 1, "V"->5, "x"->10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, x -> 10)
  val capitalOfCountry = Map("US"->"Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  capitalOfCountry get "andorra"                  //> res0: Option[String] = None
  capitalOfCountry get "US"                       //> res1: Option[String] = Some(Washington)
}