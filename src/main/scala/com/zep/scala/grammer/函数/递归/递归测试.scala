package com.zep.scala.grammer.函数.递归

import java.text.SimpleDateFormat
import java.util.Date

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object 递归测试 {

  /*
  * 在函数式编程中提倡使用递归
  * */

  def main(args: Array[String]): Unit = {

    def withoutRecursion() = {
      val now: Date = new Date()
      val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val date = dateFormat.format(now)
      println("执行前 date=" + date) //输出时间
      var res = BigInt(0)
      var num = BigInt(1)
      var maxVal = BigInt(99999999l) //BigInt(99999999l)[测试效率大数]
      while (num <= maxVal) {
        res += num
        num += 1
      }
      println("res=" + res)
      //执行完毕时间
      val now2: Date = new Date()
      val date2 = dateFormat.format(now2)
      println("执行后 date2=" + date2) //输出时间
    }

    /**
      * 尾递归优于while
      */
    def recursion() = {
      val now: Date = new Date()
      val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val date = dateFormat.format(now)
      println("执行递归前 date=" + date) //输出时间
      var num = BigInt(1)
      var sum = BigInt(0)
      var res = mx(num, sum)
      println("res=" + res)
      //执行完毕时间
      val now2: Date = new Date()
      val date2 = dateFormat.format(now2)
      println("执行递归后 date2=" + date2) //输出时间
    }

    // 递归的方式来解决
    // 递归 : 传统的递归，因为递归的次数多，会造成栈溢出, 释放不及时
    // 尾递归: 利用某些编译器的特点，将每次运算的结果，做成参数传递到递归函数中
    // 1. 栈可以及时的释放，提高效率.=> 迷宫回溯(最短路径)
    def mx(num: BigInt, sum: BigInt): BigInt = {
      if (num <= 99999999l) mx(num + 1, sum + num)
      else sum
    }

    withoutRecursion()
    recursion()

  }

}
