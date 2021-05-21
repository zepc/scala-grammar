package com.zep.scala.grammer.对象与类.`trait`

/**
	* @author zpoos
	* @create 2017-11-06 09:37
	**/
trait Philosophical {
	def philosophize(): Unit ={
		println("I consume memory , therefore I am!")
	}
}

trait HashLegs

class Animal

// 混入多个特质
// 先执行第一个Trait的内容, 再执行第二个Trait
class Frog extends Animal with Philosophical with HashLegs{
	override def toString = "green"
	override def philosophize(): Unit = println("It ...")
}


object Demo{
	def main(args: Array[String]): Unit = {
		val frog = new Frog
		println(frog)
		frog.philosophize()

		// 特质同样可以是类型
		val phil : Philosophical = frog
		phil.philosophize()
	}
}