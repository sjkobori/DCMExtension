import org.scalatest.funsuite.AnyFunSuite

class DCMTest extends AnyFunSuite {
  test("Empty Matrix") {
    //Arrange
    val matrix = Seq(Seq())
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("1 element") {
    //Arrange
    val matrix = Seq(Seq(1))
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("1 row") {
    //Arrange
    val matrix = Seq(Seq(1, 3, 12, 1, 1))
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("1 col") {
    //Arrange
    val matrix = Seq(
      Seq(1),
      Seq(11),
      Seq(4),
      Seq(3),
      Seq(2),
      Seq(1)
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("valid square matrix") {
    //Arrange
    val matrix = Seq(
      Seq(0, 3, 12, 1, 5),
      Seq(1, 0, 3, 12, 1),
      Seq(4, 1, 0, 3, 12),
      Seq(5, 4, 1, 0, 3),
      Seq(1, 5, 4, 1, 0),
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("invalid square matrix") {
    //Arrange
    val matrix = Seq(
      Seq(0, 3, 12, 1, 5),
      Seq(1, 0, 3, 12, 1),
      Seq(4, 2, 0, 3, 12),
      Seq(5, 4, 1, 0, 3),
      Seq(1, 5, 4, 1, 0),
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(!isProper)
  }
  test("valid wide matrix") {
    //Arrange
    val matrix = Seq(
      Seq(0, 3, 12, 1, 5, 6, 5, 1, 2),
      Seq(1, 0, 3, 12, 1, 5, 6, 5, 1),
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("invalid wide matrix") {
    //Arrange
    val matrix = Seq(
      Seq(0, 3, 12, 1, 1, 6, 5, 1, 2),
      Seq(1, 0, 3, 12, 1, 5, 6, 5, 1),
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(!isProper)
  }
  test("valid tall matrix") {
    //Arrange
    val matrix = Seq(
      Seq(0, 3),
      Seq(2, 0),
      Seq(4, 2),
      Seq(5, 4),
      Seq(1, 5),
      Seq(2, 1),
      Seq(4, 2),
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(isProper)
  }
  test("invalid tall matrix") {
    //Arrange
    val matrix = Seq(
      Seq(0, 3),
      Seq(2, 0),
      Seq(4, 2),
      Seq(5, 4),
      Seq(1, 5),
      Seq(1, 1),
      Seq(4, 2),
    )
    //Act
    val isProper = DCM.isProperDCM(matrix.map(r => DCM.generateRowHashes(r)))
    //Assert
    assert(!isProper)
  }
}
