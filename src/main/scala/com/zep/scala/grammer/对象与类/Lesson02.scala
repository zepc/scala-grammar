package com.zep.scala.grammer.对象与类

/**
  * Created by root on 2017/5/15.
  */
class Lesson02 {

}

object Lesson02{
  def main(args: Array[String]){
   // print(sum(1,2))
    println(sumMoreParm(1,2,3,4,5,6))
    println(fact(10))

    println(addInt())
//    ()=>{println("hello")}
    val nf = (a:Int,b:Int) =>  {
         a+b
    }
//    println(nf(1,2))

  }


  def sum(a:Int,b:Int):Int = {
    //最后一行语句的执行结果作为整个函数的返回值
    a+b
    println()
    a
  }


  def sumMoreParm(elems : Int*) = {
    var sum = 0
    for(elem <- elems){
      sum += elem
    }
    sum
  }


  //递归函数必须设置返回值的类型
  def fact(num:Int):Int = {
    if(num == 1){
      1
    }else{
      num * fact(num - 1)
    }
  }

  def addInt( a:Int=5, b:Int=7 ) : Int = {
    var sum:Int = 0
    sum = a + b
    sum
  }

}
