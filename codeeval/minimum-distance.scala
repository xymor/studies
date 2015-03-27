//Codeeval gives me a 10/100, says my code is slow but it's so shiny

object Main extends App{
  //val args = Array("4","3","3","5","7")
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
   source.getLines
        .filter(_.length > 0)
        .map(_.split(" ").map(_.toInt))
        .map(x => fold(x.head, x.tail))
        .foreach(println)   
  
    private def fold(pivot: Int, list: Array[Int]): Int = {
        list.map(x => if(pivot > x) pivot - x else x - pivot).sum
    } 
}
