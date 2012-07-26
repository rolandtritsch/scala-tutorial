package org.tritsch.scala.tutorial

object HelloXMen {
  def main(args: Array[String]): Unit = {
    args
      .filter((arg:String) => arg.startsWith("X"))
      .foreach((arg:String) => println(arg))
  }
}
