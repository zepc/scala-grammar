package com.zep.scala.grammer.函数.函数

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object 闭包 {

  // 闭包就是一个函数和与其相关的引用环境（变量/值）组合的一个整体(实体)

  def main(args: Array[String]): Unit = {

    def minusxy(x: Int) = (y: Int) => x - y

    /**
      * 1. minusxy 返回了 (y: Int) => x – y 匿名函数
      * 2. 使用到 x 值， x 是它引用到的一个环境变量
      * 3. 匿名函数和 x 组合成一个整体，构成了一个闭包
      */
    // 返回函数是一个对象，而 x 就是该对象的一个字段，他们共同形成一个闭包
    // 在使用闭包时,主要搞清楚返回函数引用了函数外的哪些变量，因为他们会组合成一个整体(实体),形成一个闭包

    // f就是一个闭包
    val f = minusxy(20)

    def makeSuffix(suffix: String) = (filename: String) =>
      if (filename.endsWith(suffix)) filename else filename + "." + suffix


    /**
      * 闭包，因为可以保留上次引用的某个值，所以我们传入一次就可以反复调用
      * */
    val makeJPG = makeSuffix("jpg")
    println(makeJPG("1.jpg"))
    println(makeJPG("2"))
    println(makeJPG("3.jpg"))
  }
}
