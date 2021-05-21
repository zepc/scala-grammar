package com.zep.scala.grammer.对象与类.组合和继承

/**
  * @author zpoos
  * @create 2017-11-06 08:59
  **/
/*
* 定义抽象类
* */
abstract class Element {

	// Scala鼓励使用将不带参数且有返回值的方法定义为无参数方法
  // 定义无参数方法
	def contents : Array[String]
	def height : Int = contents.length
	def width : Int = if(height == 0) 0 else contents(0).length
}


class ArrayElement(conts : Array[String]) extends Element{

//	override def contents = conts

	// Scala里字段和方法属于相同的命名空间,可以让字段重写无参数方法
	// 用字段重写无参数方法
	val contents : Array[String] = conts
}

// 将父类的字段参数化
class ArrayElement1(val contents : Array[String]) extends Element{

}

class Cat{
	val dangerous = false
}

/**
  * 为参数化的字段添加修饰符, 重写父类的field
  * @param dangerous
  * @param age
  */
class Tiger(override val dangerous: Boolean, private var age : Int) extends Cat{

}
// 等价于上面, 上面为下面的简写形式
// => 其为下面的简写方式
class Tiger1(param1 : Boolean, param2 : Int) extends Cat{
	override val dangerous = param1
	private var age = param2
}

/**
  * 将s传递给父类, 并调用父类的构造器
  * @param s 将子类的参数, 传递给父类, 调用父类的构造器
  */
class LineElement(s : String) extends ArrayElement1(Array(s)){
	override def width = s.length
	override def height = 1
}