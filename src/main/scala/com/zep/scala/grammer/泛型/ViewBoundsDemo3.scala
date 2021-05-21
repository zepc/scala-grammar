package com.zep.scala.grammer.泛型

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/20 0020
  * @description scala
  */
object ViewBoundsDemo3 {

  implicit def personToOrderedPeson(person: Person2) = new Ordered[Person2]{
    override def compare(that: Person2) = {
      println("hello compare 被调用~~~")
      person.age - that.age
    }
  }

  def main(args: Array[String]): Unit = {

    val mary = new Person2("mary", 120)
    val dim = new Person2("dim", 123)

    val cmp = new CompareCommon(mary, dim)
    println(s"compare result is ${cmp.greater}")
  }


  class Person2(val name: String, val age: Int){

    override def toString = this.name + "\t" + this.age
  }

  // T 是 Ordered[T]的子类型，同时支持隐式转换

  class CompareCommon[T <% Ordered[T]](o1: T, o2: T){

    def greater = if (o1 > o2) o1 else o2

    def greater2 = if (o1.compareTo(o2) > 0) o1 else o2
  }
}
