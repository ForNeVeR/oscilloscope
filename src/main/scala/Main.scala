object Main {
  def main(args : Array[String]) {
    val buffer = new CircularBuffer[Double](1000)
    //val generator = new RandomGenerator(buffer)
    val generator = new ComGenerator(buffer, "COM3", 38400)
    val window = new Window(buffer)

    generator.start()

    window.show()
    window.loop()
	
	generator.destroy()
  }
}
