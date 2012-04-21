class CircularBuffer[T: Manifest](val size: Int) {
  private val buffer = new Array[T](size)

  var position = 0

  def write(value: T) {
    buffer.update(position, value)
    position = (position + 1) % size
  }

  def bufferCopy = buffer.clone()
}
