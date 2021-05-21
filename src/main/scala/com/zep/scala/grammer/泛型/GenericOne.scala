package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object GenericOne {

  def main(args: Array[String]): Unit = {
    val intMsg = new IntMessage[Int](100)
    println(intMsg.get)
  }
}

abstract class Message[T](msg: T){
  def get: T = msg
}

class StringMessage[String](s: String) extends Message(s)
class IntMessage[Int](i: Int) extends Message(i)


