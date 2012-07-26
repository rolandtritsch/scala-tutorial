package org.tritsch.scala.tutorial

class Rational(n: Int, d: Int) {
  assert(d != 0, "denominator needs to be != 0")
  println("Created " + n + "/" + d)

  private val g = gcd(n.abs, d.abs)

  private val numer = n / g
  private val denom = d / g

  println("Normalized to " + numer + "/" + denom)

  def this(n: Int) = this(n, 1)

  def +(that: Rational) =
    new Rational(this.numer*that.denom + that.numer*this.denom, this.denom*that.denom)
  def -(that: Rational) =
    new Rational(this.numer*that.denom - that.numer*this.denom, this.denom*that.denom)
  def *(that: Rational) =
    new Rational(this.numer*that.numer, this.denom*that.denom)
  def /(that: Rational) =
    new Rational(this.numer*that.denom, this.denom*that.numer)

  private def gcd(x: Int, y: Int): Int = {
    println(x + "/" + y)
    if(y == 0) x else gcd(y, x % y)
  }

  override def toString() = numer + "/" + denom
}
