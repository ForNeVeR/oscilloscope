import org.lwjgl.opengl._

class Window(buffer: CircularBuffer[Double]) {
  private val windowWidth = 800
  private val windowHeight = 600

  private val fps = 60

  private val displayMode = new DisplayMode(windowWidth, windowHeight)

  def show() {
    Display.setDisplayMode(displayMode)
    Display.create()
    GL11.glClearColor(0, 0, 0, 0)
    GL11.glViewport(0, 0, windowWidth, windowHeight)

  }

  def loop() {
    def clearDisplay() {
      // TODO: clear display.
    }

    def render() {
      // TODO: render.
    }

    while (!Display.isCloseRequested) {
      Display.sync(fps)
      clearDisplay()
      render()
      Display.update()
    }

    Display.destroy()
  }
}
