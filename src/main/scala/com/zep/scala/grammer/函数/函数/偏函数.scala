package com.zep.scala.grammer.函数.函数

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object 偏函数 {

  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, "abc")
    val f = new PartialFunction[Any, Int] {
      /*
      * 当使用偏函数时，会遍历集合的所有元素，编译器执行流程时先执行 isDefinedAt()如果为 true ,
      * 就会执行 apply构建一个新的 Int 对象返回
      * */
      // 先走这个函数，如果为true走apply
      override def isDefinedAt(x: Any) = {
        println("a")
        if (x.isInstanceOf[Int]) true else false
      }

      override def apply(v1: Any) = {
        println("b")
        v1.asInstanceOf[Int] + 1
      }
    }
    // map 函数不支持偏函数，因为 map 底层的机制就是所有循环遍历，无法过滤处理原来集合的元素
    // collect可以
    val result = list.collect(f)
    println(s"result is $result")


    // 偏函数简化形式
    def f2: PartialFunction[Any, Int] = {
      case i: Int => i + 1 // 在底层，会转化成对应的偏函数
    }
    list.collect(f2)

    // 偏函数简化形式2，推荐使用
    list.collect{case i:Int => i + 1}
  }
}
