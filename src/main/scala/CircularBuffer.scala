class CircularBuffer[T: Manifest](size: Int) {
  private val buffer = new Array[T](size)

  var position = 0

  def write(value: T) {
    buffer.update(position, value)
    position = (position + 1) % size
  }

  def read(index: Int) = buffer(index)
}
