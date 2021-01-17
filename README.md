# Spark Study
本项目包含了Spark的多种不同类型的Demo，便于快速掌握其开发特点，也适用于面试官和求职者。

## 环境要求
* Scala 2.11
* Java 8
* 2.2.0

## 目录
### 1.RDD
| 编号   |  考点   |  题目描述   |
| ---- | ---- | ---- |
|   [WordCount](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/rdd/WordCount.scala)   |   flatMap / map / reduceByKey / sortBy   |   给一个RDD[String]，进行分词，word count 并倒序排序   |

### 2.DataFrame
| 编号   |  考点   |  题目描述   |
| ---- | ---- | ---- |
|   [Df01](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/dataframe/Df01.scala)   |   Window / groupBy / agg   |   给一张学生成绩明细表，找出所有科目成绩都大于某一学科平均乘积的学生   |
|   [Df02](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/dataframe/Df02.scala)   |   Window / groupBy / agg   |   给一张用户每天观看次数明细表，计算当月观看总次数与历史累计观看总次数   |
|   [Df03](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/dataframe/Df03.scala)   |   Window / groupBy / agg   |   给一张用户点击店铺的明细，输出点击每个店铺最多的top3用户，并给出该用户点击该店铺次数以及店铺内的排名   |
|   [Df04](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/dataframe/Df04.scala)   |   join   |   给一张用户A关注用户B的表，输出相互关注的用户对   |
|   [Df05](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/dataframe/Df05.scala)   |   union / join / except   |   给一张好友表，输出二度好友表   |
|   [Df06](https://github.com/jason-wang1/sparkstudy/blob/master/src/main/scala/dataframe/Df06.scala)   |   groupBy / agg / countDistinct   |   给一张用户点击商品明细表，输出uv大于1的top3的商品   |

* GraphX
* Ml
