package com.zpoo.www

/**
  * scala 中包的创建
  *
  * scala中不但可以定义类,还可以定义包(在Java当中不可以),而且包还可以嵌套定义
  */
/**
  * 包的作用域
  *
  */
/**
  * 1> 不带花括号的包作用域从定义到文件的末尾结束
  */
package ITZP

/**
  * 2> 带花括号的包作用域在整个括号的范围之内
  */
package spark.navigation{

  protected abstract class Navigator{

    def act()
  }

  package tests{

    class NavitatiorSuite{

    }
  }

  package imples{

    class Action extends  Navigator{
      override def act(): Unit = println("Action!")
    }
  }
}

// 3> 后面的包在前面的包作用域之下
// 三级相互嵌套的包层结构
package IT04{
  package IT05{
    package IT06{

    }
  }
}

//scala 中包对象的使用
package IT07{
  object App{
    def main(args: Array[String]): Unit = {
      println(IT07.people.defaultName)
    }
  }

  package object people {

    val defaultName = "Scala"
  }

  package people{
    class people{
      var name = defaultName
    }
  }
}


