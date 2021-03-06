package dataframe

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.expressions.{Window, WindowSpec}
import ulits.SparkConfig

/**
  * 输入：schema为（用户id，观看日期，观看次数）
  * 输出：schema为（用户id，观看月份，用户当月观看次数，用户历史累计观看次数）
  *
  * 给一张用户每天观看次数明细表，计算当月观看总次数与历史累计观看总次数
  */
object Df02 {
  def main(args: Array[String]): Unit = {
    val spark = new SparkConfig("Df02").getSparkSession
    import org.apache.spark.sql.functions._
    import spark.implicits._

    val frame: DataFrame = Seq(
      ("u01", "2017/1/21", 5),
      ("u02", "2017/1/23", 6),
      ("u03", "2017/1/22", 8),
      ("u04", "2017/1/20", 3),
      ("u01", "2017/1/23", 6),
      ("u01", "2017/2/21", 8),
      ("u02", "2017/1/23", 6),
      ("u01", "2017/2/22", 4)
    ).toDF("userId", "visitDate", "visitCount")

    val w: WindowSpec = Window.partitionBy($"userId").orderBy($"visitMonth").rangeBetween(Window.unboundedPreceding, Window.currentRow)

    frame
      .withColumn("visitMonth", $"visitDate".substr(0, 6))
      .groupBy($"userId", $"visitMonth").agg(sum($"visitCount").alias("visitCountMonth"))
      .select($"userId", $"visitMonth", $"visitCountMonth", sum($"visitCountMonth").over(w).alias("visitCountSum"))
      .show()

  }
}
