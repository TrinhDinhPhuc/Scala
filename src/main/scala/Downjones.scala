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
    for (i <- List.range(0,2,1)){
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

    var _array = new Array[String](0)
    val lines = fromFile(file_name).getLines().toArray
    for (line <- lines) _array :+= line
    println(_array.length)
    for (i <- List.range(1,4,1)){
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
}

object Downjones {
  def main(args: Array[String]) {
    val dj = new Downjones("C:\\Users\\PhucCoi\\Documents\\Data Science course 3 Big Data\\Slides + Assignments\\Week 2\\dow_jones_index\\dow_jones_index.data")
    //TODO: Show data
    //dj.showData()
    //TODO: Convert into Array of String
    dj.convert_toArray()
    //TODO: Case Class
    //dj.case_class()
  }
}