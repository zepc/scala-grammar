package com.zep.scala.grammer

import scala.util.{Failure, Success, Try}

/**
  * Created on 2020/05/22.
  *
  * @author Zhao Peng
  */
object TryDemo {

  def main(args: Array[String]): Unit = {

//    val result = Try { s.toInt }
//    log(result.fold(
//      ex => "Operation failed with " + ex,
//      v => "Operation produced value: " + v
//    ))

    val s = "12a3"
    Try {s.toInt} match {
      case Failure(exception) => println("Operation failed with " + exception.getMessage)
      case Success(value) =>  println("Operation produced value: " + value)
    }

  }
}
