package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object UpperBoundsDemo2 {

  def main(args: Array[String]): Unit = {

    biophony(Seq(new Bird, new Bird))
    biophony(Seq(new Animal, new Animal))
    biophony(Seq(new Animal, new Bird))
//    biophony(Seq(new Earth, new Earth)) // 报错
  }

  def biophony[T <:Animal](things: Seq[T])= things.map(_.sound)
}


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