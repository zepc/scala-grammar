package com.zep.scala.grammer.对象与类.apply和unapply

object Test {
  /*
  * apply is probably the easier to explain.
  * Essentially, when you treat your object like a function,
  * apply is the method that is called, so, Scala turns:
  *
  * obj(a, b, c) to obj.apply(a, b, c).
  * */


  /*
  * unapply is a bit more complicated.
  * It is used in Scala's pattern matching mechanism and its most common use I've seen is in Extractor Objects.
  *
  * For example, here's a toy extractor object:
  * */

  object Foo {
    def unapply(x : Int) : Option[String] =
      if(x == 0) Some("Hello, World") else None
  }

  def main(args: Array[String]): Unit = {

    val myInt = 0

    myInt match {
      case Foo(str) => println(str)
    }

    // 如果myInt为1, 相当于调用了

    val x = 1
    val str : String = Foo.unapply(x) match {
      case Some(s) => s
      case None    => throw new scala.MatchError(x)
    }
  }

}
