//package com.zep.scala.grammer.actor
//
///**
//  * @author lenovo
//  * @create 2018/3/29 10:18
//  **/
//
//case class Speak2(line: String)
//case class Gesture2(bodyPart: String, action: String)
//case class NegotiateNewContract2()
//case class ThatsAWrap2()
//
//
//
//
//object Actor4 {
//
//  def main(args: Array[String]): Unit = {
//    def ct = "Thread" + Thread.currentThread().getName + ": "
//    val badActor = actor {
//      var done = false
//      while (!done) {
//        receive {
//          case NegotiateNewContract2 => println(ct + "I won't do it for less than $1 million!")
//          case Speak2(line) => println(ct + line)
//          case Gesture2(bodyPart, action) => println(ct + "(" + action + "s " + bodyPart + ")")
//          case ThatsAWrap2 => println(ct + "Great cast party, everybody! See ya!")
//            done = true
//          case _ => println(ct + "Huh? I'll be in my trailer.")
//        }
//      }
//    }
//    println(ct + "NegotiateNewContract...")
//    badActor ! NegotiateNewContract2
//    println(ct + "Speaking...")
//    badActor ! Speak2("Do ya feel lucky, punk?")
//    println(ct + "Gesturing...")
//    badActor ! Gesture2("face", "grimaces")
//    println(ct + "Speaking again...")
//    badActor ! Speak2("Well, do ya?")
//    println(ct + "Wrapping up")
//    badActor ! ThatsAWrap2
//  }
//}
