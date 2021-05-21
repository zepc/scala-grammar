//package com.zep.scala.grammer.actor
//
//import scala.actor.Actor
//
///**
//  * @author lenovo
//  * @create 2018/3/29 10:25
//  **/
//class  HelloActor1 extends Actor{
//  override def act(): Unit = {
//    while (true) {
//      receive{
//        case name: String => println("Hello, ", name)
//        case money: Int => println("How much?", money)
//      }
//    }
//  }
//}
//object HelloActor1 {
//  def main(args: Array[String]): Unit = {
//    val helloActor = new HelloActor1
//    helloActor.start()
//    helloActor.!("Scala")
//  }
//}
