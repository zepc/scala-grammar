package com.zep.scala.grammer.对象与类

/**
  * Created on 2020/05/21.
  *
  * @author Zhao Peng
  */

class Father {

  println("超类开始构造")

  def sayHello(name: String): Unit = {
    println(s"hello $name")
    run()
  }

  def run(): Unit ={
    println(s"四条腿跑步")
  }
}

class Son extends Father{

  println("子类开始构造")

  sayHello("lisi") // 先构造超类，然后构造子类，子类重写了方法，所以输出“两条腿跑步”

  override def run(): Unit = println(s"两条腿跑步")
}


object ObjInherit {

  def main(args: Array[String]): Unit = {
    val son = new Son()
  }
}
