package com.zep.scala.grammer.对象与类

/**
  * @author Zhao Peng
  * @version V1.0.0
  * @date 2019/10/19 0019
  * @description scala
  */
class OuterClass{

  // 定义类别名，必须放在起始行
  outer=>

  var name = "scott"

  class Inner{

    def info() ={
      // 访问外部类的属性
      // OuterClass.this就相当于OuterClass的一个实例
      println(s"name ${OuterClass.this.name}")
    }
  }


  // 通过外部类别名进行访问（推荐）
  class AliasInner{
    def info() = {
      println(s"name${outer.name}")
    }

    // 如果这样写，不同的外部对象创建的内部实例，是有匹配问题
    def test1(obj: AliasInner)={

    }

    // 类型投影，这样不会有匹配问题
    def test2(obj: OuterClass#AliasInner)={

    }

  }
}
object InnerClass {

  def main(args: Array[String]): Unit = {
    val outer = new OuterClass
    val inner = new outer.Inner
  }
}