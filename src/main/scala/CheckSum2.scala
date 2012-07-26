package org.tritsch.scala.tutorial

import scala.collection.mutable.Map

class CheckSumCalculator {
  final private var sum = 0
  final private def add(b: Byte): Unit = {sum += b}
  final private def checksum: Int = {~(sum & 0xff) + 1}
}

object CheckSumCalculator {
  final private val cache = Map[String, Int]()

  final def calc(s: String): Int = {
    if(cache.contains(s)) cache(s)
    else {
      val acc = new CheckSumCalculator
      for(c <- s) acc.add(c.toByte)
      cache += (s -> acc.checksum)
      acc.checksum
    }
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length > 0, "At least one parameter required - Usage: CheckSumCalculator <list of strings>")
    for(s <- args) println(s + " -> " + calc(s))
  }
}
