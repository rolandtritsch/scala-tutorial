package org.tritsch.scala.tutorial

import java.io.File

object TreeDir {
  final def printDir(dir: String, level: Int): Unit = {
    val files = new File(dir).listFiles
    for(f <- files; if(f.isDirectory)) {
      println("(" + level + ") - " + f.getAbsolutePath)
      printDir(f.getAbsolutePath, level + 1)
    }
  }

  final def listDir(dir: String): Map[String, List[String]] = {
    val files = new File(dir).listFiles.toList
    val fileNames = files.filter(_.isFile).map(_.getName)
    val dirNames = files.filter(_.isDirectory).map(_.getAbsolutePath)
    var thisDir = Map(dir -> fileNames)
    for(d <- dirNames) thisDir ++= listDir(d)
    thisDir
  }

  final def main(args: Array[String]): Unit = {
    assert(args.length == 1, "Expected one parameter - Usage: TreeDir <directory>")
    val rootDir = args(0)
    printDir(rootDir, 0)

    val dirs = listDir(rootDir)
    for((dir, files) <- dirs) {
      println(dir + " - > " + files.mkString(","))
    }
  }
}
