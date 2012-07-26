package org.tritsch.scala.tutorial

object Timer1 {
  def oncePerSec(): Unit = {
    while(true) {
      print(".")
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]): Unit =  { 
    oncePerSec()
  }
}
