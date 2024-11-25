import org.scalatest.funsuite.AnyFunSuite

class HashingTest extends AnyFunSuite {
  test("not commutative") {
    assert(Hashing.combine(1, 2) !== Hashing.combine(2, 1))
  }
  test("identity/deterministic") {
    assert(Hashing.combine(1, 2) === Hashing.combine(1, 2))
  }
  test("not associative") {
    assert(Hashing.combine(Hashing.combine(1, 2), 3) !== Hashing.combine(1, Hashing.combine(2, 3)))
  }
}
