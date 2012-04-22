trait Generator {
  var stop = false
  
  def loop()

  def start() {
    val thread = new Thread(new Runnable {
      def run() {
        while (!stop) {
          loop()
        }
      }
    })

    thread.setDaemon(true)
    thread.start()
  }
  
  def destroy() {
	stop = true
  }
}