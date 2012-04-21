import org.lwjgl.opengl.Display
import org.lwjgl.opengl.DisplayMode
import org.lwjgl.opengl.GL11._

class Window(buffer: CircularBuffer[Double]) {
  private val windowWidth = 800
  private val windowHeight = 600

  private val fps = 60

  private val displayMode = new DisplayMode(windowWidth, windowHeight)

  def show() {
    Display.setDisplayMode(displayMode)
    Display.create()
    glClearColor(0, 0, 0, 0)
    glViewport(0, 0, windowWidth, windowHeight)

  }

  def loop() {
    def clearDisplay() {
      glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    }

    def render(position: Int, data: Array[Double]) {
      val min = data.min
      val max = data.max

      def scaleX(x: Double) = 2 * x / data.size - 1.0
      def scaleY(y: Double) = 2 * (y - min) / (max - min) - 1.0

      def renderData() {
        glBegin(GL_LINES)
        for (index <- 0 until data.length) {
          val x = scaleX(index)
          val y = scaleY(data(index))

          glVertex2d(x, y)
        }
        glEnd()
      }

      def renderScanner() {
        glBegin(GL_LINES)
        val x = scaleX(position)
        glVertex2d(x, -1)
        glVertex2d(x, 1)
        glEnd()
      }

      glColor3b(127, 0, 0)
      renderData()

      glColor3b(0, 127, 0)
      renderScanner()
    }

    while (!Display.isCloseRequested) {
      Display.sync(fps)
      clearDisplay()
      val position = buffer.position
      val data = buffer.bufferCopy
      render(position, data)
      Display.update()
    }

    Display.destroy()
  }
}
