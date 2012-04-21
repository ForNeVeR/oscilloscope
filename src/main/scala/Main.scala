object Main {
  def main(args : Array[String]) {
    val buffer = new CircularBuffer[Double](300)
    val generator = new Generator(buffer)
    val window = new Window(buffer)

    generator.start()

    window.show()
    window.loop()
  }
}
