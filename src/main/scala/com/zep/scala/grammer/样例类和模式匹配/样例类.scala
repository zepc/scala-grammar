package com.zep.scala.grammer.样例类和模式匹配

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/11/3 0003
  * @description scala
  */
object 样例类 {

  /*
  * 1、case只用来修饰class和object, 也就是说只有case class 和case object的存在,
  *   而没有case trait 或者class **这一说
  *
  * 2、case object /class A 这个A 是经过序列化, 而且继承了Product特性同时有toString,hashCode,copy,equals方法,
  *   case class会默认生成apply和unapply方法，case object则不会生成
  *
  * 3、case class 经常可以用于解析和提取
  *
  * 4、case object相当于无参的case class，只是起到了标志的作用，所以有参用case class, 无参用case object
  * */
}
