/*object hellosbt duoc ke thua tu App*/
object hellosbt  extends  App {
  val x = List.range(1,10)
  val evens = x.filter(_ % 2 ==0)
  val odds = x.filter(_ % 2 != 0)
  x.foreach(println)
  println("Evens are:" + evens)
  println("Odds are :" + odds)

}
