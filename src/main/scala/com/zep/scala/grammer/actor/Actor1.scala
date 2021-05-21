//package com.zep.scala.grammer.actor
//
//import scala.actors.Actor._
//
//// 2.11 之后， scala移除了actor，如果想使用actor，使用akka
///**
//  * @author lenovo
//  * @create 2018/3/29 09:48
//  **/
//object Actor1 {
//  def main(args: Array[String]): Unit = {
//    val badActor = actor {
//      while (true) {
//        receive {
//          case msg =>{
//            println(msg)
//            reply("ggggggg")
//          }
//        }
//      }
//    }
//    println("Do ya feel lucky, punk?")
//    // ! : 表示异步发送消息
//    println(badActor.!?("1111111"))
//    println(badActor.!("dddddddd"))
//    println(badActor.!!("123123123")())
//    println(badActor.!("mmmmmmmmm"))
//  }
//}
