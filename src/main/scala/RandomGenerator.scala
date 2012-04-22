import java.util.Random

class RandomGenerator(buffer: CircularBuffer[Double]) extends Generator {
  private val rand = new Random
  private def getNext() = rand.nextInt().toDouble / Int.MaxValue

  def loop() {
    buffer.write(getNext())
  }
}
