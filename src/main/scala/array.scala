/*object hellosbt duoc ke thua tu App*/
import scala.collection.mutable.ArrayBuffer

object array  extends  App {
  //mutable Array
  var fruits = ArrayBuffer[String]()
  fruits += "Apple"
  fruits += "Banana"
  fruits += "Orange"
println(fruits)
//  //array
//  val fruits = new Array[String](3)
//
//  fruits(0) = "Apple"
//  fruits(1) = "Banana"
//  fruits(2) = "Orange"

  val args2 = Array("sd","sad")
  val string = args2.mkString(" ")
  println(args2,string)
}

