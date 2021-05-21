package com.zep.scala.grammer.进阶

import scala.io.Source

object Tips {

  /**
    * Source 读取数据
    * Scala中没有写数据的方法，需要调用Java的
    */
  def sources(): Unit ={

    val path = "C:\\Program File"
    val urlPath = "http:\\\\www.baidu.com"
    val file = Source.fromFile(path)
    for (line <- file.getLines()) println(line)

    val url = Source.fromURL(urlPath)
    for (line <- file.getLines()) println(line)
  }

  /**
    * lazy 关键字
    *
    * (1)被lazy修饰的某个变量或常量,只有在第一次被使用的时候,才会被实变量例化.
    * (2)当我们用lazy修饰某个变量或者常量的时候,这个变量或者常量就有一种延迟加载与延迟执行的行为,从而增大优化的范围与力度.
    */
  def lazys(): Unit = {

    lazy val path = "c"
  }


  /**
    * zip 将两个数组中的元素进行合并，两个数组的一个元素将组合成一个元组，存入到新的数组中。
    * 如果两个数组的长度不一致， 将以短的数组为准
    */
  def zips(): Unit ={

    val arr1 = Array(1, 2, 3)
    val arr2 = Array(4, 5, 6, 4)
    val zip: Array[(Int, Int)] = arr1.zip(arr2)
    for (value <- zip) println(value)
  }

  def option(): Unit ={

    val scores = Map("Alice"->100, "Jack"->200)
    scores.get("Demo") match {
      case Some(score) => println(score)
      // None 表示 Option 中没有值
      case None => println("No Score")
    }
    // 等价于上面方式
    val aliceScore = scores.get("Alices")
    println(aliceScore.getOrElse("No Score"))
  }

  /**
    * partition ： 将一个字符串根据指定的 Boolean 函数将字符串进行拆分，并返回一个 Tuple2，
    * 元组的第一个元素为 满足该函数组成的字符串， 第二个元素为不能满足该函数组成的字符串
    */
  def partitions(): Unit ={

    // (ZP, aoeng)
    val tuples = "ZhaoPeng".partition(_.isUpper)
    print(tuples)
  }

  def main(args: Array[String]): Unit = {


    // 异或运算
    println(1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 1 ^ 3 ^ 1)
  }
}
