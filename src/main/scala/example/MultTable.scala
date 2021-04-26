package example

object MultTable {

  def makeRowSeq(row: Int): Seq[String] =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding =   " " * (4 - prod.length)
      padding + prod
    }

  def makeRow(row: Int): String =
    makeRowSeq(row).mkString

  def multiTable(row: Int): String = {
    val tableSeq = {
      for (r <- 1 to row)
        yield makeRow(r)
    }
    tableSeq.mkString("\n")
  }

  def main(args: Array[String]): Unit = {
    matchRunner(args)
    println(multiTable(20))
  }

  def matchRunner(args: Array[String]) :Unit = {
    val firstArg = if (args.nonEmpty) args(0) else ""

    firstArg match {
      case "chicken" => println("rice")
      case "fish" => println("chips")
      case _ => println("huh?")
    }
  }
}
