class Generator(buffer: CircularBuffer[Double]) {
  private val rand = new java.util.Random()
  private def getNext() = rand.nextDouble()

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
