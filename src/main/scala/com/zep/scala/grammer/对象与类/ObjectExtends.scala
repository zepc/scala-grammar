package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/6/8.
  */
/**
  * 1. scala中 extends、final关键字用法Java中相同
  * 2. 在Scala当中重写一个非抽象方法必须使用override关键字,即重写方法必须使用override
  * 3. 只有主构造器可以调用超类的主构造器,当然主构造器也可以调用超类的辅助构造器
  * 4. Java当中一般是通过super关键字来调用父类的构造函数,而在scala中直接在子类声明的时候调用父类的构造函数并填充主构造器相应的参数
  */
class Person(var name : String, var age : Int){

  println("这是父类")
  val school = "MIT"
  val date = 123
  def fun = "Thank Spark"
  override def toString: String = name + "\t" + age
}

/**
  * extends Person(name, age) 继承的时候, 调用父类的构造方法
  * @param name
  * @param age
  * @param salary
  */
class Xiaoming(name : String, age : Int, var salary : Double) extends Person(name, age){

  println("这是子类")
  override val school = "ZIT"
  /**
    * 重写父类的方法
    * @return
    */
  override def toString: String = name + "\t" + age + "\t" + salary + "\t" + date
}

object ObjectExtends {

  def main(args: Array[String]) {

    val xm = new Xiaoming("xiaoming", 24, 5000.0)
    println(xm.school)
    println(xm.salary)
    println(xm.toString)
  }
}
