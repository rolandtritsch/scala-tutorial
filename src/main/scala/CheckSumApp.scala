package org.tritsch.scala.tutorial

object CheckSumApp extends App {
  for(season <- List("winter", "spring", "summer", "fall")) { 
    println(season + " -> " + CheckSumCalculator.calc(season))
  }
}
