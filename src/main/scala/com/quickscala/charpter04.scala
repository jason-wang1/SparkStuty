package com.quickscala

import java.io.File
import java.lang.reflect.Field
import java.util
import java.util.{Scanner, StringTokenizer}
import scala.collection.JavaConverters._

import scala.collection.{SortedMap, mutable}

/**
  * Descreption: XXXX<br/>
  * Date: 2020年04月19日
  *
  * @author WangBo
  * @version 1.0
  */
object charpter04 {
  /*
   * 4.1
   * 设置一个映射, 其中包含你想要的一些装备,以及它们的价格,
   * 然后构建另一个映射, 采用同一组键, 但在价格上打9折
   */
  def question1(origin: Map[String, Double]): Map[String, Double] = {
    for (elem <- origin) yield (elem._1, elem._2 * 0.9)
  }


  /*
   * 4.2
   * 编写一段程序, 从文件中读取单次, 用一个可变映射来庆典每一个单次出现的频率,
   * 读取这些单次的操作可以使用java.util.Scanner,
   * val in = new java.util.Scanner(new java.io.File("myfile.txt")),
   * while(in.hasNext()) 处理 in.next() 最后, 打印出所有单次和它们出现的次数
   */
  def question2(path: String): scala.collection.mutable.Map[String, Int] = {
    val in: Scanner = new java.util.Scanner(new java.io.File(path))
    val wc: mutable.Map[String, Int] = mutable.Map[String, Int]()
    while(in.hasNext()) {
      val str: String = in.next()
      str.split(" ")
        .foldLeft(wc)((map, word) => {
          val count: Int = map.getOrElse(word, 0) + 1
          map.put(word, count)
          map
        })
    }
    wc
  }


  /*
   * 4.3
   * 重复前一个联系,这次用不可变的映射
   */



  /*
   * 4.4
   * 重复前一个联系, 这次用已排序的映射,一遍单次可以按顺序打印出来
   */



  /*
   * 4.5
   * 重复前一个联系, 这次用java.util.TreeMap并使之适用于ScalaAPI
   */
  def question5(path: String): scala.collection.mutable.Map[String, Int] = {
    val in: Scanner = new java.util.Scanner(new java.io.File(path))
    val wc: util.TreeMap[String, Int] = new java.util.TreeMap()
    while(in.hasNext()) {
      val str: String = in.next()
      str.split(" ")
        .foldLeft(wc)((map, word) => {
          val count: Int = map.getOrDefault(word, 0) + 1
          map.put(word, count)
          map
        })
    }
    import scala.collection.JavaConverters._
    wc.asScala
  }


  /*
   * 4.6
   * 定义一个链式哈希映射, 将"Monday"映射到java.util.Calendar.MONDAY,
   * 以此类推假如其他日期, 展示元素是以插入的顺序被访问的
   */
  def question6(): Map[String, String] = {
    var map = Map[String, String]()
    val list: Array[String] = classOf[java.util.Calendar].getFields.map(_.toString.split("int ")(1))
    list
      .map(elem =>
        (elem.split(".").last, elem)
      )
      .toMap
  }


  /*
   * 4.7
   * 打印出所有Java系统属性的表格, 类似这样:
   * java.vm.info                  | mixed mode
   * java.version                  | 1.7.0_67
   * sun.cpu.endian                | little
   * sun.desktop                   | windows
   * sun.cpu.isalist               | amd64
   */
  def question7() {
    val props = System.getProperties().asScala
    val manlen = props.map(f => f._1.length).max

    props foreach { x => println(x._1 + " " * (manlen - x._1.length + 1) + "| " + x._2) }
  }


  /*
   * 4.8
   * 编写一个函数minmax(values: Array[Int]), 返回数组中最小值和最大值的对偶
   */
  def question8(values: Array[Int]) = {
    values.foldLeft(values(0), values(0)) { case (tup, elem) =>
      val min = Math.min(tup._1, elem)
      val max = Math.max(tup._2, elem)
      (min, max)
    }
  }


  /*
   * 4.9
   * 编写一个函数lteqgt(values: Array[Int], v: Int),
   * 返回数组中小于v 等于v 和 大于v的数量, 要求三个值一起返回
   */
  def question9(values: Array[Int], v: Int) = {
    values.foldLeft((0, 0, 0)){case (tup, elem) =>
        if (elem < v) (tup._1 + 1, tup._2, tup._3)
        else if (elem > v) (tup._1, tup._2, tup._3 + 1)
        else (tup._1, tup._2 + 1, tup._3)
    }
  }


  /*
   * 4.10
   * 当你将两个字符串拉链在一起, 比如"Hello" zip "World", 回事什么结果?
   * 想处一个讲的同的用例
   */
  def question10() = {
    "Hello" zip "World"
  }



  def main(args: Array[String]): Unit = {
    val price: Map[String, Double] = Map("cloth" -> 18.0, "shoe" -> 30.0)
//    question1(price).foreach(println(_))
//    question5("C:\\Users\\BoWANG\\IdeaProjects\\sparkstudy\\src\\main\\scala\\data\\test.txt").foreach(println(_))
    println(question9(Array(3, 7, 1, 9, 5), 5))
    println(question10())

  }
}