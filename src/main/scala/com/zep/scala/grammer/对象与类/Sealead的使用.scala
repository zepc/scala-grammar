package com.zep.scala.grammer.对象与类

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/11/3 0003
  * @description scala
  */


/*
* sealed的作用：
* 1. 其修饰的trait，class只能在当前文件里面被继承；
* 2. 在检查模式匹配的时候，用sealed修饰目的是让scala知道这些case的所有情况，
*    scala就能够在编译的时候进行检查，看你写的代码是否有没有漏掉什么没case到，
*    减少编程的错误。
* */

sealed abstract class Person

case object American extends Person
case object Japanese extends Person
case object Chinese extends Person
case object Russia extends Person


object Sealead的使用 {

  def main(args: Array[String]): Unit = {

  }

  /** 模式匹配没有匹配完全，编译的时候会进行警告。
    * 如果不想警告，则写为
    * {{{
    *   = (p: @unchecked) match{
    *     case ...
    *     case ...
    *     case ...
    * }}}
    *
    * @param p
    */
  def people(p: Person) = p match {
    case American => println(" American ")
    case Japanese => println(" Japanese ")
    case Chinese => println(" Chinese ")
  }

}