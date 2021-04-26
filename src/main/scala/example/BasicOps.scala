package example

import scala.language.postfixOps

object BasicOps extends App{
    args.foreach(println)

    println(
      Array.apply(1, 2, 3)
        .map(x => (10 * x, math.round(100 * math.random())))
        .sortWith((x, y) => (x._1 + x._2) <= (y._1 + y._2))
        .mkString(","))


    val l1 = List(1, 2)
    val l2 = List(3, 's')
    val l3 = l1 ::: l2

    println(l3.forall(_.isValidInt))
    l3.reverse.foreach(greetStrings)

    val total = System.currentTimeMillis() - executionStart
    Console.println("[total " + total + "ms]")

    val a = 1.0 / 0
    println(a isInfinity)

    def greetStrings(x: Any): Unit = println(x)
}
