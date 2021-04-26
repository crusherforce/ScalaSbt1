package example

object RationalRunner {
  def main(args: Array[String]): Unit = {
    val c1 = new Rational(1, 2)
    val c2 = new Rational(3, 4)
    println(c1 + " + " + c2 + " = " + (c1 + c2))
    println(Rational.lessThan(c1, c2))
  }
}
