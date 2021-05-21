package com.zep.scala.grammer.字符串

/**
  * Created by root on 2017/5/15.
  */
object StringDemo {
  def main(args: Array[String]) {
    val sb = new StringBuilder
    // + 可以直接连接字符, 如果需要连接字符串, 则需要额外赋值
    sb + 'a'
    sb + 'b'
    sb ++= "-avc"
    val test = sb + "a"
    println(test)
    println(sb)

    sb.++=("aa")
    sb.+('a')
    sb ++= "dfgf"
    println(sb)

  }

}
