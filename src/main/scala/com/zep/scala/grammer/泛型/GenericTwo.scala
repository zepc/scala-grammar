package com.zep.scala.grammer.泛型

import com.zep.scala.grammer.泛型.Season.Season


/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object GenericTwo {

  def main(args: Array[String]): Unit = {
    val cls1 = new EnglishClass[String](Season.spring, "java", "架构师")
    val cls2 = new EnglishClass[Int](Season.spring, "scala", 1)
    println(s"Season.spring: ${Season.spring.id}")
    println(s"Season.spring: ${Season.summer.id}")
    println(s"Season.spring: ${Season.winter.id}")
    println(s"Season.spring: ${Season.test}")
    println(s"Season.spring: ${Season.test.id}")
  }

}

/**
  * 定义枚举类型
  */
object Season extends Enumeration{
  type Season = Value // 定义泛型类是Value类型，这样才能使用
  val spring, summer, winter, autumn = Value

  // 如果是上面的那种写法，那么id默认从0开始，Season.test显示的字符串是test
  // 下面更改id和字符串显示
  val test = Value(10, "Enum Test")
}

class EnglishClass[T](val season: Season, val name: String, val typ: T)