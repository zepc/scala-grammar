package com.zep.scala.grammer.对象与类

import java.util.Date

/**
  * Created by root on 2017/5/15.
  */
object Lesson03 {
  def main(args: Array[String]) {
    val date = new Date()
    log(date,"log1")
    log(date,"log2")
    val logWithDateBound = log(date,_:String)
    logWithDateBound("log111")
    logWithDateBound("log222")


    var sum1: (Int) => Int = sum(1)
    println(sum1(2))
  }

  //柯里化函数
  /**
    * 柯里化(Currying)指的是将原来接受两个参数的函数
    * 变成新的接受一个参数的函数的过程。
    * @param a
    * @param b
    * @return
    */
  def sum(a:Int)(b:Int) = {
    a+b
  }


  def log(date:Date,msg:String) = {
    println(date+"\t"+msg)
  }
}
