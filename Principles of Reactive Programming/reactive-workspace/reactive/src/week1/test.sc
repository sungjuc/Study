package week1

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val f:PartialFunction[String, String] = {case "ping" => "pong"}
                                                  //> f  : PartialFunction[String,String] = <function1>
  f("ping")                                       //> res0: String = pong
  f.isDefinedAt("ping")                           //> res1: Boolean = true
  f.isDefinedAt("abc")                            //> res2: Boolean = false
  
 
}