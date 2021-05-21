package com.zep.scala.grammer.函数

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object 控制抽象 {

  // 控制抽象是这样的函数
  // 1. 参数是函数
  // 2. 函数参数没有输入值，也没有返回值

  def main(args: Array[String]): Unit = {

    def runInThread(f: => Unit) = {
      new Thread{
        override def run(): Unit = {
          f
        }
      }.start()
    }

    /**
      * 利用控制抽象函数，实现while
      * @param condition
      * @param block
      */
    def myWhile(condition: =>Boolean)(block: =>Unit): Unit ={
      if (condition){
        block
        myWhile(condition)(block)
      }
    }

    var n = 10
    myWhile(n > 0){
      println(s"n = $n" )
      n += 1
    }
  }
}
