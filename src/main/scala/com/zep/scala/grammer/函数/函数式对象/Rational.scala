package com.zep.scala.grammer.函数.函数式对象

/**
	* @author zpoos
	* @create 2017-11-05 10:00
	**/
// 类参数
class Rational(n : Int, d : Int) {

	require(d != 0, "分母不能为0")

  /**
    * 求d和n的最大公约数
    */
	private val g = gcd(n.abs, d.abs)

	val number : Int = n / g
	val denom : Int = d / g

	// 辅助构造器, 调用系统构造器或者其他构造器
	// 每个辅助构造器的第一个动作都是调用同类的别的构造器
	def this (n : Int) = this(n, 1)

	override def toString: String = number + "/" + denom

	// 虽然 n 和 d 定义为了类参数, 但是只能访问调用add方法的类的类参数.
	// that 实例不是 add 方法的调用类, 所以 add 不能访问其类参数
  // 如果需要在方法内部访问类变量, 则需要将其赋值给成员变量
/*	def add(that : Rational) : Rational = {
		new Rational(n * that.d + that.n * d , d * that.d)
	}*/

	def add(that : Rational) : Rational =
	  new Rational(
			number * that.denom + denom * that.number,
			denom * that.denom
		)

	// + : 是合法的标识符, 可以使用其定义方法名
	def + (that : Rational) : Rational =
		new Rational(
			number * that.denom + denom * that.number,
			denom * that.denom
		)

	def + (i : Int) : Rational = new Rational(number + i * denom, denom)

	def - (that : Rational) : Rational = new Rational(
			number * that.denom - denom * that.number,
			denom * that.denom
		)


	def - (i : Int) : Rational = new Rational(number - i * denom, denom)

	def * (that : Rational) : Rational = new Rational(
		number * that.number,
		denom * that.denom
		)

	def * (i : Int) = new Rational(number * i , denom)

	def / (that : Rational) = new Rational(
		number * that.denom,
		denom * that.number
	)

	def / (i : Int) = new Rational(number, denom * i)

	private def gcd(a : Int, b : Int) : Int = if (b == 0) a else gcd(b, a % b)
}

object Rational{

	/*
	* 隐式转换类 :
	* 	1. 其所带的构造参数有且只能有一个
	* 	2. 隐式类必须被定义在类，伴生对象和包对象里
	* 	3. 隐式类不能是case class（case class在定义会自动生成伴生对象与2矛盾）
	* 	4. 作用域内不能有与之相同名称的标示符
	* */
	implicit class IntRational(x : Int){
		def intToRational() : Rational = new Rational(x)
	}

	def main(args: Array[String]): Unit = {


		/*println(new Rational(6))
		println(new Rational(3) + new Rational(2))*/
		val result = new Rational(3, 2)
		val sum = result + 2
		// 报错 : 因为其本质是 2.+(result), Int类没有参数为Rational的+方法
/*		val sum = 2 + result*/

		// 定义了从Int到Rational的转换方法, 将Int类型转换为Rational类型, implicit告诉编译器可以一些情况下自动调用
		// 隐式转化的时机
		// 1.当方法中的参数的类型与目标类型不一致时
		// 2.当对象调用类中不存在的方法或成员时，编译器会自动将对象进行隐式转换
		implicit def intToRational(x : Int): Rational = new Rational(x)
		println(2 + result)
	}
}
