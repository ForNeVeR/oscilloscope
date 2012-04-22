trait Generator {
  def loop()

  def start() {
    val thread = new Thread(new Runnable {
      def run() {
        while (true) {
          loop()
        }
      }
    })

    thread.setDaemon(true)
    thread.start()
  }
}