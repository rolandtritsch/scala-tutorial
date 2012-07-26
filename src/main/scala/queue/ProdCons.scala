package org.tritsch.scala.tutorial.queue

import java.util.concurrent.{BlockingQueue, LinkedBlockingQueue}
import com.weiglewilczek.slf4s.Logging
import java.util.concurrent.atomic.{AtomicInteger, AtomicBoolean}

object ProdCons extends App with Logging {
  override def main(args: Array[String]): Unit = {
    logger.info("args: " + args.mkString(","))
    assert(args.length == 5)
    val numberOfProdThreads = args(0).toInt
    val delayProd = args(1).toInt
    val numberOfConsThreads = args(2).toInt
    val delayCons = args(3).toInt
    val duration = args(4).toInt

    val q = new LinkedBlockingQueue[Int]
    val n = new AtomicInteger(0)
    val signalDone = new AtomicBoolean(false)

    logger.info("start all the producers ...")
    for(i <- 0 until numberOfProdThreads) {
      new Thread(new Producer(q, n, delayProd, signalDone)).start
    }

    logger.info("start all the consumers ...")
    for(i <- 0 until numberOfConsThreads) {
      new Thread(new Consumer(q, delayCons, signalDone)).start
    }

    logger.info("start the monitor (block until it is done) ...")
    (new Monitor(q, duration)).run

    logger.info("stopping all threads ...")
    signalDone.set(true)
  }
}
