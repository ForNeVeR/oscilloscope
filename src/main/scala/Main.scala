object Main {
  def main(args : Array[String]) {
    println("Some random data:")

    val generator = new Generator()

    for (_ <- 1 to 5) {
      val point = generator.getNext()
      printf("    %f\n", point)
    }
  }
}
