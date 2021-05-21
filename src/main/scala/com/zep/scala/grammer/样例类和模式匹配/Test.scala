package com.zep.scala.grammer.样例类和模式匹配

// case class 同样可以有方法
/*
1) 样例类仍然是类
2) 样例类用 case 关键字进行声明。
3) 样例类是为模式匹配(对象)而优化的类
4) 构造器中的每一个参数都为 val——除非它被显式地声明为 var（不建议这样做）
5) 在样例类对应的伴生对象中提供 apply 方法让你不用 new 关键字就能构造出相应的对象
6) 提供 unapply 方法让模式匹配可以工作
7) 将自动生成 toString、 equals、 hashCode 和 copy 方法(有点类似模板类，直接给生成，供程序员使用)
* */


abstract class Item // 项, 抽象类，价值在于统一管理
//Book 样例类， description 描述 , price 价格
case class Book(description: String, price: Double) extends Item
//捆 discount ： 打折金额 item: Item* 可以有其它的商品或者 Bundle
case class Bundle(description: String, discount: Double, item: Item*) extends Item

object Test {

  def match_any(): Unit = {
    for {x <- Seq(1, 2, 2.7, "one", "two", 'four)} {
      val str = x match {
        case 1 => "int 1" //匹配值为1的整数
        case i: Int => "other int: " + i //匹配非1的整形内容，将匹配项赋值给变量i
        case d: Double => "a double: " + x //匹配Double类型内容，将匹配项赋值给变量d
        case "one" => "string one" //匹配字符串为“one”
        case s: String => "other string:" + s //匹配除“one”的其他字符串
        case unexpected => "unexpected value:" + unexpected //除以上几种匹配的所以模式
      }
      println(str)
    }
  }

  def main(args: Array[String]): Unit = {
    //说明实例
    //sale 是一捆书 [单本书 ， Bundle("文学作品", 20, Book("《阳关》 ", 80), Book("《围城》 ", 30) ]
    //手工计算: = (40 – 10) + ((80+30)-20) = 120 =>递归计算
    val sale = Bundle("书籍", 10, Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》 ", 80), Book("《围城》 ", 30)))
    val result = sale match {
      case Bundle(_, _, Book(desc, _), _*) => desc
      case Bundle(_, _, art @ Book(_, _), rest @ _*) => (art, rest) // 使用@，将嵌套的值绑定到变量上
      case Bundle(_, _, art @ Book(_, _), rest) => (art, rest) // 不用_*，将剩余的直绑定到变量上
    }
  }
}

