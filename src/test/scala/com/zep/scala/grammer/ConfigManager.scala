package com.zep.scala.grammer

import java.io.InputStream
import java.util.Properties
import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Copyright (c) 2021-2200 Zep All Rights Reserved 
  *
  * @project: lan-scala
  * @package:
  * @version: 1.0
  * @description:
  *
  * Created by Zep on 2021/05/16 09:38         
  */
object ConfigManager {

//  Thread.currentThread().getContextClassLoader().getResource(“”) //获得资源文件(.class文件)所在路径
//  ClassLoader.getSystemResource(“”)
//  ClassName.class.getClassLoader().getResource(“”)
//  ClassName.class .getResource(“/”)
//  ClassName.class .getResource(“”) // 获得当前类所在路径
//  System.getProperty(“user.dir”) // 获得项目根目录的绝对路径
//  System.getProperty(“java.class.path”) //得到类路径和包路径

//  private val config = {
//    val is = this.getClass.getClassLoader.getResourceAsStream("demo.properties")
//    // File中的路径可以是绝对路径，也可以是相对于当前项目的路径
//    // 当编译成字节码之后，因为resouces路径不存在，所以无法找到对应的demo.properties
//    val reader = Source.fromFile("demo.properties").reader()
//    val config = new Properties()
//    try {
//      println(s"加载properties文件")
//      config.load(reader)
//    } catch {
//      case e: IOException => println(s"加配置文件失败!${e.printStackTrace()}")
//    } finally {
//      reader.close()
//    }
//    config
//  }

  implicit def string2is(name: String): InputStream = this.getClass.getClassLoader.getResourceAsStream(name)

  def load(op : Properties => Unit): Properties = {
    val config = new Properties()
//    try {
//      op(config)
//    } catch {
//      case _: Exception => throw new Exception("加载配置文件失败！！！")
//    }
    Try {
      op(config)
    } match {
      case Failure(_) => throw new Exception("配置文件加载失败~~~~~!!!!")
      case Success(value) =>
        println("加载文件成功" + value)
        config
    }
  }

//  private def load(name: String): Properties = {
//    val config = new Properties()
//    try{
//      config.load(name)
//    } catch{
//      case _ : Exception => println(s"加载 $name 失败")
//    } finally {
//      name.close()
//    }
//    println("加载配置文件")
//    config
//  }

//  val config = load(_.load("demo.properties"))

  private lazy val config = {
    val config = new Properties()
    val url = getClass.getClassLoader.getResource("demo.properties")
    val reader = Try {Source.fromURL(url).reader()} match {
      case Failure(_) =>  throw new Exception("配置文件读取失败~~~~~~!!!!!!!!!!!!!")
      case Success(reader) => reader
    }
    Try {
      config.load(reader)
    } match {
      case Failure(_) => throw new Exception("配置文件加载失败~~~~~~!!!!!!!!!!!!!")
      case Success(_) => config
    }
  }
  def getString(name: String) = config.getProperty(name)
  def getInt(name: String) = config.getProperty(name).toInt

}

object Test{

  def main(args: Array[String]): Unit = {

    println(ConfigManager.getString("name"))
    println(ConfigManager.getInt("age"))
    println(ConfigManager.getString("123-123"))
  }

}


