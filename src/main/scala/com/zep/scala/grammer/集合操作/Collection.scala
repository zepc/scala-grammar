package com.zep.scala.grammer.集合操作

import scala.collection.mutable.ArrayBuffer

/**
  * Created by root on 2017/6/6.
  */
object Collection {

  def main(args: Array[String]) {

//        tupleTest()
//    mapTest()
//    setTest()
    listTest()
//    arrayTest()

    import util.control.Breaks._
    var n = 10

    breakable{
      while (n <= 20){
        n += 1
        if (n == 18){
          break()  // 默认会直接让程序崩溃
        }
      }
    }
  }

  def string2Int(args: Array[String]) : Unit ={
    // 将String类型转换为Int
    def unapply(str: String): Option[Int] = {
      try {
        Some(str.toInt)
      } catch {
        case e: NumberFormatException => None
      }
    }

    val Array(name, age, height) = args

    println("height : " + height + ", age : " + age + ", height * age : " + unapply(height).get * unapply(age).get)
    val t = new ArrayBuffer[Int](5)
    for(i <- 1 to 3){
      t += i
    }
    t.foreach(println)
  }

  /**
    * (1)元组是不同类型的数值的集合
    * (2)元组的值是通过将单个的值包含在圆括号中构成的
    * (3)通过下标与模式匹配来获取元组中的数据,在模式匹配中,通过使用占位符可以获取指定位置上的数据
    * (4)通过使用partition方法返回一个元组，在这个元组中分别包含了满足某个条件和不满足该条件的字符.
    */
  def tupleTest(): Unit ={

    val tuples = ("zhaopeng", 123, 23.90)

    val ps = (x : Int) => {
      /*
      * tuple语法糖
      * */
      val t: (Int, Int) = x -> 1
    }


    // 元组之间的赋值
    val (one ,two, three) = tuples

    // 将字符串根据指定的规则, 进行分区, 返回一个元组
    // (ZP, haoeng)
    val tps = "ZhaoPeng".partition(_.isUpper)
    println(tps)
  }

  // map 测试
  // 方法同　Set 和 List
  def mapTest(): Unit ={

    val basicMap = Map(
      "Zhaopeng" -> 24,
      "Linlin" ->23,
      "Peter" -> 22,
      "Jeff" -> 28,
      "Mike" -> 29,
      "Zoo" -> 30,
      "Info" -> 22
    )
    // 获取 keySet
    val keys = basicMap.keys
    // 获取 valueSet
    val values = basicMap.values
    println(s"values = $values, keys = $keys")
    // 删选key , 返回满足条件的 kv
    val result = basicMap.filterKeys(_.equals("Zhaopeng") )
    result.foreach(println)

    // 创建可变的map
    val mutableMap = scala.collection.mutable.Map("Zhaopeng" -> 24, "Linlin" ->23)
    //如果符合满足条件的返回 true
    mutableMap.retain((k,v)=> k=="Zhaopeng")
    println(keys + " " + values)

    for((key, value) <- basicMap) println(key + " --- " + value)
    // scala中的yield的主要作用是记住每次迭代中的值,并将操作结果存入到集合中
    val map = for((key, value) <- basicMap) yield (key, value + 1)
  }


  // Set
  def setTest(): Unit = {

    val basicSet = Set(2, 3, 4, 5, 7, 9)
    println(basicSet.count(_ % 2 == 0))
    println(basicSet.getClass.getName)
    // 判断Set中是否存在满足条件的元素
    println(basicSet.exists(_ % 2 == 0))
    // 删除当前Set中的前N个元素, 返回删除后的结果
    val ints = basicSet.drop(3)
    ints.foreach(println)
    println(basicSet)

    // 创建可变的 Set
    val mutableSet = scala.collection.mutable.Set(7, 8, 11, 12, 13, 10, 9)
    // 向set中添加元素
    mutableSet += 1
    println(mutableSet)
    mutableSet.add(40)
    // 删除set中指定的元素
    mutableSet -= 1
    println(mutableSet)
    // 将两个Set组合成一个Set
    val resultSet = mutableSet ++ basicSet
    // 求两个集合的交集
     println(mutableSet & basicSet)
    // 求两个集合的差集
    println(mutableSet &~ basicSet)
    // 求两个集合的差集
    println(mutableSet.diff(basicSet))
    println(resultSet)
    // 返回满足条件的元素的个数
    println(mutableSet.count(_ > 10))
    // 判断Set中元素是否全部满足条件
    println(mutableSet.forall(_ > 3))
    // 返回Set中所有元素的积， 该Set中的所有元素必须是数值型，才能够调用该方法
    println(mutableSet.product)
    // 集合元素的个数
    println(mutableSet.size)
    // 将 Set 转换成 buffer
    val buffer = resultSet.toBuffer
    println(buffer)
  }


  // List
  def listTest(): Unit ={
    // 创建一个List
    val createList = List(1, 2, 3, 4, 2, 100, 20, 2, 3, 4)

    val i = createList.foldLeft(0){_ + _}

    val list: List[Any] = List(1, 2, 3, "abc")
    // 0 /: createList相当于createList.foldLeft(0)
    val j = (0 /: createList)(_ + _)
    println(s"i = $i, j = $j")
    println("*" * 20)
    val testList = List(2, 3, 4, 100, 200)
    var max = 0
    var count = 0
    for (element <- createList; if max < element) {max = element; count += 1}
    createList.foreach(println)
    println("************")
    print("max : " + max +" count : " + count)

    val lines = List("123-456", "789-002")
		lines.foreach(println)
		// flatMap : 先将List中的元素根据函数进行处理，然后再将处理后的元素，存储到额外的List中，并将其返回
    val resultList = lines.flatMap(_.split("-"))
    resultList.foreach(println)
    // 根据传入的字符串将List中的元素进行组合
    val resultString = resultList.mkString("-")
    println(resultString)

    // Nil : 表示一个空List
    // :: 将单个元素添加到集合中头部
    // ::: 将一个集合添加到集合中头部
    // 这两个方法是集合中
    val combineList = "Sougou" :: ("Google" :: ("Baidu":: Nil))
    println(s"combineList = $combineList")
    val reverseList = combineList.reverse

    // 将　reverseList 中的所有元素添加到 lines 中
    val targetList = reverseList:::lines
    targetList.foreach(println)
    reverseList.foreach(println)

    val stringBuilder = new  StringBuilder("123")
    stringBuilder.append("zhaopeng")

    // addString : 将集合中的元素拼接成一个字符串，拼接StringBuilder的后面
    val combineString= combineList.addString(stringBuilder)
    //将集合中的元素以***号进行分隔，并在集合元素组成的字符串的开始和末尾分别追加 "Begin" 和 "End", 然后再追加StringBuilder的后面
    val combineString2 = combineList.addString(stringBuilder,"Begin","***","End")

    println("combineString2 : " + combineString2)
    // apply : 获取指定下标的元素
    println(combineList.apply(2))

    // 是否包含指定元素
    println(combineList.contains("Google"))

    val tempArr = new Array[String](4)
    // 将List复制到数组中， 第一个参数：待复制的数组， 第二个参数 : 复制的起始下标， 第三个参数 ：复制的长度
    combineList.copyToArray(tempArr, 0 ,2)
    tempArr.foreach(println)

    // 删除元素
    // distinct ： 去除List中的重复元素
    createList.distinct.foreach(println)
    // 删除前n个元素，并将剩余的元素返回
    createList.drop(3).foreach(println)
    // 删除后n个元素
    createList.dropRight(3).foreach(println)
    // 根据 while 条件进行删除， 删除到第一个不满足的元素，直接返回剩下的元素List
    val dropList =  createList.dropWhile( _ < 4)
    // 去除尾部元素，将剩余的元素返回
    print(createList.init)

    // List之间比较
    // 判断一个List是否以另一个List结尾
    println(createList.endsWith(List(2,3,4)))
    // 判断两个List是否相等
    print(createList.equals(testList))
    // 判断List中是否存在满足条件的元素
    println(createList.exists(_ > 3))
    // List中的所有元素是否都满足该条件
    print(createList.forall(_ < 101))
    // 求两个List的交集
    createList.intersect(testList).foreach(println)

    // 对List中的每一个元素应用该函数
    createList.foreach(_ + 1)
    // 检索ele, 从第n位开始检索
    val index = createList.indexOf(4,3)
    println(index)

    // 查找元素
    // 获取List的最后一个元素
    println(createList.last)
    // 获取元素最后一次出现的下标，设置待查找的元素，并将传递结束的位置
    println(createList.lastIndexOf(4, 9))
    // 获取List中的最大和最小元素
    println(createList.max)
    println(createList.min)

    // 将List中的元素组合成字符串，起始字符为BEGIN,结束字符为END,List中的元素使用“-”拼接成字符串传返回
    println(createList.mkString("BEGIN","-","END"))
    // reverseMap：首先将List中的元素进行反转，然后将其中的每个字符，作用传入的函数
    createList.reverseMap(println)
    // 将List中的元素进行排序，默认升序
    println(createList.sorted)
    // 是否以指定的序列开头
    val isStart = createList.startsWith(List(1,2,3))
    println(isStart)
    // 将List中的每个元素进行求和, 如果调用 sum, 那么List中的元素必须是 数值类型
    val sum = createList.sum
//    val sum2 = List("zhaopeng","Sha","linlin").sum
//    println(sum2)

    // 获取指定位置的元素
    // 返回前N个元素
    println(createList.take(3))
    // 返回后N个元素
    println(createList.takeRight(3))
    // 将List转换成数组
    println(createList.toArray)
    // Seq 相当于Java中的List，其是一个trait,也就是接口， 而List相当于 Java 中的 LinkedList
    println(createList.toSeq)
    // 将List转换成Set，去重
    println(createList.toSet)
    // 将List转换成Map, 当List中存储的是二元组的时候， 可以将List转换成 Map
    val tupleList = List((1,"zhaopeng"),(2, "Linlin"),(3,"Love"))
    println(tupleList.toMap)
    println("*****************")



    // 创建可变的 List
    val listBuffer = scala.collection.mutable.ListBuffer(1, 2, 3, 4)
    listBuffer(1) = 3
    listBuffer += 3
    // 对List进行排序
    // sortBy(func)：按照func进行排序
    // 使用 _ 表示省略的参数的时候必须将其放置在表达中
    listBuffer.sortBy(_ + 0).foreach(println)
    listBuffer.foreach(println)

    // 对List中元素进行过滤，只留下返回 true 的元素
    listBuffer.filter(_ > 2).foreach(println)

    // 返回去除头部的元素的List
    println("tail : ")
    listBuffer.tail.foreach(println)

    // head ：获取List中的第一个元素并返回
    println("head : ")
    val head = listBuffer.head
    println(head)
    // 将List转换为数组
    listBuffer.toArray.foreach(println)
  }


  // 数组
  def arrayTest(): Unit ={
    // apply(数组元素)
    val intArray = Array.apply(1,2,3)
    val intArray2 = Array(1, 2, 3) // 等同于上面
    val ints = intArray.toBuffer // 转换成变长数组，但是intArray没有变化

    // ArrayBuffer -> List
//    val list: util.List[String] = new ProcessBuilder(ints).command()


    //    intArray.map(println)
    val boolArray = Array.apply(1, 2)
    // 合并的数据必须是两个类型相同的数组
    val catArray = Array.concat(intArray, boolArray)
    // 创建一个空的数组
    val emptArray = Array.empty
    // 数组的长度为3， 使用元素3进行填充
    val fillArray = Array.fill(3)(3)
    val copyArray = new Array[Int](4)
    // 最后一个参数为要复制字段的长度
    Array.copy(intArray,0,copyArray,0,3)
    // 数组的iterate(start, length)(a => a+1)
    // 解释 ： 数组A的初始值为0, a表示数组的下标, 对每个数组元素执行+1操作
    val iterateArray = Array.iterate(0, 2)(_+1)
    println("iterate : ")
    iterateArray.foreach(println)
    // 使用指定区间和步长创建数组
    val rangeArray = Array.range(0,10,2)
    // 创建长度为3的数组，并将数组的下标代入函数进行运算将返回值存入到数组中
    val tubalateArray = Array.tabulate(3)(_+100)
    tubalateArray.foreach(println)
    rangeArray.foreach(println)
    iterateArray.foreach(println)
    copyArray.foreach(println)
    fillArray.foreach(println)
    print(emptArray.length)
    catArray.foreach(println)
    val myArray = new Array[String](3)
    myArray(0) = "XiaoMing"
    myArray(1) = "Zhaopeng"
    myArray(2) = "WeiLinlin"

    val arr2 = Array(1, 2, 3, 4)
    //    arr2.map(println)
    //    myArray.foreach(println)

    // 创建多维数组
    val arr3 = Array.ofDim[Int](3, 2)
    //    var i = 0
    //    //for(元素 <- 集合) 只能取值不赋值， 元素默认修饰为　val
    //    for (eles <- arr3){
    //      for (element <- eles){
    //        i += 1
    //        element = i + "message"
    //      }
    //    }
    //    println(arr3.length)
    for (i <- arr3.indices) {
      for (j <- arr3(i).indices) {
        arr3(i)(j) = i * j
      }
    }
    //    for (eles <- arr3; element <- eles){
    //      println(element)
    //    }
    for (i <- arr3.indices; element <- arr3(i).indices) {
      //       print(arr3(0))
      //      print(i + "*")
      //      println(element)
      //      print(arr3(i)(1))
    }

    // ArrayBuffer 相当于 ArrayList
    val numbers = new ArrayBuffer[Int]()
    numbers += 3
  }
}
