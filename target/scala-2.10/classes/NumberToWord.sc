import scala.collection.JavaConverters._



val diag3 =
  List(
    List( "zero",  "one", " two", " three", " four", " five", " six", " seven", " eight", " nine"," ten",
          " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"),
    List(" ten", "twenty", " thirty", " forty", " fifty",  " sixty",  " seventy", " eighty", " ninety"),
    List(0, 0, 1)
  )

println(diag3.head.apply(0).toString)



def convert(list: List[Char]) : String = {

  def loop(currCount: Int, size: Int, acc: String, remList: List[Char]): String = {
    println(remList.head.asDigit)
    println(diag3.head.apply(remList.mkString.toInt))
    if (size == 1) acc + diag3.head.apply(remList.head.asDigit)
    else if (size == 2 && remList.head.asDigit == 1) acc + diag3.head.apply(remList.mkString.toInt)
    //    else if(remList.isEmpty || currCount == size) acc
    //    else  if(remList.head == '0') {
    //        if (size == 1) acc + oneDigit.head
    //        else loop(currCount + 1, size, acc, remList.tail)
    //      }
    //      else {
    //
    //         var x = remList.head
    //         loop(currCount + 1, size, acc + )
    //      }
    ""
  }
  loop(0, list.length, "", list)
}
println(convert(List('1', '2')))






