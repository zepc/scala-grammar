package com.zep.scala.grammer.对象与类.`trait`

/**
  * Created by root on 2017/6/14.
  */
/**
  * Trait的构造是有顺序的，从左到右依次构造,并且父类构造器不重复构造
  *
  *   构造器按如下顺序构造：
  *   （1）超类
  *   （2）父特质
  *   （3）第一个特质
  *   （4）第二个特质(父特质不重复构造)
  *   （5）类
  * 如果class A extends B1 with B2 with B3….
  * 那么，串接B1、B2、B3…等特质，去掉重复项且右侧胜出
  */
/**
  * 混入特质的第二种方式
  */
class Human2 {

  println("Human")
}

trait Teacher2 extends Human2{

  println("Teacher")
  def teach()   // 特质中定义一个抽象方法
}

trait PianoPlayer2 extends Human2{

  println("PianoPlayer")
  def play(): Unit ={
    println("play")
  }
}

// 定义一个子类，在类的定义中混入特质
class PianoTeacher2 extends Human2 with Teacher2 with PianoPlayer2{
  println("pianoteacher")
  override def teach(): Unit = println("teacher and pianoplayer")
}

object UsingTraitTwo {

  def main(args: Array[String]) {
    /**
      * 在创建类的时候， 从左向右， 依次调用 Trait / Class
      *
      * 在调用方法的时候， 就近原则
      */
    val teacher = new PianoTeacher2 //human, teacher, PianoPlayer, pianoteacher
    teacher.teach() // teacher and pianoplayer
    teacher.play() // play
  }
}
