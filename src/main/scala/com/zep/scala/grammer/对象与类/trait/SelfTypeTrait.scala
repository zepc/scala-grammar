package com.zep.scala.grammer.对象与类.`trait`

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/19 0019
  * @description
  *             自类型的Trait
  */
object SelfTypeTrait {

  def main(args: Array[String]): Unit = {

  }


  trait Logger {

    // 明确告诉编译器，Logger特质就是Exception类型的，所有混入Logger的类必须是Exception的子类
    this: Exception =>

    def log(): Unit = {
      // 因为Logger是Exception类型的，所以可以调用Exception的getMessage方法
      println(getMessage)
    }
  }


  class A extends Exception with Logger

}
