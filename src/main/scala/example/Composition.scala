package example

object Composition {
  def main(arguments: Array[String]): Unit = {
    new ArrayElement("Meghaditya Roy Chaudhury".split(' ')).display
  }
}

class ArrayElement (arrayContents: Array[String]) extends Element {
  override def contents: Array[String] = arrayContents
}

abstract class Element {
  def contents : Array[String]
  def height : Int = if (contents == null) 0 else contents.length
  def width : Int = {
    var w = 0
    if (height != 0) contents.foreach(x => w = x.length max w)
    w
  }
  def display: Unit = contents.foreach(printf(s"%${width}s\n", _))
}
