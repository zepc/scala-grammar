package com.zep.scala.grammer.`implicit`

/*
 * 隐式参数
 */
class SignPen{
  def write(content: String): Unit = println(content)
}

object ImplicitContext{
   implicit val signPen: SignPen = new SignPen
}

object Implicit04 {

  def signForExam(name:String)(implicit signPen : SignPen): Unit ={
    signPen.write(name + " arrive in time.")
  }

  def main(args: Array[String]) {
    import ImplicitContext._
    /**
      * 当函数调用的时候, 从导入的包中查找是否存在与参数类型相同的并且被implicit修饰的变量, 如果存在直接调用该变量
      */
    signForExam("yasaka")
    signForExam("laoxiao")
  }
}
