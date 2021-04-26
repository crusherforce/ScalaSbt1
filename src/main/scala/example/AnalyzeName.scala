package example

import scala.io.StdIn.readLine

object AnalyzeName {
  def main(args: Array[String]): Unit = {
    printf("Enter your name : ")
    val name = readLine()
    println(
      name
        .map(x => (x.toLower, 1))
        .groupBy(_._1)
        .map(x => (x._1, x._2.size))
        .toSeq
        .map(x => (x._2, x._1))
        .groupBy(_._1)
        .toSeq
        .sortWith((x, y) => x._1 >= y._1)
        .map(x => (x._1, x._2.map(x => x._2).sortWith((x, y) => x <= y)))
        .mkString(","))
  }
}
