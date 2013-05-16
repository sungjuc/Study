package week6

object books {

  case class Book(title: String, authors: List[String])

  val books: List[Book] = List(
    Book(title = "Structure and Interpretation of Computer Programs",
      authors = List("Abelson, Harold", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming", authors = List("Bird, Richard")),
    Book(title = "Effective Java",
      authors = List("Bloch, Joshua")),
    Book(title = "Effective Java 2",
      authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers",
      authors = List("Bloch, Joshua")),
    Book(title = "Programming in Modula-2",
      authors = List("Wirth, Niklaus")),

    Book(title = "The Java Language Specification",
      authors = List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")))
  //> books  : List[week6.books.Book] = List(Book(Structure and Interpretation of 
  //| Computer Programs,List(Abelson, Harold, Sussman, Gerald J.)), Book(Introduct
  //| ion to Functional Programming,List(Bird, Richard)), Book(Effective Java,List
  //| (Bloch, Joshua)), Book(Effective Java 2,List(Bloch, Joshua)), Book(Java Puzz
  //| lers,List(Bloch, Joshua)), Book(Programming in Modula-2,List(Wirth, Niklaus)
  //| ), Book(The Java Language Specification,List(Gosling, James, Joy, Bill, Stee
  //| le, Guy, Bracha, Gilad)))

  for (b <- books; a <- b.authors if a startsWith "Bird")
    yield b.title //> res0: List[String] = List(Introduction to Functional Programming)

  for (b <- books if (b.title indexOf "Program") >= 0)
    yield b.title //> res1: List[String] = List(Structure and Interpretation of Computer Programs,
  //|  Introduction to Functional Programming, Programming in Modula-2)

  (for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1).distinct //> res2: List[String] = List(Bloch, Joshua)

  val bookSet = books.toSet //> bookSet  : scala.collection.immutable.Set[week6.books.Book] = Set(Book(Stru
  //| cture and Interpretation of Computer Programs,List(Abelson, Harold, Sussman
  //| , Gerald J.)), Book(Effective Java 2,List(Bloch, Joshua)), Book(Java Puzzle
  //| rs,List(Bloch, Joshua)), Book(Programming in Modula-2,List(Wirth, Niklaus))
  //| , Book(Effective Java,List(Bloch, Joshua)), Book(The Java Language Specific
  //| ation,List(Gosling, James, Joy, Bill, Steele, Guy, Bracha, Gilad)), Book(In
  //| troduction to Functional Programming,List(Bird, Richard)))

  for {
    b1 <- bookSet
    b2 <- bookSet
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1 //> res3: scala.collection.immutable.Set[String] = Set(Bloch, Joshua)

}