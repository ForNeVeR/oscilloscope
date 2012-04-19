import org.lwjgl.opengl._

class Window {
  val windowWidth = 800
  val windowHeight = 600

  val displayMode = new DisplayMode(windowWidth, windowHeight)
  Display.setDisplayMode(displayMode)
  Display.create()
  GL11.glClearColor(0, 0, 0, 0)
  GL11.glViewport(0, 0, windowWidth, windowHeight)
}
