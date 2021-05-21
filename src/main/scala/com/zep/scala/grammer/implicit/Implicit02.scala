package com.zep.scala.grammer.`implicit`

/**
  * @author lenovo
  * @create 2018/3/29 11:26
  **/
/**
使用隐式转换加强现有类型
  超人变身（装饰类型）
  类型没有方法的时候会尝试隐式转换
  */
class Man(val name:String)

class Superman(val name:String){
  def emitLaser(): Unit = println("emit a pingpang ball!")
}

object Implicit02 {

  // 隐式转换方法
  implicit def man2superman(man:Man):Superman = new Superman(man.name)

  def main(args: Array[String]) {
    val yasaka = new Man("yasaka")
    /**
      * 当Scala发现该对象中没有对应的方法的时候, 他会查找object所有的隐式转换的方法, 看看是否有参数为该对象类型的
      * 方法, 并检查返回的类型中是否存在该对象调用的方法, 如果有就执行隐式转换
      */
    yasaka.emitLaser()
  }
}

