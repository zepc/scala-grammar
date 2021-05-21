package com.zep.scala.grammer.控制抽象

import java.io.{File, PrintWriter}
import java.util.Date

/**
  * @author zpoos
  * @create 2017-11-05 15:21
  **/
class Demo {

	private val files = new File(".").listFiles()

	// 第一版 : 查询是否是某文件的结尾
	def filesEnding (query : String) : Array[File] =
		for (file <- files if file.getName.endsWith(query))
			yield file

	// 第二版 : 需求更改, 筛选出包括某字符串的文件
	def filesContaining (query : String) : Array[File] =
		for (file <- files if file.getName.contains(query))
			yield file


	// 第三版 : 需求更改, 正则表达式匹配
	def filesRegex (query : String) : Array[File] =
		for (file <- files; if file.getName.matches(query))
			yield file

	// 思考 ?
	// 将函数作为值传进函数中, 实现了功能的抽象

	// 第四版
	// query : 重复传递, 所以直接将其交给 matcher 函数
	def filesMatching(query : String, matcher : (String, String) => Boolean) : Array[File] =
		for (file <- files; if matcher(file.getName, query))
			yield file

	def filesEndingS (query : String) : Array[File]  = filesMatching(query, _.endsWith(_))
	def filesContainingS (query : String) : Array[File]  = filesMatching(query, _.contains(_))
	def filesRegexS (query : String) : Array[File]  = filesMatching(query, _.matches(_))

	// 第五版
	def filesMatchingS(matcher : String => Boolean) : Array[File] =
		for (file <- files; if matcher(file.getName))
			yield file

	def filesEndingSS (query : String) : Array[File] = filesMatchingS( _.endsWith(query))
	def filesContainingSS (query : String) : Array[File]  = filesMatchingS( _.contains(query))
	def filesRegexSS (query : String) : Array[File]  = filesMatchingS( _.matches(query))


	// 使用系统提供的函数, 简化客户代码
	def containOdd(nums : List[Int]) : Boolean = nums.exists(_ % 2 == 1)


	// 柯里化
	// 柯里化的函数被应用于多个参数列表, 而不是仅仅一个

	def plainOldSum(x : Int, y : Int) : Int = x + y
	// => 柯里化
	def curriedSum(x : Int)(y : Int) : Int = x + y
	// => 实际调用过程为
	// 第一步 : 函数的返回值为一个函数
	def first(x : Int) : Int => Int = (y : Int) => x + y
	// 第二步 : 调用第一个函数
	val second: Int => Int = first(1)
	// 第三步 : 调用第二个函数
	println(second(1))

	// _是第二个参数列表的占位符
	val onePlus: Int => Int = curriedSum(1)

	val twoPlus = onePlus(2)
	println(twoPlus)


	// 新的控制结构 : 任何时候, 你发现你的代码中多个地方有重复的控制模式时, 就应该考虑把它实现为一个新的控制结构
	// "双倍控制"
	def twice(op : Double => Double, x : Double) = op(op(x))

	// 打开资源, 进行操作, 关闭资源
	def withPrintWriter(file : File, op : PrintWriter => Unit): Unit ={
		val writer = new PrintWriter(file)
		try {
			op(writer)
		} finally {
			writer.close()
		}
	}

	// 使用柯里化规范代码
	def withPrintWriter2(file: File)(op : PrintWriter => Unit): Unit = {
		val writer = new PrintWriter(file)
		try {
			op(writer)
		} finally {
			writer.close()
		}
	}

	var assertionsEnabled = false

	def myAssert(predicate : () => Boolean): Unit =
		if (assertionsEnabled && !predicate()) throw new AssertionError()

	// 使用传名参数
	def byNameAssert(predicate : => Boolean): Unit =
		if (assertionsEnabled && !predicate)
			throw new AssertionError()

	/*
	* 上下两个函数的区别:
	*	boolAssert(5 > 3)里, 5 > 3 先于 boolAssert 的调用被评估. 5 > 3 为 true 传递给 boolAssert
	*	而
	*	byNameAssert 的 predicate 的参数类型是 => Boolean, 5 > 3 不是先于 byNameAssert 的调用被评估的.
	*	而是先创建一个函数, 其 apply 方法将评估 5 > 3, 这个函数将被传递给 byNameAssert
	*
	* 区别 :
	* 	如果断言被禁用, boolAssert里的表达式将会有副作用, byNameAssert 却没有
	* */

	def boolAssert(predicate : Boolean): Unit =
		if (assertionsEnabled && !predicate)
			throw new AssertionError()
}

object Demo{
	def main(args: Array[String]): Unit = {
		val demo = new Demo
		println(demo.twice(_ + 1, 5))
		demo.withPrintWriter(
			new File("/Users/zhaopeng/Documents/代码/SQL/411sql.sql"),
			writer => writer.print(new java.util.Date())
		)

		val file = new File("/Users/zhaopeng/Documents/代码/SQL/411sql.sql")
		// 对于单个参数的函数, 可以使用大括号, 让其更加的像的内置的控制结构
		demo.withPrintWriter2(file){
			writer => writer.print(new Date())
		}
		// 看着难看
		demo.myAssert(() => 5 > 3)

		// 产生异常
//		println(demo.boolAssert(2 / 0 == 0))
		// 不产生异常
		println(demo.byNameAssert(2 / 0 == 0))

		Either
	}
}
