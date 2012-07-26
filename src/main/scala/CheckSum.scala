package org.tritsch.scala.tutorial

object CheckSum {
  private var sum = 0
  def add(b: Byte) {sum += b}
  def checksum(): Int = ~(sum & 0xFF) + 1

  def main(args: Array[String]): Unit = {
    assert(!args.isEmpty)
    for(i <- 0 until args.length) add(args(i).toByte)
    println("CheckSum for (" + args.mkString(",") + ") is " + checksum + " ...")
  }
}
