package org.tritsch.scala.tutorial.queue

import java.util.concurrent.BlockingQueue
import java.util.concurrent.atomic.{AtomicInteger, AtomicBoolean}
import com.weiglewilczek.slf4s.Logging

class Producer(q: BlockingQueue[Int], i: AtomicInteger, delay: Int, done: AtomicBoolean) extends Runnable with Logging {
  def run() {
    while(!done.get) {
      val current = i.getAndIncrement()
      logger.info("putting " + current + " into queue ...")
      q.put(current)
      Thread.sleep(delay)
    }
  }
}
