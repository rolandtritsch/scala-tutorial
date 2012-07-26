package org.tritsch.scala.tutorial.queue

import java.util.concurrent.BlockingQueue
import com.weiglewilczek.slf4s.Logging

class Monitor(q: BlockingQueue[Int], secs: Int) extends Runnable with Logging {
  def run() {
    for(i <- 0 until secs) {
      logger.info("current length of queue is " + q.size + " ...")
      Thread.sleep(1000)
    }
  }
}
