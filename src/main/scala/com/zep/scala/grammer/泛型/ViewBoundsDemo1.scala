package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object ViewBoundsDemo1 {

  /*
  * <% 的意思是“view bounds”，它比<: 适用的范围更广，
  *         除了所有的子类型，还允许隐式转换类型
  * */

  // def method[A <%B](arglist): R 等价于 def method[A](arglist)(implicit viewAB: A=>B):R
  // 或等价于：
  // implicit def convert(a: A): B= ...

  // 类也可以使用view bounds



  def main(args: Array[String]): Unit = {

    import java.lang.Float
    val c1 = new CompareCommon(Float.valueOf(1.1f), Float.valueOf(1.3f)).greater

    val c2 = new CompareCommon[Float](11.1f, 10.3f)

    // 在scala包中，有个object Predef，里面有各种将Java类型转化为Scala类型的隐式转换函数
    // Float2float
    val c3 = new CompareCommon(111.1, 109.7)
  }

  class CompareCommon[T <%Comparable[T]](o1: T, o2 : T){

    def greater = if (o1.compareTo(o2) > 0) o1 else o2

  }
}
