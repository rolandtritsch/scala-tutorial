package org.tritsch.scala.tutorial.queue

import java.util.concurrent.BlockingQueue
import java.util.concurrent.atomic.AtomicBoolean
import com.weiglewilczek.slf4s.Logging

class Consumer(q: BlockingQueue[Int], delay: Int, done: AtomicBoolean) extends Runnable with Logging {
  def run() {
    while(!done.get) {
      val i = q.take
      logger.info("taking " + i + " out of the queue ...")
      Thread.sleep(delay)
    }
  }
} 
