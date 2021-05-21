package com.zep.scala.grammer.基本语法

import java.io.File

import scala.io.StdIn

/**
  * Created by root on 2017/6/6.
  */
object Basic {

  def main(args: Array[String]) {

//    tuples
//    arrays
//    maps
    // 无参数和返回值时, 方法的调用
    fors
//		print(if(! args.isEmpty) args(0) else "scala xml")
  }

  def returns(i : Double, j : Double): Double ={
    val x = i
    val y = j
    x + y
  }

  def ifelses(args : Array[String]): Unit ={
    val file = if(!args.isEmpty) args(0) else "scala.txt"
    println(file)
  }

  def dowhiles(args : Array[String]): Unit ={

    var line = ""
    do{
      line = StdIn.readLine()
      println(line)
    }while(line != "")
  }

  def fors(): Unit ={

    for(i <- 1 to 10) println(i)
    val files = new File("c:\\").listFiles()
    for (file <- files) println(file)
//     双层 for
    for(i <- 0 to 2; j <- 0 to 2) println(i + " *** " + j)
//     满足条件的输出
    for(i <- 0 to 2; j <- 0 to 2 if i != j) println(i + " *** " + j)
  }

  def breaks(): Unit ={

    for (i <- 1 until 10) {
      // 使用 break 需要导入包
      import scala.util.control.Breaks._
      if (i == 5) break
      println(i)
    }
  }

  def cases(): Unit ={

    val n = 99
    try {
      val m = if (n % 2 == 0) n / 2 else throw new RuntimeException("run wrong!!")
    } catch{
      case e : RuntimeException => println("Exception is " + e)
    }
  }

  def tuples(): Unit ={

    val tuples = ("zhaopeng", "xiaoming", 123, 345, 80.2)
    println(tuples._1)
    println(tuples._4)

    var a@b = "Spark"  // a是b的别名
    println(a+"***"+b)
    a = "hadoop"
    println(a + "-----------" + b)
  }

  def arrays(): Unit ={

    val arr = Array(1, 2, 3)
    for (e <- arr) println(e)
    for(i <- arr.indices) println(" " + arr(i))
  }

  def maps(): Unit ={
    val map = Map("zhaopeng" -> 123, "xiaoming" -> 456)
    val keyset = map.keySet
    for(key <- keyset) println(map.get(key))
    for((k,v) <- map) println(k + " -- -- " + v)
    for ((k,_) <- map) println(k)
  }
}
