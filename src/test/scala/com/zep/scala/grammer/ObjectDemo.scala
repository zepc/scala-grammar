package com.zep.scala.grammer

/**
  * Created on 2020/05/21.
  *
  * @author Zhao Peng
  */
class ObjectDemo(id: String, name: String, height: Double = 0){

  var weight: Double = 0.0
  var age: Int = 0

  def introduce(): Unit = println(s"My name is $name")

}


object ObjectDemo {

  def main(args: Array[String]): Unit = {

    val demo = new ObjectDemo("0001", "zs"){
      // self相当于this的别名
      self=>

      self.age = 22;

      override def introduce(): Unit = {
        super.introduce()
//        println(s"I'am ${this.age}")
        println(s"I'am ${self.age} years old")
      }
    }

    demo.introduce()
  }
}
