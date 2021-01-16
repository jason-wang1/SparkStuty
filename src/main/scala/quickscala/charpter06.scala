package com.quickscala


/**
  * Descreption: XXXX<br/>
  * Date: 2020年04月20日
  *
  * @author WangBo
  * @version 1.0
  */
object charpter06 {
  /*
   * 6.1
   *  编写一个Conversions对象,
   *  加入inchesToCentimeters  gallonsToLiters和milesToKilometers方法
   */
  def question1(): Unit = {
    object Conversations {
      def inches2Centimeters(inch: Double): Double = {
        2.54 * inch
      }
      def gallons2Liters(gallon: Double): Double = {
        3.78541178 * gallon
      }
      def miles2Kilometers(mile: Double): Double = {
        0.6213712 * mile
      }
    }
    println(Conversations.gallons2Liters(76.8))
  }

  /*
   * 6.2
   * 前一个联系不是很面向对象,
   * 提供一个通用的超类UnitConversion并定义扩展该超类的InchesToCentimeters
   *   GallonsToLiters和MilesToKilometers对象
   */
  def question2(): Unit = {
    abstract class UnitConversion {
      def inchesToCentimeters(inch: Double): Double = {0.0}
      def gallonsToLiters() {}
      def milesToKilometers() {}
    }
    object InchesToCentimeters extends UnitConversion {
      override def inchesToCentimeters(inch: Double): Double = {
        2.54 * inch
      }
    }
    object GallonsToLiters extends UnitConversion {
      override def gallonsToLiters() {}
    }
    object MilesToKilometers extends UnitConversion {
      override def milesToKilometers() {}
    }
    println(InchesToCentimeters.inchesToCentimeters(76.8))

  }

  /*
   * 6.3
   * 定义一个扩展自java.awt.Point的Origin对象, 为什么说这实际上不是个好主意?
   */
  def question3(): Unit = {
    object Origin extends java.awt.Point {}
    println(new java.awt.Point(3, 4))
  }


  /*
   * 6.4
   * 定义一个Point类和一个伴生对象,
   * 使得我们可以不用new而直接用Point(3,4)来构造Point实例
   */
  def question4(): Unit = {
    class Point(x: Int, y: Int) {
      override def toString = s"Point($x, $y)"
    }

    object Point {
      def apply(x: Int, y: Int) = new Point(x, y)

    }
    println(new Point(3, 4))
    println(Point(3, 4))

  }


  /*
   * 6.5
   * 编写一个Scala应用程序, 使用App特质, 以反序打印命令行参数, 用空格隔开,
   * 举例来说, scala Reverse Hello World应该打印出World Hello
   */
  def question5(): Unit = {

  }


  /*
   * 6.6
   * 编写一个扑克牌4种花色的枚举, 使其toString方法分别返回 ♣ ♠ ♥ ♦
   */
  def question6(): Unit = {
    object Joker extends Enumeration {
      val M: Value = Value("♣")
      val T: Value = Value("♠")
      val H: Value = Value("♥")
      val F: Value = Value("♦")

      def color(c: Joker.Value) {
        if (c == Joker.M || c == Joker.T) print("Black")
        else print("Red")
      }
    }

    println(Joker.color(Joker.M))
  }


  /*
   * 6.7
   * 实现一个函数, 检查某张牌的花色是否为红色
   */


  /*
   * 6.8
   * 编写一个枚举,描述RGB立方体的八个角, ID使用颜色值 (例如, 红色是0xff0000)
   */
  def question8(): Unit = {
    class RGB extends Enumeration {
      val RED: Value = Value(0xff0000, "Red")
      val BLACK: Value = Value(0x000000, "Black")
      val GREEN: Value = Value(0x00ff00, "Green")
      val CYAN: Value = Value(0x00ffff, "Cyan")
      val YELLOW: Value = Value(0xffff00, "Yellow")
      val WHITE: Value = Value(0xffffff, "White")
      val BLUE: Value = Value(0x0000ff, "Blue")
      val MAGENTA: Value = Value(0xff00ff, "Magenta")
    }
  }

  def main(args: Array[String]): Unit = {
    question6
  }
}
