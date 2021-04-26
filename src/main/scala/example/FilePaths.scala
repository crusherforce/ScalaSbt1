package example

import java.io.File

object FilePaths extends App {
  // val path = "c:/users/meroycha/Documents/Learning"
  val path = ".\\src\\main\\scala\\example"
  val files = new File(path).listFiles()

  for (i <- 0 until files.length)
    printf("%d. size = %.2f KB lines = %3d, name = %s\n",
      i + 1,
      files.apply(i).length() / 1024.0,
      fileLines(files.apply(i)).length,
      files.apply(i))

  val forLines =
    for {
      file <- files
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield (file,trimmed)

  forLines.foreach(println)

  def fileLines(file: java.io.File) = {
    val f = scala.io.Source.fromFile(file)
    val lines = f.getLines.toList
    f.close()
    lines
  }
}
