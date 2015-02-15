class Complex(r: Double, i: Double) {
  def rr() = r
  def ii() = i
  override def toString: String = s"${r}:${i}"
}

object Complex {
  def main(args: Array[String]) {
    val c1 = new Complex(1.5, 2.5)
    println(c1)
    println(s"${c1.rr}:${c1.ii}")
  }
}
