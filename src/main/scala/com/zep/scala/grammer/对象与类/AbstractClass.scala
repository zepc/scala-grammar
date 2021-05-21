package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/6/8.
  */
abstract class Student(var name : String, var score : Double){

  var age : Int //没有初始值的字段-->抽象字段
  def func()  //没有执行体的方法-->抽象方法
}

class info(name : String, score : Double, msg : String, override var age : Int = 88) extends Student(name, score){

//  override var age = 88
  override def func(): Unit = {
    println(age)
  }
}

object AbstractClass {

  def main(args: Array[String]): Unit = {

		args.foreach(println)

  }
}
