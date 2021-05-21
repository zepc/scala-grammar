package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object 协变逆变 {

  // 类的继承关系延续到泛型

  /*
  * 1) C[+T]：如果 A 是 B 的子类，那么 C[A]是 C[B]的子类，称为协变
  * 2) C[-T]：如果 A 是 B 的子类，那么 C[B]是 C[A]的子类，称为逆变
  * 3) C[T]：无论 A 和 B 是什么关系， C[A]和 C[B]没有从属关系。称为不变
  * */


  def main(args: Array[String]): Unit = {

    // Temp2[+A] 表示协变，Super是Sub父类，Temp2[Super]也是Temp[Sub]的父类
    val t: Temp2[Super] = new Temp2[Sub]("hello world")

    // Temp1[-A] 表示逆变，Super是Sub父类，Temp[Super]是Temp[Sub]子类
    val t1: Temp1[Sub] = new Temp1[Super]("hello world")
  }

  class Temp1[-A](title: String){

    override def toString = title
  }

  class Temp2[+A](title: String){

    override def toString = title
  }

  class Super

  class Sub extends Super

}
