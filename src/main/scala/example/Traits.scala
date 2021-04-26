package example

import scala.collection.mutable.ArrayBuffer

object Traits {
  def main(args: Array[String]): Unit = {
    //runRectTrait()
    runQueueTrait()
  }

  def runRectTrait(): Unit = {
    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    println(rect.area)
    println(rect.perimeter)
  }

  def runQueueTrait(): Unit = {
    var a = new BasicIntQueue with Incrementing with Filtering
    a.put(-1); a.put(0); a.put(1); println(a.size())
    a = new BasicIntQueue with Filtering with Incrementing
    a.put(-1); a.put(0); a.put(1); println(a.size())
  }

  class Point(x: Int, y: Int) extends Ordered[Point] {

    def getX: Int = x

    def getY: Int = y

    override def compare(that: Point): Int =
      if (that.getY == this.getY && that.getX == this.getX) 0
      else if (that.getY > this.getY && that.getX > this.getX || that.getY < this.getY && that.getX > this.getX) 1
      else 0

    override def toString: String = "(" + x + "," + y + ")"
  }

  abstract class Component extends Rectangular

  trait Rectangular {

    def topLeft: Point

    def bottomRight: Point

    def left: Int = topLeft.getX

    def right: Int = bottomRight.getX

    def top: Int = topLeft.getY

    def bottom: Int = bottomRight.getY

    def width: Int = right - left
  }

  class Rectangle(tl: Point, br: Point) extends Rectangular {

    def height: Int = math.abs(tl.getY - br.getY)

    def area: Int = width * height

    def perimeter: Int = 2 * (width + height)

    override def toString: String = "{" + tl.toString + "," + br.toString + "}"

    override def topLeft: Point = tl

    override def bottomRight: Point = br
  }

  abstract class IntQueue {
    def get(): Int
    def put(x: Int)
  }

  trait Doubling extends IntQueue {
    abstract override def put(x: Int) {super.put(2*x)}
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int) {super.put(x+1)}
  }

  trait Filtering extends IntQueue {
    abstract override def put(x: Int): Unit = {
      if (x>=0) super.put(x)
    }
  }

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def size(): Int = buf.size
    def get(): Int = buf.remove(0)
    override def put(x: Int): Unit = buf += x
  }
}
