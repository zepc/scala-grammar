//package com.zep.scala.grammer.actor
//
//import scala.actors.Actor._
//
///**
//  * @author lenovo
//  * @create 2018/3/29 10:12
//  **/
//
//case class Speak1(line: String)
//case class Gesture1(bodyPart: String, action: String)
//case class NegotiateNewContract1()
//case class ThatsAWrap1()
//
//object Actor3 {
//  def main(args: Array[String]): Unit = {
//    val badActor = actor {
//      var done = false
//      while (!done) {
//        receive {
//          case NegotiateNewContract1 => println("I won't do it for less than $1 million!")
//          case Speak1(line) => println(line)
//          case Gesture1(bodyPart, action) => println("(" + action + "s " + bodyPart + ")")
//          case ThatsAWrap1 => println("Great cast party, everybody! See ya!")
//            done = true
//          case _ => println("Huh? I'll be in my trailer.")
//        }
//      }
//    }
//    badActor ! NegotiateNewContract1
//    badActor ! Speak1("Do ya feel lucky, punk?")
//    badActor ! Gesture1("face", "grimaces")
//    badActor ! Speak1("Well, do ya?")
//
//    badActor ! ThatsAWrap1
//  }
//}
