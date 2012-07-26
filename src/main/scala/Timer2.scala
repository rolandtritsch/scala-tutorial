package org.tritsch.scala.tutorial

object Timer2 {
  def oncePerSec(callback: () => Unit): Unit = {
    while(true) {
      callback()
      Thread.sleep(1000)
    }  
  }

  def doSomething(): Unit = {
    Console.print(".")
  }

  def main(args: Array[String]): Unit = {
    oncePerSec(doSomething)
  }
}
