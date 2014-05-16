/**
 * Created by kishon on 5/15/14.
 */
object  Converter extends App {
  val diag3 =
    List(
      List("", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",
        " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"),
      List("", "ten", "twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"),
      List("", " hundred", " thousand", " million"," billion", " trillion",
        " quadrillion", " quintillion", " sextillion",
        " septillion", " octillion", " nonillion", " decillion",
        " udecillion", " duodecillion", " tredecillion",
        " quattuordecillion", " quindecillion", " sexdecillion",
        " septendecillion", " octodecillion", " novemdecillion",
        " vigintillion")
    )

  println(diag3.head.apply(0).toString)


  def convert(list: List[Char]): String = {

    def compute(count: Int, digit: Int): String = {
      val offset = if(count % 3 == 1) 1 else 0
      val thousandOffset = if( count > 0 && count % 3 == 0) count / 3 + 1 else 0
      val hundredOffset = if( digit > 0) 1 else 0
      if(count % 3 != 2) diag3.apply(offset).apply(digit) + diag3.apply(2).apply(thousandOffset)
      else if(hundredOffset > 0) diag3.head.apply(digit) + diag3.apply(2).apply(1)
      else ""
    }
    def loop(currCount: Int, size: Int, acc: String, remList: List[Char]): String = {

      if (remList.isEmpty || currCount == size) acc
      else if (currCount % 3 == 0) {
        // handle trailing zeros
        if (remList.head == '0') {
          if (size == 1) "zero"
          else
             loop(currCount + 1, size, acc, remList.tail)
        }
        else if (size > currCount + 1 && remList.tail.head == '1') {
          // handle teens
          val digit = 10 + remList.head.asDigit
          val x = compute(currCount, digit)
          loop(currCount + 2, size, x + acc, remList.tail.tail)
        }
        else {
          val x = compute(currCount, remList.head.asDigit)
          loop(currCount + 1, size, x + acc, remList.tail)
        }
      }
      else {
        val x = compute(currCount, remList.head.asDigit)
        loop(currCount + 1, size, x + acc, remList.tail)
      }
    }
    loop(0, list.length, "", list.reverse)
  }

  println(convert("100000".toList))
}