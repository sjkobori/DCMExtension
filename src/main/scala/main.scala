@main
def main(): Unit = {
  val row1 = Seq(1, 2, 3, 4, 5)
  val row2 = Seq(0, 1, 2, 3, 4)
  val row3 = Seq(1, 0, 1, 2, 3)
  val row4 = Seq(2, 1, 0, 1, 2)
  val row5 = Seq(3, 2, 1, 0, 1)

  val correctMatrix = Seq(row1, row2, row3, row4, row5)
  val incorrectMatrix = Seq(row1, row2, row4, row4, row5)
  val correctRowHashes = correctMatrix.map(r => DCM.generateRowHashes(r))
  val incorrectRowHashes = incorrectMatrix.map(r => DCM.generateRowHashes(r))

  printMatrix(correctMatrix)
  println(s"Is DCM matrix? ${DCM.isProperDCM(correctRowHashes)}")
  printMatrix(incorrectMatrix)
  println(s"Is DCM matrix? ${DCM.isProperDCM(incorrectRowHashes)}")
}

private def printMatrix(matrix: Seq[Seq[Int]]): Unit = {
  matrix.foreach(row => {
    print("[ ")
    row.foreach(e => {
      print(s"$e ")
    })
    println(']')
  })
}