package org.tritsch.scala.tutorial

object Timer4 {
  def runEveryNSec(seconds: Int, what: () => Unit): Unit = {
    while(true) {
      what()
      Thread.sleep(seconds * 1000)
    }
  }

  def main(args: Array[String]): Unit = {
    runEveryNSec(1, () => print("."))
  }
}
