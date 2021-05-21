package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/6/8.
  */

/**
  * 约定1:
  *
  * 在明确了方法调用的接收者的情况下，若方法只有一个参数时，调用的时候就可以省略点及括号。
  *
  * 如 “0 to 2”，实际完整调用是 “0.to(2)”。
  *
  * 但 “println(2)” 不能写成 “println 10“”，因为未写出方法调用的接收者 Console，所以可以写成 “Console println 10”
  */
/**
  * 约定2:
  *
  * 用括号传递给变量(对象)一个或多个参数时，Scala 会把它转换成对 apply 方法的调用
  *
  * 对上面这段话的解释可由下面两个例子得到很好的理解:
  *
  *     1. theArray(0), 取数组的第一个元素的操作会转换成 theArray.apply(0) 操作，
  * 这也能解释为什么Scala数组取值不用中括号括下标的方式，因为它也是一次方法调用
  *
  *     2. anyObject(“key1”)会被转换成anyObject.apply(“key”)操作，这也会让我们想到Map的取值操作，的确如此。
  *
  *
  * 我们可以作个例子：
  */
object FunctionTops {

  def main(args: Array[String]) {

    /**
      * 约定 1 ：
      */
    println("Hello Spark")
    Console println "Hello Spark"

    /**
      * 约定 2 ：
      */
    val arr = Array(1, 2, 3, 4)
    println(arr(0))
    println(arr.apply(0))

    println("--------------")

    /*    val test = Using("zp")
        println(test.sum)*/
  }
}


/**
  * 常见用法 ： apply在伴生类与伴生对象中
  * 最常用的一种方式就是:在object的伴生对象中,通过实现apply的方式来构造相应类的实例对象
  */
//class Using(val sum: Int = 1) {
class Using(val sum: Int) {

  /**
    * 第二个构造方法, 必须调用其他构造方法
    *
    * @param name
    */
  def this(name: String = "ele") = {
    this(20)
  }

  def apply(str: String): Unit = {
    println("Hello apply")
    println(str)
  }
}

object Using {
  def apply(name: String): Using = {
    println("Hello World")
    new Using(name)
  }
}