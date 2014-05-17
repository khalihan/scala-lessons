import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by kishon on 5/11/14.
 */
@RunWith(classOf[JUnitRunner])
class exercise$Test extends FunSuite {
  test {
    "one plus one is two"
  }(assert(1 + 1 == 2))
}
