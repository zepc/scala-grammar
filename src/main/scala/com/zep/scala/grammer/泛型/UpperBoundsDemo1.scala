package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object UpperBoundsDemo1 {

  /*
  * [T <:A]：A是T的上界，或者使用通配符[_ <:A]
  * */

  // Int并没有实现Comparable接口，Integer实现了

  def main(args: Array[String]): Unit = {
    val maxInt = new CompareComm[Integer](Integer.valueOf(10), Integer.valueOf(12)).greater
    println(s"max of int is $maxInt")

    import java.lang.Float
    val maxFloat = new CompareComm[Float](Float.valueOf(1.1f), Float.valueOf(1.2f)).greater
    println(s"max of float is $maxFloat")

  }
}

class CompareComm[T <:Comparable[T]](obj1: T, obj2: T){
  def greater = if(obj1.compareTo(obj2) > 0) obj1 else obj2
}
