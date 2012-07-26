package org.tritsch.scala.tutorial

object Lists {
  final def main(args: Array[String]) {
    val intList = (1 to 10).toList
    val strList = intList.map(i => "String" + i)

    println("Even: " + intList.count(i => i%2 == 0))
    println("Odd: " + intList.count(_%2 == 1))

    println("Max: " + strList.max)
    println("Longest: " + strList.reduceLeft((a, b) => if(a.length > b.length) a else b))
    print("Length: "); strList.foreach(s => print(s + "(" + s.length + ") ")); println;
    println("Length: " + strList.groupBy(_.length))
  }
}
