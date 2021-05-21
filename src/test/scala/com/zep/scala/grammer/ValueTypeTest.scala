package com.zep.scala.grammer

/**
  * Copyright (c) 2021-2200 Zep All Rights Reserved 
  *
  * @project: lan-scala
  * @package:
  * @version: 1.0
  * @description:
  *
  * Created by Zep on 2021/05/12 22:48         
  */
object ValueTypeTest {

  def main(args: Array[String]): Unit = {
    val data = Seq(
      Employee(1, 143.5, 5.6, 28, "M", 100000),
      Employee(2, 167.2, 5.4, 45, "M", _: Int)
//      Employee(3, _: Double, 5.2, null, null, null),
//      Employee(4, 144.5, 5.9, 33, "M", null),
//      Employee(5, 133.2, 5.7, 54, "F", null),
//      Employee(6, 124.1, 5.2, null, "F", null),
//      Employee(7, 129.2, 5.3, 42, "M", 76000)
    )

    data.foreach(println)
  }
}
case class Employee(id: Int,
                    weight: Double,
                    height: Double,
                    age: Int,
                    gender: String,
                    income: Int = 0)
