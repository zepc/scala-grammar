package com.zep.scala.grammer.函数.函数

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object 柯里化 {

  def main(args: Array[String]): Unit = {

    // 正常
    def multiply1(x: Int, y: Int) = x * y

    // 闭包
    def multiply2(x: Int)=  (y: Int) => x * y

    // 柯里化 , 将函数功能的构建，更加有步骤的
    def multiply3(x: Int)(y: Int)=  x * y


    def equalsString(a: String)(b: String) = a.toLowerCase.equals(b.toLowerCase)




    // 隐式类
    implicit class TestEq(a: String){

      def checkEq(b: String)(f: (String, String) => Boolean) =
        f(a.toLowerCase, b.toLowerCase())
    }

    val s1 = "hello"
    val s2 = "HELLO"

    println(s1.checkEq(s2)(_.equals(_)))
  }
}
