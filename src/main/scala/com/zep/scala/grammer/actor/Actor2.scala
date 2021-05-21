//package com.zep.scala.grammer.actor
//
//import scala.actors.Actor._
//
///**
//  * @author lenovo
//  * @create 2018/3/29 10:04
//  **/
//case class Speak(line: String)
//case class Gesture(bodyPart: String, action: String)
//case class NegotiateNewContract()
//
//
//object Actor2 {
//  def main(args: Array[String]): Unit = {
//    val badActor = actor(
//      receive {
//        case NegotiateNewContract => println("I won't do it for less than $1 million!")
//        case Speak1(line) => println(line)
//        case Gesture(bodyPart, action) => println("(" + action + "s " + bodyPart + ")")
//        case _ => println("Huh? I'll be in my trailer.")
//      }
//    )
////    badActor ! NegotiateNewContract
////    badActor ! Gesture("face", "grimaces")
////    badActor ! Speak("Well, do ya?")
//    badActor ! "Well, do ya?"
//  }
//}
