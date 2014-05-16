object rationals {
  println("welcome to the Scala worksheet")

}
class Rational(x: Int, y: Int){
  def numer = x
 // def
}

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a+1, acc + f(a))
  }
  loop(a, 0)
}

println(sum(x => x * x)(3, 5))

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
  if( a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
}
def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x *y, 1)(a, b)
//def product(f: Int => Int)(a: Int, b: Int): Int = {
//  if(a > b) 1
//  else f(a) * product(f)(a+1, b)
//}
product(x => x * x)(3, 4)
product(x => x)(1, 4)