package com.zep.scala.grammer.`implicit`

/**
类型方法有但是参数不一致会尝试调用隐式转换
 */

class TicketHouse{
  var ticketNumber = 0
  def buySpecialTicket(p:SpecialPerson) = {
    ticketNumber += 1
    "T-" + ticketNumber
  }
}

object Implicit03 {

  implicit def object2SpecialPerson(obj:Object): SpecialPerson ={
    if(obj.getClass == classOf[Student]){
      val stu = obj.asInstanceOf[Student]
      new SpecialPerson(stu.name)
    }else if (obj.getClass == classOf[Older]){
      val older = obj.asInstanceOf[Older]
      new SpecialPerson(older.name)
    }else{
      Nil
    }
  }

  def main(args: Array[String]) {
    val ticketHouse = new TicketHouse
    val yasaka = new Student("yasaka")
    println(ticketHouse.buySpecialTicket(yasaka))
  }
}
