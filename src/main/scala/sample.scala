//case class StockPrice(stock : String,
//                      open : Double
//                     )
//
//val stockPrices: Seq[StockPrice] = Seq(StockPrice("IBM", 12.2),StockPrice("GOOGLE", 2.2),StockPrice("IBM", 13.2))
//
//val filtered = stockPrices
//  .filter(_.stock == "IBM") // filter for IBM
//  .map(_.open) // map to the price
//
//val average = filtered.sum / filtered.length
//val min = filtered.min
//val max = filtered.max
//
//println(s"average: $average")
//println(s"min: $min")
//println(s"max: $max")