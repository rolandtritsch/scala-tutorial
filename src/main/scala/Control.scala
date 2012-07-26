package org.tritsch.scala.tutorial

object Control extends App {
  assert(args.length == 2, "Need 2 parameters - Usage: Control <first> <second>")
  val first = args(0)
  val second = args(1)

  val bigger = if(first.length > second.length) first else second
  println("Bigger: " + bigger)

  for(a <- args) println("For(args) -> " + a)
  for(i <- 1.to(3)) println("For(1..3) -> " + i)
  for(i <- 1.to(10); if(i%2 == 0)) println("For(even) -> " + i)

  val even = for(i <- 1.to(10).toArray; if(i%2 == 0)) yield i
  println("Even: " + even.mkString(","))

  val b = try {
    mustBeTrue(true)
  } catch {
    // println("Catching " + ex)
    case ex: RuntimeException => println("Runtime Exception")
    // case ex: _ => println("Other Exception")
  } finally {
    println("Tried it once ...")
  }
  println("... and found " + b)

  val bb = try {
    mustBeTrue(false)
  } catch {
    // println("Catching " + ex)
    case ex: RuntimeException => println("Runtime Exception")
    // case ex: _ => println("Other Exception")
  } finally {
    println("Tried it twice ...")
  }
  println("... and found " + bb)

  val bbb = try {true} finally {false}; println(bbb)
  val bbbb = try {} finally {false}; println(bbbb)

  val english = args
  val german = english.map(translate(_))
  println("English " + english.mkString(","))
  println("German " + german.mkString(","))
  // val dict = english.zip(german)
  // dict.foreach(println(_._1 + " -> " + _._2))

  private final def mustBeTrue(b: Boolean): Boolean = {
    if(!b) throw new RuntimeException("This must be true")
    b
  }

  private final def translate(e: String): String = {
    e match {
      case "first" => "erstens"
      case "second" => "zweitens"
      case _ => "What???"
    }
  }
}
