package com.zep.scala.grammer.函数.函数与闭包

/**
  * @author zpoos
  * @create 2017-11-05 12:18
  **/
class Test {
	// 拼接字符串
	// String* : 表示可以向该方法传递String的List
	// 注意不能传递数组, 只能传递数组的值, 可以使用 `数组名: _*` 表示
	def connect(ss : String*) : String = {
		var s = ""
		for (elem <- ss) {
			s += elem
		}
		s
	}
}

object Test{
	def main(args: Array[String]): Unit = {
		// 字面量函数, 将函数赋值给常量
		val increase = (x : Int) => x + 1
		println(increase(10))
		// 多条语句的字面量函数, 花括号包住函数体, 一行放一句
		val ps = (x : Int) => {
			/*
			* 声明一个tuple
			* */
			val t = x -> 1
			println(t)
			print("hello ")
			print("world")
			println(", scala")
			x + 1
		}
		println(ps(1))


		def sum(a : Int, b : Int, c: Int) : Int = a + b + c

		// 将函数传递给变量, `_` 表示需要传递参数
		val a = sum _
		println(a(1, 2, 3))

		// 偏函数
    // 编译器将其生成的函数类的apply方法不同
    // 此时b为函数变量
		val b = sum(1, _ : Int, 3)
		println(b(1))

		// 闭包 : 捕获自由变量的绑定
		var more = 1
		val addMore = (x : Int) =>{
			more = 3
			x + more
		}

		println(addMore(1)) // 4
		println(more) // 3

		val infos = new Test
		println(infos.connect("1", "2", "3"))

		val arr = Array("2", "3", "3")
		// 类型不匹配
//		infos.connect(arr)
		// 告诉编译器把arr的每个元素当做参数,而不是当作单一的参数传递给该方法
		infos.connect(arr : _*)


		// 当函数的末尾调用为其本身时, 称为尾递归.
		// Scala编译器对末尾表达式只有函数本身的尾递归, 有优化
		// 使用 尾递归 代替 while 循环
	}
}
