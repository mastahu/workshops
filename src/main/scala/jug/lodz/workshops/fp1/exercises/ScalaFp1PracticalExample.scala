package jug.lodz.workshops.fp1.exercises

/**
  * Created by pawel on 09.02.16.
  */
object ScalaFp1PracticalExample {

  private val products:Map[String,Product]=Map(
    "tv"->Product("tv",BigDecimal("3000")),
    "keyboard"->Product("keyboard",BigDecimal("120")),
    "mouse"->Product("mouse",BigDecimal("70")),
    "headphones"->Product("head phones",BigDecimal("200"))

  )

  private val database:Map[PurchaseId,Purchase] =Map(
      PurchaseId(1) -> Purchase(PurchaseId(1),List(products("tv"),products("headphones"))),
      PurchaseId(1) -> Purchase(PurchaseId(1),List(products("keyboard"),products("headphones"),products("mouse")))
  )

  //lab
  def findPurchase(id:PurchaseId):Option[Purchase] = ???

  //lab
  val domainFunction: Purchase => Seq[BigDecimal] = ???

  def main(args: Array[String]) {
    import MathLib._
    val pureDomainFunction: (Purchase) => BigDecimal =domainFunction andThen genericMathFunction

    findPurchase(new PurchaseId(1)).map(pureDomainFunction).foreach(println)
    val purchase3Price: BigDecimal =findPurchase(new PurchaseId(3)).map(pureDomainFunction)
      .getOrElse(throw new RuntimeException("there is no purchase with id 3"))

    println(s"somehow there is a purchase with id 3 : $purchase3Price")
  }

}

//lab
object MathLib {
  val genericMathFunction:Seq[BigDecimal]=>BigDecimal = ???
}

case class PurchaseId(val id:Int) extends AnyVal

case class Product(name:String,price: BigDecimal)
case class Purchase(id:PurchaseId,purchasedProducts:List[Product])
