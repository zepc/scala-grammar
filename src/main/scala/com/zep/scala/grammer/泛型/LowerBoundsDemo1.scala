package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object LowerBoundsDemo1 {

  /*
  * [T >:A] // A是T的下界 [_> :A]
  * */

  def main(args: Array[String]): Unit = {

    biophony(Seq(new Earth, new Earth)).map(_.sound())
    biophony(Seq(new Animal, new Animal)).map(_.sound())
    biophony(Seq(new Bird, new Bird)).map(_.sound())


    // 从编译层面看，因为下界的语法，因此不能保证things都有sound方法

    val res = biophony(Seq(new Bird, new Bird))
    // 直接赋值给things
    val res1 = biophony(Seq(new Moon, new Moon))
    println(s"result moon is $res1")
  }

  def biophony[T >:Animal](things: Seq[T]) = things

  class Earth{
    def sound(): Unit ={
      println("hello earth!")
    }
  }

  class Animal extends Earth{

    override def sound(): Unit = println("animal sound")
  }


  class Bird extends Animal{

    override def sound(): Unit = println("bird sound")
  }


  class Moon{}

}
