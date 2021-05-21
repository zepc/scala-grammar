package com.zep.scala.grammer

/**
  * Created on 2020/05/21.
  *
  * @author Zhao Peng
  */
trait MainTrait{

  def main(args: Array[String]): Unit
}

object MainSplit extends MainTrait {

  override def main(args: Array[String]): Unit = {

    println(s"main方法继承")
  }
}
