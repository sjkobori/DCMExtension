import scala.util.hashing.MurmurHash3

object Hashing {
  def combine[T](a: T, b: T): Int = {
    MurmurHash3.seqHash(Seq(a,b))
  }
}
