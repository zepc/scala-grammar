package com.zep.scala.grammer.集合操作

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Copyright (c) 2021-2200 Zep All Rights Reserved 
  *
  * @project: lan-scala
  * @package: com.zep.scala.grammer.集合操作
  * @version: 1.0
  * @description:
  *
  * Created by Zep on 2021/05/09 14:45         
  */
object Test extends App{

  val buffer = new ArrayBuffer[(String, String)]()

  val t = ("1", "2")
  buffer += t

  println(buffer(0))

  //
  val arr = 1 to 10
  arr.slice(0, arr.length -1).foreach(println)
  println("*" * 30)
  arr.init.foreach(println)
  println("*" * 30)
  arr.tail.foreach(println)
  println("*" * 30)
  arr.filter(x => x % 2 == 0).foreach(println)


  println(arr.sum)

  println(s"$$123")

  val ordering = Ordering.fromLessThan[Int](_ > _)
  private val set = mutable.TreeSet.empty(ordering)
  set += (1, 2, 3, -1, 9, 8, 4, -10)
  set.foreach(println)

  println(set(0))
}
