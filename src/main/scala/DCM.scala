import scala.annotation.tailrec

object DCM {
  def isProperDCM(rowHashPairs: Seq[(Int, Int)]): Boolean = {
    if rowHashPairs.isEmpty then true
    else isProperDCMHelper(rowHashPairs.tail, rowHashPairs.head(0))
  }

  @tailrec
  private def isProperDCMHelper(rowHashPairs: Seq[(Int, Int)], previousHash: Int): Boolean = {
    if rowHashPairs.isEmpty then true
    else if rowHashPairs.head(1) != previousHash then false
    else isProperDCMHelper(rowHashPairs.tail, rowHashPairs.head(0))
  }

  /**
   * Hashes the row one index at a time from element ranges:
   * current -> [0, row.length-2]
   * previous -> [1, row.length-1]
   * ex: row = Seq(0, 1, 2, 3, 4) 
   * current -> hashed(0,1,2,3) 
   * previous -> hashed(1,2,3,4)
   */
  def generateRowHashes(row: Seq[Int]): (Int, Int) = {
    // (index, currentHash, previousHash)
    val (_, current, previous) = row.foldLeft((0, 0, 0))((a, b) => {
      if row.length == 1 then (a(0) + 1,0,0) // handles when there is only one column
      else if a(0) == 0 then { //when it is the first element don't begin hashing for the previous row,
        (a(0) + 1, Hashing.combine(a(1), b), a(2))
      }
      else if a(0) == row.length - 1 then { //when it is the last element, do not keep hashing for the current row
        (a(0) + 1, a(1), Hashing.combine(a(2), b))
      }
      else { //hash for both current and previous rows
        (a(0) + 1, Hashing.combine(a(1), b), Hashing.combine(a(2), b))
      }
    })
    (current, previous)
  }
}
