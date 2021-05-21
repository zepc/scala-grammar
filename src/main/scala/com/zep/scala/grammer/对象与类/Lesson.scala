package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/5/15.
  */
class Lesson(name:String) {
  /***
    * 主构造函数是由一个参数组成
    * 想要创建一个副构造函数，那么在副构造函数的方法体内必须调用主构造函数
    */
  def this(){
    this("Scala")
  }
}

object Lesson{
  def main(args: Array[String]) {
    var age = 21
    if(age > 18){
      println("可以观看这部电影")
    }else{
      println("禁止18岁以下的观看")
    }

    if(age < 18){
      println("禁止18岁以下的观看")
    }else if(age > 20){
      println("不仅可以观看这部电影，也可以追求电影上的生活方式")
    }else{
      println("可以观看这部电影")
    }

    var index = 0
    var flag = true
    while(flag){
      index += 1
      println("第"+index +"次求婚")
      if(index == 101){
        flag = false
      }
    }


    do{
      index += 1
      println("第"+index +"次求婚")
      if(index == 101 )
        flag = false
    }while(flag)


    // 1 4 7 10
    println(1 to (10 ,3))

    //1 4 7
    println(1 until (10,3))

    for(i <- 1 to 10;j <- 1 to 10){
      if(i>=j)
        print(i+"*"+j+"="+i*j+"\t")
       if(i==j)
         println()
    }
    for(i <- 1 to 10;if i > 5;if i % 2 == 0){
      println(i)
    }

    /**
      * x代表1 to 10 集合中的每一个元素
      * 每一个元素根据判断条件来判断  符合提交的元素赋值给list集合
      * yield的作用：将符合条件的元素 放入到集合中
      */
    val list = for{x <- 1 to 10 if x % 2 == 1} yield x
    for(elem <- list){
      println(elem)
    }

  }
}


