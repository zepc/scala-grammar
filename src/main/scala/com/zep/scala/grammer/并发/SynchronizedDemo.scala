package com.zep.scala.grammer.并发

import java.util.concurrent.TimeUnit

/**
  * @author Zep
  * @version V1.0.0
  * @date 2021/03/25.
  * @project IntelliJ IDEA
  * @description
  */
class SynchronizedDemo{

  private var inc: Int = 0

  def addOne = this.synchronized{
    TimeUnit.SECONDS.sleep(1)
    inc += 1
  }

}

object SynchronizedDemo {

  private var inc: Int = 0

  def addOne = this.synchronized{
    TimeUnit.SECONDS.sleep(1)
    inc += 1
  }

  def main(args: Array[String]): Unit = {

    for (i <- 1 to 10){
      new Thread{
        override def run(): Unit = {
          println(s"run thread with object method $i")
          addOne
        }
      }.start()
    }

    new Thread(new Runnable {
      override def run(): Unit = ???
    })

    val instance = SynchronizedDemo
    for (i <- 1 to 10){
      new Thread{
        override def run(): Unit = {
          println(s"run thread with object method $i")
          instance.addOne
        }
      }

      while (true){
        println(s"object inc=$inc, class inc=$inc")
        TimeUnit.SECONDS.sleep(1)
      }
    }

  }

}
