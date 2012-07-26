package org.tritsch.scala.tutorial

object HelloRational extends App {
  assert(args.length == 4, "4 Parameters expected - Usage: HelloRational 1 2 3 4")
  val r1 = new Rational(args(0).toInt, args(1).toInt)
  val r2 = new Rational(args(2).toInt, args(3).toInt)

  val sum = r1 + r2
  val diff = r1 - r2
  val mul = r1 * r2
  val quot = r1 / r2

  println(r1 + " + " + r2 + " = " + sum)
  println(r1 + " - " + r2 + " = " + diff)
  println(r1 + " * " + r2 + " = " + mul)
  println(r1 + " / " + r2 + " = " + quot)  
}
