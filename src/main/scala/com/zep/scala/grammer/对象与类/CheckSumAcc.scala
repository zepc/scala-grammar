package com.zep.scala.grammer.对象与类

/**
	* @author zpoos
	* @create 2017-11-05 09:53
	**/
class CheckSumAcc {
  // 声明私有变量
	private var sum = 0

	def add(b : Byte) : Unit = sum += b
	def checksum() : Int = - (sum & 0xFF) + 1
}

/**
  * 和上面的效果一样
  * @param sum
  */
class CheckSumAcc1(private var sum : Int = 0){
  def add(b: Byte) : Unit = sum += b
  def checkSum() : Int = - (sum & 0xFF) + 1
}

// 伴生对象, 不需要使用new实例化
object CheckSumAcc{

	def main(args: Array[String]): Unit = {
		val acc = new CheckSumAcc
		acc.add(12)
		println(acc.checksum())
	}
}