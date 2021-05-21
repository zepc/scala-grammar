package com.zep.scala.grammer.样例类和模式匹配

/**
	* @author Eric Zhao
	* @create 2017-11-06 10:38
	**/

/**
  * 封闭类:
  *   除了类定义所在的文件之外不能再添加任何新的子类
  *   对模式匹配来说, 编译器会检查是否对所有的情况进行了处理
  */
sealed abstract class Expr


/**
  * 样例类:
  *   Scala编译器会给样例类添加语法上的便捷设定
  *     1. 会添加与类型一致的工厂方法,使用样例类便捷的创建对象 : val v = Var("x")
  *     2. 样例类的参数列表中的所有参数隐式获得了val前缀,所以参数被视为了字段,而不是方法
  *     3. 编译器为你的类添加了方法toString,hashCode和equals的"自然"实现
  */
case class Var(name : String = "ele") extends Expr
case class Number(num : Double = 20000.0) extends Expr
case class UnOp(operator : String = "+", arg : Expr) extends Expr
case class BinOp(operator : String = "+", left : Expr, right : Expr) extends Expr

object Demo {

	def simplifyTop(expr: Expr) : Expr = expr match {
		case UnOp("-",UnOp("-", e)) => e
		case BinOp("+", e, Number(0)) => e
		case BinOp("*", e, Number(1)) => e
    // 将e作为变量, UnOp("abs",_) 作为模式的变量绑定模式,如果整个模式匹配成功, 那么符合UnOp("abs", _)的部分就可以使用e指代
		case UnOp("abs",e @ UnOp("abs", _)) => e
		case _ => expr
	}

	def describe(x : Any): String = x match {
		case 5 => "five"
		case true => "truth"
		case "hello" => "hi!"
    // 模式守卫 : 只有满足if才进行匹配
		case n : Int if n > 0 => "正数"
    // 类似于 _ => , 但是变量必须出现在右侧
		case somethingElse => "not zero: " + somethingElse
	}


	//Option类型的模式匹配9
	// 两种情况 : Some(x) x 为实际的值, None, 代表缺失的值
	def show(x : Option[String]): String = x match {
		case Some(s) => s
		case None => "?"
	}

	def main(args: Array[String]) {
//		println(describe(1))

		val a = Number(1000)
		val b = Number(200)
    val zero = Number(0)
		val minus = UnOp("-", a)
		val bin = BinOp("+", a, zero)

		val expr = simplifyTop(bin)

		print(s"expr is $expr")
	}
}
