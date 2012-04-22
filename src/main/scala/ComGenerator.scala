import gnu.io.NRSerialPort
import java.io.{InputStreamReader, BufferedReader}

class ComGenerator(buffer: CircularBuffer[Double], portName: String, baudRate: Int) extends Generator {
  private val port = new NRSerialPort(portName, baudRate)
  port.connect()
  private val stream = port.getInputStream
  private val reader = new BufferedReader(new InputStreamReader(stream))

  //private val data = new Array[Byte](4)
  //private var pos = 0
  
  def loop() {
    try {
	  //var byte = stream.read()
	  //while (byte != -1) {
	  //  if (byte != 10) {
		//  data.update(pos, byte.toByte)
		//  pos += 1
		//} else {
		//  val value = new String(data).toDouble
		//  buffer.write(value)
		//  pos = 0
		//}
		//
		//byte = stream.read()
	  //}
	  
      val line = reader.readLine()
      val value = line.toDouble
      buffer.write(value)
    } catch {
      case e: Exception => Console.err.print(e)
    }
  }
  
  override def destroy() {
    super.destroy()
	reader.close()
	port.disconnect()
  }
}
