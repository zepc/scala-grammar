package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/6/8.
  */
/**
  * 1. Scala中没有静态方法或静态字段，但是通过object语法结构可以达到同样的目的,
  *   所谓Object对象类似于我们Java中的静态(static)类，Object对象里面的所有成员都是静态的,
  *   可以通过Object对象名的方式进行访问
  *
  * 2. 在Scala中,静态的属性和方法只是表明了该成员具有可以通过类对象方式访问的潜在特征,
  *    但是否可以通过类对象的方式进行访问,还必须满足一个条件:
  *    该成员没有被private修饰符修饰(尽管在Scala中属性默认是私有的了)
  *
  * 3. Object对象可以理解为静态成员的集合
  *
  * 4. 在你需要某个类的单个实例时，或者想为其他值或函数找一个可以挂靠的地方时，
  *   可以用到Object对象(Scala中因为Object这种语法结构,导致单态设计要简单的多)
  */

class Demo{

  def prints(): Unit ={

    println(Demo.num)     // 原类可以访问伴生类中的私有变量
  }
}
/*
* 1. 在Java中，你通常会用到既有实例方法又有静态方法的类。在Scala中，你可以通过类和与类同名的”伴生”对象来达到同样的目的.
* 2. 在Scala中,若一个类的名字和一个object对象的名字相同,则这个类称为这个对象的伴生类,这个对象称为这个类的伴生对象
* 3. 伴生类可以访问其伴生对象的所有成员,包括伴生对象的私有成员,但是必须通过伴生对象.成员名的方式进行访问
* 4. 伴生对象并没有在伴生类的作用域当中
* 5. 在Spark当中,静态属性方面的一些配置或者一些隐式转换的导入常用到伴生对象
* */
object Demo{

  private var num  = 1    // 由于是static，JVM为该变量分配一块内存

  def print: Int ={
    num = num + 1
    num
  }
}


object StaticVarAndFunction {

  def main(args: Array[String]) {

    println(Demo.print) // 两次操作的都是同一个内存中的变量
    println(Demo.print)

    val test = new Demo
    println("-------------------")
    test.prints()
  }

}
