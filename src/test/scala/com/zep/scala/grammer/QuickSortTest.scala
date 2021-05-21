package com.zep.scala.grammer

/**
  * Copyright (c) 2021-2200 Zep All Rights Reserved 
  *
  * @project: lan-scala
  * @package:
  * @version: 1.0
  * @description:
  *
  * Created by Zep on 2021/05/20 00:37         
  */
object QuickSortTest {

//  def quickSort(numbers: List[Int]) : List[Int] = {
//    numbers match {
//      case Nil => Nil
//      case x::xs =>
//        val smaller = for (a <- xs if a < x) yield a
//        val bigger = for (a <- xs if a > x) yield a
//        quickSort(smaller) ::: (x::Nil) ::: quickSort(bigger)
//    }
//  }

  def quickSort(numbers: List[Int]) : List[Int] = {
    numbers match {
      case Nil => Nil
      case x::xs => quickSort(xs.filter(_ > x)) ::: (x::Nil) ::: quickSort(xs.filter(_ < x))
    }
  }


  def main(args: Array[String]): Unit = {
    println(quickSort(List(10, 2, 5, 3, 1, 6, 7, 4, 2, 3, 4, 8, 9)))
  }
}
