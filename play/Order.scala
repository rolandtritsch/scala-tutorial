trait Ordered {
  def <(that: Any): Boolean
  def <=(that: Any): Boolean = (this < that) || (this == that)
  def >(that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

class Date(val d: Int, val m: Int, val y: Int) extends Ordered {
  override def toString = s"${d}-${m}-${y}"

  override def equals(that: Any): Boolean = {
    that.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      d == o.d && m == o.m && y == o.y
    }
  }

  override def <(that: Any): Boolean = {
    that.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      (y < o.y) || ((y == o.y) && (m < o.m)) || ((y == o.y) && (m == o.m) && (d < o.d))
    }
  }
}

object Order {
  def main(args: Array[String]) {
    val yesterday = new Date(1, 2, 3)
    val today = new Date(2, 2, 3)
    val tomorrow = new Date(3, 2, 3)

    assert(yesterday < today)
    assert(today < tomorrow)
    assert(today > yesterday)
    assert(today <= today)
    assert(today >= today)
  }
}
