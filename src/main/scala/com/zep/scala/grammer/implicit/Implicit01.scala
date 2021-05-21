package com.zep.scala.grammer.`implicit`

/**
  * @author Zhao
  * @create 2018/3/29 11:19
  **/
/*
隐式转换
特殊售票窗口（只接受特殊人群，比如学生、老人）
类型不对会尝试进行隐式转换
 */
case class SpecialPerson(name:String)
case class Student(name:String)
case class Older(name:String)

class Teacher(val name:String)

object Implicit01 {
  /**
    * 当调用方法传入的类型与参数类型不匹配的时候, Scala会自动的查找object下面的所有被implicit修饰的方法
    * 如果找到有相应返回类型的方法的时候, Scala会试图进行调用该方法, 完成隐式转换
    * @param obj
    * @return
    */
  implicit def object2SpecialPerson(obj:Object): SpecialPerson ={
    if(obj.getClass == classOf[Student]){
      val stu = obj.asInstanceOf[Student]
      SpecialPerson(stu.name)
    }else if (obj.getClass == classOf[Older]){
      val older = obj.asInstanceOf[Older]
      SpecialPerson(older.name)
    }else{
      null
    }
  }

  var ticketNumber = 0

  def buySpecialTicket(p:SpecialPerson): String ={
    ticketNumber += 1
    "T-" + ticketNumber
  }

  def main(args: Array[String]) {
    val chengxiaoxiao = Student("chengxiaoxiao")
    println(buySpecialTicket(chengxiaoxiao))
    val gaga = Older("gaga")
    println(buySpecialTicket(gaga))
    val yasaka = new Teacher("yasaka")
    println(buySpecialTicket(yasaka))
  }
}
