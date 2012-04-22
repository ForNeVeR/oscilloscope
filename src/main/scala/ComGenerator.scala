import gnu.io.NRSerialPort
import java.io.{InputStreamReader, BufferedReader}

class ComGenerator(buffer: CircularBuffer[Double], portName: String) extends Generator {
  private val port = new NRSerialPort("COM1", 115200)
  port.connect()
  private val stream = port.getInputStream
  private val reader = new BufferedReader(new InputStreamReader(stream))

  def loop() {
    try {
      val line = reader.readLine()
      val value = line.toDouble
      buffer.write(value)
    } catch {
      case e: Exception => Console.err.print(e)
    }
  }
}
