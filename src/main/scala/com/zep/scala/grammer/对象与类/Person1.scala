package com.zep.scala.grammer.对象与类

/**
  * 样例类, 自动生成setter和getter方法
  * @param name
  * @param age
  */
case class Student1(name:String, age:Int){
  val height = 190
}

case class Teacher1(name:String, age:Int)

class Person1 {
  val name = "zs"
}

object Person1{
  def main(args: Array[String]) {
      val s1 = Student1("Angelababy",18)
      val s2 = Student1("yaska",40)
      val s3 = Student1("pangSang",60)
      val t1 = Teacher1("agang",44)
      val list = List(s1,s2,s3,t1)
    list.foreach(x=>{
      matchCase(x)
    })
  }
  def matchCase(s:Any): Unit = {
    s match {
      case s: Student1 => println("类型匹配")
      case Student1("pangSang",60) => println("值匹配")
      case _ => println("no match")
    }
  }
}

