package jug.lodz.workshops.fp1.answers

/**
  * Created by pawel on 21.02.16.
  */
object ScalaFP1BufferExercisesAnswer {


  val add:(Int,Int) => Int = (a,b)=>a+b
  val addTo5 : Int=>Int = add(5,_:Int)

  val curriedJoinString2 : String=>String=>String = s1=>s2=>s1+s2
  val curriedJoinString3 : String=>String=>String=>String = s1=>s2=>s3=>s1+s2+s3

  val curriedAdd2: Int=>Int=>Int= a=>b=>a+b
  val curriedAdd3: Int=>Int=>Int=>Int= a=>b=>c=>a+b+c
  val curriedAdd4: Int=>Int=>Int=>Int=>Int= a=>b=>c=>d=>a+b+c+d

  def partialApplication(f:(Int,Int)=>Int, firstArg:Int): Int=>Int =
    x=>f(firstArg,x)


  def curry(f:(Int,Int)=>Int):Int=>Int=>Int = a=>b=>f(a,b)

  def uncurry(f: Int=>Int=>Int) : (Int,Int)=>Int = (a,b)=>f(a)(b)


  def main(args: Array[String]) {
    println("----------------------PARTIAL APPLICATION---------------------------------")
    println(s"standard form a=1,b=2 : ${add(1,2)}")
    println(s"partially applied a=5,b=2 : ${addTo5(2)}")

    val addToFive=partialApplication(add,5)
    println(s"add to five b=1 : ${addToFive(1)}")


    println("----------------------CURRYING---------------------------------")
    println(curriedJoinString2("aaa"))
    println(curriedJoinString2("aaa")("bbb"))

    println(curriedJoinString3("aaa"))
    println(curriedJoinString3("aaa")("bbb"))
    println(curriedJoinString3("aaa")("bbb")("ccc"))

    println(curriedAdd2(1)(2))
    println(curriedAdd3(1)(2)(3))
    println(curriedAdd4(1)(2)(3)(4))

    val curried: (Int) => (Int) => Int =curry(add)
    println(s"curried only first paramater a=3 : ${curried(3)}")
    println(s"curried two parameters a=3, b=7 : ${curried(3)(7)}")

    val uncurried: (Int, Int) => Int =uncurry(curried)
    println(s"uncurried - back to the begining : ${uncurried(1,2)==add(1,2)}")

  }

}
