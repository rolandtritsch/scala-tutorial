package org.tritsch.scala.tutorial

object MultTable {
  final def multTable = {
    val row = (1 to 10).toList
    for(i <- 1 to 10) yield {
      row.map(_ * i).map(_.toString).mkString(" ")
    }
  } 

  def main(args: Array[String]): Unit = {    
    println(multTable.mkString("\n"))
  }
}
