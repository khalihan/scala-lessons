/**
 * Created by kishon on 5/15/14.
 */
object  ImprovedConverter extends App {
  val diag3 =
    List(
      List("", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
        " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"),
      List("", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"),
      List("", " thousand", " million"," billion", " trillion",
        " quadrillion", " quintillion", " sextillion",
        " septillion", " octillion", " nonillion", " decillion",
        " udecillion", " duodecillion", " tredecillion",
        " quattuordecillion", " quindecillion", " sexdecillion",
        " septendecillion", " octodecillion", " novemdecillion",
        " vigintillion")
    )
  println(diag3.head.apply(0).toString)


  def convert(list: List[Char]): String = {

   def computeTuple(count: Int, tup: List[Char]): String = {
      if(tup.isEmpty || tup.forall(ch => ch == '0')) ""
      else {
        val UNIT = 0; val TENS = 1; val THOUSANDS = 2
        var unitd = tup.head.asDigit
        var tend = 0
        if (tup.size > 1) {
          tend = tup.tail.head.asDigit
          if (tend == 1) {
            unitd = 10 + unitd
            tend = 0
          }

        }
        val units = diag3.apply(UNIT).apply(unitd) + diag3.apply(THOUSANDS).apply(count)
        val tens = if (tup.size > 1 && tend > 0) diag3.apply(TENS).apply(tend) else ""
        val hundreds = if (tup.size > 2 && tup.tail.tail.head != '0') diag3.apply(UNIT).apply(tup.tail.tail.head.asDigit) + " hundred" else ""
        hundreds.toString + tens + units
      }
    }

    def loop(currCount: Int, size: Int, acc: String, remList: List[List[Char]]): String = {

      if (remList.size == 0) acc
      else
      loop(currCount + 1, size, computeTuple(currCount, remList.head) + acc, remList.tail)

    }
    if(list.forall(ch => ch == '0')) "zero"
    else
    loop(0, list.length, "", list.reverse.grouped(3).toList)
  }
  println(convert("00000000".toList))
  println(convert("121514014".toList))
  println(convert("14".toList))
  println(convert("24".toList))
  println(convert("90".toList))
  println(convert("100".toList))
  println(convert("1001".toList))
  println(convert("23400700323".toList))
  println(convert("00000505050505050".toList))
  println(convert("1001".toList))

  println(convert("1000500000000006777".toList))
  println(convert("000000004006777".toList))
  println(convert("100000000500000000006777".toList))
}