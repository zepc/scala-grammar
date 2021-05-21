//package com.zep.scala.grammer.对象与类.`trait`
//
///**
//  * Created by root on 2017/6/14.
//  */
//
//abstract class Animal {
//
//  def walk(speed : Double)
//  def breath(): Unit ={
//
//    println("abstract")
//  }
//}
//
///**
//  * 定义特征
//  */
//trait Flyable{
//
//
//  def fly()
//  def test(): Unit ={
//    println("Trait 中可以有普通的方法")
//  }
//}
//
//trait Swimable{
//
//  def swim()
//}
//
///**
//  *  Trait 相当于 Java 中的接口和抽象类
//  */
///**
//  *  Trait 的使用：如果是第一次使用trait,并且trait前面没有其它的类或者抽象类,就需要使用extends关键字,
//  *           而后使用with关键字(注意:不是implements关键字)
//  */
//class FlyFish extends Animal with Flyable with Swimable{
//
//  override def walk(speed: Double): Unit = println("walk speed is " + speed)
//
//  override def fly(): Unit = println("Flyable")     // 重写特质中的方法
//
//  override def swim(): Unit = println("Swimable")
//}
//
//
//trait FlySwim extends Flyable with Swimable{
//
//  override def fly(): Unit = println("fly")
//
//  override def swim(): Unit = println("swim")
//}
//
//class EagleFish extends Animal{
//
//  override def walk(speed: Double): Unit = println("walk")
//}
//
//object UsingTraitOne {
//
//  def main(args: Array[String]) {
//
//    val animal: FlyFish = new FlyFish
//    animal.fly()
//    animal.swim()
//    animal.walk(12.3)
//
//    /**
//      * 混入特质的第一种方式
//      */
//    // 在scala中,通过trait我们可以将一些具体实现的方法混入到我们的类或对象中.
//    // (注意:创建对象时混入特质，要重写trait中的抽象方法 )
//    // 直接将 Trait 混入到 类 的实现中
//    val eaglefish = new EagleFish with FlySwim
//    eaglefish.fly()
//  }
//}
