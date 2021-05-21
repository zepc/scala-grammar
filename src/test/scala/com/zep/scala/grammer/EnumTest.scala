package com.zep.scala.grammer

/**
  * Copyright (c) 2021-2200 Zep All Rights Reserved 
  *
  * @project: lan-scala
  * @package:
  * @version: 1.0
  * @description:
  *
  * Created by Zep on 2021/05/16 10:07         
  */
object EnumTest {

  def main(args: Array[String]): Unit = {
    println(WeekDay.MONDAY.toString.isInstanceOf[String])
  }
}

object WeekDay extends Enumeration{
  val SUNDAY = Value("Sunday")
  val MONDAY = Value("Monday")
  val TUESDAY = Value("Tuesday")
  val WEDNESDAY = Value("Wednesday")
  val THURSDAY = Value("Thursday")
  val SATURDAY = Value("Saturday")
}
