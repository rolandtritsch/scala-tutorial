object Timer {
  def oncePerSecond(callback: () => Unit): Unit = {
    while(true) {
      callback()
      Thread.sleep(1000)
    }
  }

  def dot(): Unit = {
    print(".")
  }

  def main(args: Array[String]): Unit = {
    oncePerSecond(dot)
  }
}
