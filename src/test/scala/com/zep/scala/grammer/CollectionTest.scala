package com.zep.scala.grammer

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/7/6 0006
  * @description scala
  */
object CollectionTest {


//  :: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表, 单个元素。
  // 用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，
  //也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
//
//  :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，
  // 但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。
//
//  ++ 该方法用于连接两个集合，list1++list2
//
//  ::: 该方法只能用于连接两个List类型的集合

  def main(args: Array[String]): Unit = {

    val arr = Array(1, 2, 3)
    val buffer = new ListBuffer[Int]
    println(s"insert before buffer is ${buffer.size}")
    buffer.insertAll(0, arr)
    println(s"insert after buffer is ${buffer.size}")
    buffer.foreach(println)

    val map = Map(
      "a" -> "a1",
      "b" -> "b1",
      "c" -> "c1",
      "d" -> "d1",
    )
    val elmts = List("a", "b", "c", "d").foldLeft(mutable.ArrayBuffer[String]("1")) {
      (array, dimension) => {
        array += map.getOrElse(dimension, "x")
      }
    }
    println(elmts)

    val s = ("1" +: map.values.toList)
//    val s = ("1" :: map.values.toList)
    println(s)

    val right = List("a", "b", "c", "d").foldRight(mutable.ArrayBuffer[String]("1")){
      (dimension, array) => {
        array += map.getOrElse(dimension, "x")
      }
    }
    println(right)

    val a = Array(1).filter(_ != 1) match {
      case Array() => "I am a Nil"
      case _ => "I am a not Nil"
    }

    println(a)

    (1 +: Array(2)).foreach(println)

    val sum2 = (1 to 10000)
      .map(i => i * i)
      .filter(_ % 2 == 1)
      .takeWhile(_ < 10000)
      .sum

    println(sum2)

    // List map vs. mapConserve
    val xs = List.fill(10000)("foo")
    println(xs.map(t => t) eq xs) // false
    println(xs.mapConserve(t => t) eq xs) // ture 当f为映射自己的函数时，返回ture

    val nums = for (x <- 1 to Int.MaxValue if x * x < 100000 && x * x % 2 == 1) yield x
    println(nums.sum)
  }
}
