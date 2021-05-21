package com.zep.scala.grammer.对象与类.`trait`

/**
  * Created by root on 2017/6/14.
  */

/**
  * 混入特质的第三中方式
  */
class Human{

  println("Human")
}

trait Teacher extends Human{
  println("teacher")
  def  teach()
}

trait PianoPlayer extends  Human{

  println("PianoPlayer")
  def play(): Unit = println("i am a PianoPlayer")
}



object UsingTraitThree {

  def main(args: Array[String]): Unit = {

    val human = new Human with Teacher with  PianoPlayer {
      override def teach(): Unit = println("teach")
      override def play(): Unit = println("play")
    }
    human.play()
    human.teach()
  }
}
