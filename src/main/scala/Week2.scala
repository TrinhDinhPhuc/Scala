import scala.math._
import scala.util.Try
//TODO: CREATE A CASE CLASS
case class StockPrice_Class(
                       quarter: Int,
                       stock: String,
                       date: String,
                       open: Double,
                       high: Double,
                       low: Double,
                       close: Double,
                       volume: Long,
                       percent_change_price: Double,
                       percent_change_volume_over_last_wk: Double,
                       previous_weeks_volume: Long,
                       next_weeks_open: Double,
                       next_weeks_close: Double,
                       percent_change_next_weeks_price: Double,
                       days_to_next_dividend: Double,
                       percent_return_next_dividend: Double) {
}
//TODO: CREATE AN OBJECT
object StockPrice_Obj {
  def apply(fields: Array[String]):StockPrice_Class = {
    if (fields.length != 16)
      throw new RuntimeException("Wrong number of fields to construct StockPrice object")
    new StockPrice_Class(
      Try(fields(0).toInt).getOrElse(0),
      fields(1),
      fields(2),
      convertPriceToValue(fields(3)),
      convertPriceToValue(fields(4)),
      convertPriceToValue(fields(5)),
      convertPriceToValue(fields(6)),
      Try(fields(7).toLong).getOrElse(0L),
      Try(fields(8).toDouble).getOrElse(0.0),
      Try(fields(9).toDouble).getOrElse(0.0),
      Try(fields(10).toLong).getOrElse(0L),
      convertPriceToValue(fields(11)),
      convertPriceToValue(fields(12)),
      Try(fields(13).toDouble).getOrElse(0),
      Try(fields(14).toDouble).getOrElse(0),
      Try(fields(15).toDouble).getOrElse(0),
    )
  }
  def convertPriceToValue(priceString: String): Double ={
    val regexPrice1 = "\\$[.\\d]+".r
    val regexPrice2 = "[.\\d+]".r
    priceString match {
      case regexPrice1() => priceString.tail.toDouble
      case regexPrice2() => priceString.toDouble
      case _ => throw new NumberFormatException(priceString + ": price is not in correct format")
    }
  }
}

object Week2 {
  def main(args: Array[String]): Unit = {
    val data = scala.io.Source.fromFile("C:\\Users\\PhucCoi\\Documents\\SCALA\\src\\main\\scala\\dow_jones_index.data").getLines.toArray.tail

    //TODO: Split comma
    val split_comma = data
      .map(_.split(","))
      .map(field11 =>StockPrice_Obj(field11)) //TODO: Chỗ này nó gọi thằng object

    //TODO: take CAT and find max, min
    val max_CAT = split_comma
      .filter(get_attribute => get_attribute.stock == "CAT")
      .map(_.volume)
      .max

    val min_CAT = split_comma
      .filter(get_attribute => get_attribute.stock == "CAT")
      .map(_.volume)
      .min
    println("Max CAT: "+ max_CAT)
    println("Min CAT: "+ min_CAT)

    //TODO: Calculate average of volumes of stock CAT
    val agg = split_comma
      .filter(get_attribute => get_attribute.stock == "CAT")
      .map(get_attribute => (get_attribute.volume,1))
      .foldLeft((0L, 1))( (agg, e) => (agg._1 + e._1, agg._2 + e._2))
    val average = agg._1 / agg._2
    println("Average CAT: "+ average)

    //6. Using groupBy to group stocks by name, calculate highest and lowest price of each stock.
    val maxMin_byGroup = split_comma
      .groupBy(_.stock) //TODO: Group by stock
      .mapValues( dataofStock => {val prices = dataofStock.map(_.open)
      (prices.max,prices.min)})
    //7. Find the stock with maximum, minimum gap between highest and lowest price.
    val maxGap = maxMin_byGroup
        .maxBy(x => x._2._1 - x._2._2)
    //    println(maxMin_byGroup)
    //    println(maxGap)
    //8. Find the date that the gap between open and close price is maximum for each stock.

    //    stocks
    //      .map(stock => (stock.stock, stock.date, abs(stock.open - stock.close)))
    //      .groupBy(_._1)
    //      .mapValues(gaps => gaps.maxBy(_._3))
    //      .values
    //    println(maxGap)
    //    println(maxMin)
  }
}
