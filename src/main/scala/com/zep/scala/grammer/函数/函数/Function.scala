package com.zep.scala.grammer.函数.函数

object Function {

  def sayHelloToSomeone(name : String): Unit ={
    println("hello, " + name)
  }

  /**
    * 带默认参数的函数
    * @param name 默认参数
    */
  def sayMyName(name: String = "Zao"): Unit ={
    println(name)
  }

  /**
    * 如果函数体只有一句话, 可以省略大括号
    * @param a
    * @param b
    * @return
    */
  def sumTwoNumber(a:Int, b:Int): Int = a + b

  /**
    * 向函数传递多个参数
    * @param num 参数列表
    * @return 和
    */
  def sumMoreParameters(num : Int*): Int ={
    var sum = 0
    for (elem <- num) {
      sum += elem
    }
    sum
  }

  /**
    * 如果是递归函数, 必须要有返回值
    * @param n
    * @return
    */
  def fac(n : Int) : Int = if(n <= 0) 1 else n * fac(n - 1)


  /**
    * 函数柯里化
    *   把这个参数一个个独立开来写,这就是柯里化
    *   柯里化在递归，和控制抽象方面比较有用
    * @param x x
    * @param y y
    * @return
    */
  def mulitply(x : Int)(y : Int) : Int = x * y

  /**
    * 柯里化就是把参数可以分开来，把部分函数参数可以用下划线来代替
    * m2 此时是一个函数
    */
  val m2 : Int => Int = mulitply(10)

  /**
    * => 匿名函数声明方式.
    * 声明了一个函数, 赋值给了变量t, 此时t是一个函数类型的变量.
    * 使用t(), 调用这个函数.
    * 匿名函数, 没有返回值
    */
  val t = () => 333 //声明了一个函数对象付给了t

  val t1: Int => Unit = { c => println(c) }

  /**
    * 将函数作为参数
    * @param c
    */
  def testFunc(c : () => Int) : Unit = {
    println(t())
  }

  /**
    * 嵌套函数, 外层函数可以调用内层函数
    * @param a
    * @param b
    * @param c
    * @return
    */
  def add3(a : Int, b : Int, c : Int) : Int ={
    def add2(x : Int, y : Int) = {
      println("a + b = ", x + y)
      x + y
    }
    add2(add2(a, b), c)
  }

  /**
    * 高阶函数：
    *   函数的参数或者返回类型是函数的函数
    *
    * 函数的参数和返回类型都是函数,并且该函数是嵌套函数
    * 操作结果 : f(a,b) + f(a + 1, b) + .... a <= b
    * @param f
    * @return
    */
  def sum(f : (Int, Int) => Int) : (Int, Int) => Int = {
    def sumF(a : Int, b : Int) : Int = {
      if (a > b) 0 else f(a, b) + sumF(a + 1, b)
    }
    sumF
  }

  /**
    * to 包括 100
    */
  def test(): Unit = {
    for (i <- 1 to 100){
      println(i)
    }
  }

  /**
    * until 不包括 100
    */
  def test1(): Unit = {
    for (i <- 1 until 100){
      println(i)
    }
  }

  /**
    * if对i进行过滤, 可以使用多个if
    */
  def test2(): Unit ={
    for (i <- 1 to 100 if i % 2 == 1; if i % 5 > 3){
      println(i)
    }
  }

  /**
    * match的使用, 每个case后面默认都有break
    * @param n
    * @return
    */
  def test3(n: Int): Int ={
    val message = n match {
      case 1 =>
        println("这是 1")
        n + 10
      case 2 =>
        println("这是2")
        n+20
      case _ =>       // 相当于 default
        println("这是默认值")
        n
    }
    message
  }

  def main(args: Array[String]): Unit = {
    sayMyName()
    sayHelloToSomeone("world")
//    println(sumMoreParameters(1, 2, 4, 5, 90))
//    println(sumTwoNumber(1, 2))
//    println(fac(3))
//    println(m2(2))
//    println(t())
//    testFunc(t)
//    println(add3(23, 2, 4))
//    def add(a : Int, b : Int) : Int = a + b
//    println(sum(add)(1, 3))
    test3(2)
  }
}
