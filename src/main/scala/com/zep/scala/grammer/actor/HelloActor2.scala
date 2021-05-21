//package com.zep.scala.grammer.actor
//
///**
//  * @author lenovo
//  * @create 2018/3/29 10:33
//  **/
//
//case class Message(content: String, sender: Actor)
//
//class OneActor extends Actor{
//  override def act(): Unit = {
//    var flag = true
//    while (flag) {
//      receive {
//        case Message(content, sender) => println("One receive : " + content)
//          sender ! 10000
//        case bye: String =>
//          flag = false
//          println("Bye bye, Two")
//      }
//    }
//  }
//}
//
//class TwoActor(val oneActor: OneActor) extends Actor{
//
//  oneActor ! Message("Hello, ONE, I'm TWO. Are you free now?", this)
//
//  override def act(): Unit = {
//    var flag = true
//    while (flag) {
//      receive {
//        case response: String => println("TWO received: " + response)
//        case response: Int =>
//          flag = false
//          println("Thank your money " + response)
//          println("Bye Bye, One")
//          oneActor ! "Bye bye"
//      }
//    }
//  }
//}
//
//object HelloActor2 {
//  def main(args: Array[String]): Unit = {
//    val oneActor = new OneActor
//    val twoActor = new TwoActor(oneActor)
//
//    oneActor.start()
//    twoActor.start()
//  }
//}
