//package com.zep.scala.grammer.泛型
//
//import tech.com.zep.scala.grammer.泛型.ViewBoundsDemo1.CompareCommon
//
///**
//  * @author Zhao Peng
//  * @version V1.0.0
//  * @date 2019/10/20 0020
//  * @description scala
//  */
//object ContextBoundsDemo1 {
//
//
//  implicit val personComparetor = new Ordering[Person]{
//    override def compare(x: Person, y: Person) = {
//      println("隐式值得 personComparetor 比较器被调用")
//      x.age - y.age
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//
//    val p1 = new Person("mary", 30)
//    val p2 = new Person("smith", 30)
//
//
//    val r1 = new CompareCommon(p1, p2)
//    val r2 =
//  }
//
//  class Person(val name: String, val age: Int){
//
//    override def toString = this.name + "\t" + this.age
//  }
//
//  // 上下文界定有三种写法
//
//  // 1. implicit comparetor: Ordering[T] 隐式参数
//  class CompareCommo1[T: Ordering](o1: T, o2: T)(implicit comparetor: Ordering[T]){
//
//    def greater = if (comparetor.compare(o1, o2) > 0) o1 else o2
//  }
//
//  // 2. 将隐式参数放到方法内
//  class CompareCommon2[T: Ordering](o1: T, o2: T){
//
//    def greater = {
//      // 定义隐式函数
//      def f1(implicit comparetor: Ordering[T]) = comparetor.compare(o1, o2)
//      // 使用
//      if (f1 > 0) o1 else o2
//    }
//  }
//
//  // 3. 使用implicitly语法糖，推荐使用
//  class CompareCommon3[T: Ordering](o1: T, o2: T){
//
//    def greater = {
//      // 这句话就是会发生隐式转换，获取到隐式值personComparetor
//      // implicitly[Ordering[T]] 作用是进行上下文的匹配，如果有
//      //  Ordering[T]类型，就会匹配到，并赋值给comparetor
//      val comparetor = implicitly[Ordering[T]]
//
//      // 使用
//      if (comparetor.compare(o1, o2) > 0) o1 else o2
//    }
//  }
//}
