package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object GenericThree {

  def main(args: Array[String]): Unit = {

  }

  // 泛型方法
  def getMidEle[T](list: List[T]) = list(list.length / 2)


}
