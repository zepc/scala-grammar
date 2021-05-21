package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object ViewBoundsDemo2 {

  def main(args: Array[String]): Unit = {

    val jack = new Person("jack", 34)
    val smith = new Person("smith", 23)

    val result = new CompareComm2(jack, smith).greater2

    println(s"result is $result")
  }
}


// Ordered 就是 Comparable的scala版本
class Person(val name: String, val age: Int) extends Ordered[Person]{
  override def compare(that: Person) = {
    println("Person 的 compare 被调用")
    this.age - that.age
  }

  override def toString = this.name + "\t" + this.age
}

class CompareComm2[T <% Ordered[T]](o1: T, o2: T){

  def greater = if (o1 > o2) o1 else o2

  def greater2 = if (o1.compareTo(o2) > 0) o1 else o2
}
