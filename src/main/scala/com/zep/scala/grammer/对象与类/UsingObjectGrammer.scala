package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/6/6.
  */
/**
  * 1. Scala中的类默认是public级别的,如果用户添加public修饰符,将会报错
  * 2. Scala中的属性默认是private级别的,Scala中的方法默认是public级别的.
  * 3. 类中的属性必须被赋值,否则会报错
  */
/*
* getter和setter
*
*   1. 类中的var属性自动带有getter方法和setter方法
*   2. getter方法和setter方法默认是共有的,但是如果属性加上了private修饰符(尽管字段本身已经是private了)，
*      则getter方法和setter方法将会变成私有的
*   3. 用户可以自行定义类setter方法和getter方法的函数
*   4. 被val修饰的属性,在底层是final类型的private字段,只有getter方法,没有setter方法(
*      符合我们在Java中学的:被final修饰的属性,一旦被赋值,数值将不能被修改,同时也符合Scala中的val永不改变的规定)
* */
class Test{   // 默认是 public

  outer=>

  type Info =  Test

  val name = "zhaopeng"   // 默认是 private
  val age = 23
  private[this] val height = 179.0  // 子类和对象不能访问

  def func(): Unit ={   // 默认是 public

    println(name + "'s age is " + age, height)
    func3
  }

  private def func3 = {
    println(s"height is $height")
  }

  class InnerClass {

    def test = {
      println(outer.height)
    }
  }

  def func2(info : Test): Unit ={

    println(info.name)
  }
}

class TestSon(override val age: Int, override val name: String) extends Test{

  def test = {
    println(s"height is $age")
  }
}

/**
  * 1. 若用户提供了主构造器,系统将不会再提供主构造器,否则系统将会提供无参的主构造器
  * 2. 在Scala中，每个类都有主构造器。主构造器并不以this方法定义，而是与类定义交织在一起定义
  * 3. 主构造器的参数将会被编译成类的属性成员
  * 4. 除了方法(函数)以外,主构造器会执行类中定义的所有语句
  * 5. 一旦用户通过private关键字来修饰主构造器,就只能通过辅助构造器来构造对象了
  */
class StudentConstructor{

  var name : String = _       // 占位符将由编译器自动赋值
  var height : Double = _
  var age : Int = _

  def this(name : String, height : Double, age : Int){
    this    // 辅助构造函数调用主构造函数
    this.name = name
    this.height = height
    this.age = age
  }

  def func(): Unit ={

    println(name + " *** " + height)
  }
}

/**
  * 主构造函数
  */
class Student2(name : String, height : String, age : Int){

  def func(): Unit ={
    println(name + " *** " + height)
  }
}

/**
  * 内部类
  */
class Teacher(val name : String){

  // outer ：外部类的一个别名, 通过别名访问构造函数中的变量
  outer=>

  class Info(val name : String){

    def func(): Unit ={
      println(outer.name + " ****** " + this.name)
    }
  }
}

object UsingObjectGrammer {

  def main(args: Array[String]) {
    val info = new Test
    val name = info.name  // 是通过系统为变量生成的 setter 和 getter 方法进行访问和设置的
    info.func()

    val test = new info.InnerClass
    test.test

    println("*" * 20)
    val teacher = new Teacher("Cang")
    val tInfo = new teacher.Info("ML")
    tInfo.func()
  }
}
