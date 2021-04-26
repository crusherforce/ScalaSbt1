package example

object ControlAbstraction {
  def main(args: Array[String]): Unit = {
    def sum(x:Int)(y:Int) = x+y
    val addOne = sum(1) _
    println(addOne(5))
  }
}
