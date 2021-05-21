package com.zep.scala.grammer.对象与类.`trait`

/**
  * Created by zhaopeng on 2017/6/14.
  */
/**
  * 1、特质的另一个应用方面在于：为类提供可堆叠的改变（super保留字）
  *
  *  当为类添加多个互相调用的特质时，从最后一个开始进行处理
  *  在类中super.foo()这样的方法调用是静态绑定的，明确是调用它的父类的foo()方法
  *  在特质中写下了super.foo()时，它的调用是动态绑定的。调用的实现将在每一次特质被混入到具体类的时候才被决定
  */
trait Action {
  def doAction()
}

trait TBeforeAfter extends Action {
  abstract override def doAction(): Unit = {
    println("Hello scala")
    super.doAction()  // 调用某个Trait的具体实现
    println("Hello spark")
  }
}

class Work extends Action {
  override def doAction(): Unit = println("Working ..... ")
}

object UsingTraitImpAOP {
  //当为类添加多个互相调用的特质时，从最后一个开始进行处理
  val aa = new Work with TBeforeAfter
  aa.doAction()
  /**
    * Hello scala
    * Working .....
    * Hello spark
    */
}
