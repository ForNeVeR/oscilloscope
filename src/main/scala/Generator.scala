import java.util.Random

class Generator(buffer: CircularBuffer[Double]) {
  private val rand = new Random
  private def getNext() = rand.nextInt().toDouble / Int.MaxValue

  def start() {
    val thread = new Thread(new Runnable {
      def run() {
        while (true) {
          buffer.write(getNext())
        }
      }
    })
    thread.setDaemon(true)
    thread.start()
  }
}
