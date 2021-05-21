package com.zep.scala.grammer

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2018/12/24 0024
  * @description scala
  */
object StringTest extends App {

  val s = "   "
  println(s.trim.isEmpty)

  // 测试 """ 的使用
  val mac = 1
  val startTime = System.currentTimeMillis()
  Thread.sleep(3000)
  val leaveTime = System.currentTimeMillis()
  val stayTime: Long = leaveTime - stayTime
  val multi =
    s"""{"mac":$mac,"in_time":$startTime,"out_time":$leaveTime,"stay_time":$stayTime}""".stripMargin
  println(multi)

  private val value: String = "123" // string 是 java.lang.string

  val name = "123".getBytes

  println(name.toString)
}
