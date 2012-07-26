package org.tritsch.scala.tutorial

import scala.io.Source

object CharCount {
  def widthOfLength(s: String) = s.length.toString.length

  def main(args: Array[String]): Unit = {
    assert(!args(0).isEmpty)
    val fileName = args(0)
    val lines = Source.fromFile(fileName).getLines().toList
    val longestLine = lines.reduceLeft(
      (longestLineSoFar, nextLine) => if (longestLineSoFar.length > nextLine.length) longestLineSoFar else nextLine)
    val maxWidth = widthOfLength(longestLine)
    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length + " | " + line)
    }
  }
}
