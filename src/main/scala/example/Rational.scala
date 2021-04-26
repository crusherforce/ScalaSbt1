package example

class Rational(n: Int, d: Int) {
  require(d != 0)

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  private val g = gcd(n, d)

  def this(n: Int) = this(n, 1)

  override def toString: String = getN + "/" + getD

  def getN: Int = n/g

  def getD: Int = d/g

  def +(rat: Rational): Rational =
    new Rational(this.getN * rat.getD + this.getD * rat.getN, this.getD * rat.getD)
}

object Rational {
  def isNull(a: Rational): Boolean =
    a == null

  def isEitherNull(a: Rational, b: Rational): Boolean =
    isNull(a) || isNull(b)

  def lessThan(a: Rational, b: Rational): Boolean =
    if (isEitherNull(a, b))
      false
    else
      a.getN * b.getD < a.getD * b.getN

  def greaterThan(a: Rational, b: Rational): Boolean =
    if (isEitherNull(a, b))
      false
    else
      a.getN * b.getD > a.getD * b.getN

  def equals(a: Rational, b: Rational): Boolean =
    if (isEitherNull(a, b))
      false
    else
      a.getN * b.getD == a.getN * b.getD
}