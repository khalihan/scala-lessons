import math.abs
/**
 * Created by kishon on 5/10/14.
 */

object exercise extends  App{
  val tolerance = 0.001
  def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) / x <  tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
  println(fixedPoint(x => 1 + x/2)(1))
}

