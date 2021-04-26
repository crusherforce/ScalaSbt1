package example

import scala.annotation.tailrec

object Func {

  def main(args: Array[String]): Unit = {
    //primeRunner()

    //fizzbuzzRunner()

    //partialFunctionRunner()

    //closureRunner()

    guessSqRootRunner()
  }

  def guessSqRootRunner(): Unit = {
    val sq = 3.14
    printf("The square root of %.2f is %.2f", sq, approx(2))

    @tailrec
    def approx(n: Double) : Double = {
      if (close(n)) n
      else approx(improve(n))
    }

    def close(n: Double) : Boolean = {
      math.abs(sq - n*n) < 0.001
    }

    def improve(n: Double): Double = {
      (n + sq/n)/2
    }
  }


  def primeRunner(): Unit = {
    println(
      doTillUpperBound(
        30,
        (x: Int) => if (isPrime(x)) "prime" else "not prime"
      )
        .filter(_._2 == "prime")
        .mkString("\n")
    )
    def isPrime(n: Int): Boolean = {
      !(2 to n / 2).exists(n % _ == 0)
    }
  }

  def fizzbuzzRunner(): Unit = {
    println(
      doTillUpperBound(
        upper = 30,
        fizzbuzz
      )
        .filter(_._2 == "fizzbuzz")
        .mkString("\n")
    )
    def fizzbuzz(n: Int): String = {
      if (n % 15 == 0) "fizzbuzz"
      else if (n % 3 == 0) "fizz"
      else if (n % 5 == 0) "buzz"
      else ""
    }
  }

  def closureRunner(): Unit = {
    var sum = 0
    def listSum(l : List[Int]): Unit = l.foreach(sum += _)
    listSum(List(4,6,7))
    println(sum)
  }

  def partialFunctionRunner(): Unit = {
    def makeArray(a:Int, b:Int, c:Int) = Array.apply(a,b,c)
    val makePartArray1 = makeArray(1,1,_)
    val makePartArray2 = makeArray(1,_,1)

    println(makePartArray1(2).mkString(","))
    println(makePartArray2(2).mkString(","))
  }

  def doTillUpperBound(upper: Int, f: Int => String): IndexedSeq[(Int, String)] = {
    for (x <- 2 to upper) yield (x, f(x))
  }

}
