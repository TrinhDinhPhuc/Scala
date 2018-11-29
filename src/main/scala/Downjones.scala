import scala.io.Source._
import scala.io._

class Downjones(val file: String) {
  var file_name: String = file

  //TODO: Create function to show data
  def showData() {
    val lines = Source.fromFile(file_name)
    for (line <- lines.getLines) {
      println(line.toUpperCase)
    }
    //TODO:Close the file
    lines.close
    for ( line <- fromFile(file_name).getLines()){
      //TODO: println(line.getClass().getSimpleName())
      println(line)
    }
  }

  //TODO: Create mutable Scala String arrays
  def convert_toArray(): Unit ={
    var _array = new Array[String](0)
    val lines = fromFile(file_name).getLines().toArray
    for (line <- lines) _array :+= line
    println(_array.length)
    for (i <- List.range(0,5,1)){
      var _quater = _array(i).split(",")(0)
      var _stock  = _array(i).split(",")(1)
      var _date   = _array(i).split(",")(2)
      var _open   = _array(i).split(",")(3)
      var _high   = _array(i).split(",")(4)
      var _low   = _array(i).split(",")(5)
      var _close   = _array(i).split(",")(6)
      var _volume   = _array(i).split(",")(7)
      var _percent_change_price   = _array(i).split(",")(8)
      var _percent_change_volume_over_last_wk   = _array(i).split(",")(9)
      var _previous_weeks_volume   = _array(i).split(",")(10)
      var _next_weeks_open   = _array(i).split(",")(11)
      var _next_weeks_close   = _array(i).split(",")(12)
      var _percent_change_next_weeks_price   = _array(i).split(",")(13)
      var _days_to_next_dividend   = _array(i).split(",")(14)
      var _percent_return_next_dividend   = _array(i).split(",")(15)
      println(_quater,_stock,_date,_open,_open,_high,_low,_close,_volume,_percent_change_price,_percent_change_volume_over_last_wk,_previous_weeks_volume,_next_weeks_open,_next_weeks_close,_percent_change_next_weeks_price,_days_to_next_dividend,_percent_return_next_dividend)
    }
  }

  //TODO: Create a case class
  def case_class(): Unit ={
    case class StockPrice(quarter : Byte,
                          stock : String,
                          date : String,
                          open : Double,
                          high : Double,
                          low : Double,
                          close : Double,
                          volume : Double,
                          percent_change_price : Double,
                          percent_change_volume_over_last_wk : Double,
                          previous_weeks_volume : Double,
                          next_weeks_open : Double,
                          next_weeks_close : Double,
                          percent_change_next_weeks_price : Double,
                          days_to_next_dividend : Double,
                          percent_return_next_dividend : Double
                         )
    val st = StockPrice(1,"AA","1/14/2011",16.71,16.71,15.64,15.97,242963398,-4.42849,1.380223028,239655616,16.19,15.79,-2.47066,19,0.187852)
    println(st.stock,st.date,st.high,st.low)
  }
  //TODO: Insert into Case Class
  def convert_toCaseClass(): Unit ={
    case class StockPrice(quarter : String,
                          stock : String,
                          date : String,
                          open : String,
                          high : String,
                          low : String,
                          close : String,
                          volume : String,
                          percent_change_price : String,
                          percent_change_volume_over_last_wk : String,
                          previous_weeks_volume : String,
                          next_weeks_open : String,
                          next_weeks_close : String,
                          percent_change_next_weeks_price : String,
                          days_to_next_dividend : String,
                          percent_return_next_dividend : String
                         )
    //TODO: Remove Dollars
    def removeDollars(line: String): String = line.replaceAll("\\$", "")
    val lines = fromFile(file_name).getLines().toArray

    //TODO:
    // split string into tokens and
    // convert into MyCaseClass object
    def parseLine(line: String): StockPrice = {
      val tokens: Seq[String] = line.split(",")
      StockPrice(
        quarter = tokens(0),
        stock = tokens(1),
        date = tokens(2),
        open = tokens(3),
        high = tokens(4),
        low = tokens(5),
        close = tokens(6),
        volume = tokens(7),
        percent_change_price = tokens(8),
        percent_change_volume_over_last_wk = tokens(9),
        previous_weeks_volume = tokens(10),
        next_weeks_open = tokens(11),
        next_weeks_close = tokens(12),
        percent_change_next_weeks_price = tokens(13),
        days_to_next_dividend = tokens(14),
        percent_return_next_dividend = tokens(15)
      )
    }
    val myCaseClassObjects: Seq[StockPrice] = lines.map(removeDollars).map(parseLine)
    println(myCaseClassObjects)

    //TODO: CALCULATE MIN, MAX OF VOLUME
    val st: Seq[StockPrice] = myCaseClassObjects
    println(myCaseClassObjects.getClass().getSimpleName())
    println(st.getClass().getSimpleName())

    val filteredList = st.filter(p => p.stock == "IBM")
    val min = filteredList.map(x=>x.open).min
    val max = filteredList.map(x=>x.open).max
    val sum = filteredList.map(x=>x.open.toDouble).sum
    val average = sum/filteredList.length
    println("Min="+min,"Max="+max,"Average=" + average)

  }
}

object Downjones{
  def main(args: Array[String]): Unit = {
    val dj = new Downjones("C:\\Users\\PhucCoi\\Documents\\Data Science course 3 Big Data\\Slides + Assignments\\Week 2\\dow_jones_index\\dow_jones_index.data")
    //TODO: Convert to case class
    dj.convert_toCaseClass()
    //TODO: Doing calculation Max, Min, Average
  }
}