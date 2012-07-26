package org.tritsch.scala.tutorial

object Fib {
  def fib(n: Int): Int = {
    if(n == 0) 0
    else if(n == 1) 1
    else fib(n-1) + fib(n-2)
  }

  def main(args: Array[String]): Unit = {
    assert(args(0).toInt >= 0) 
    println((0 to args(0).toInt).map(fib).mkString(","))
  }
}
