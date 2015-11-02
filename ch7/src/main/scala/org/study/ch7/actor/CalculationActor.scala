package org.study.ch7.actor

import akka.actor.Actor
import akka.event.Logging


/**
 * Created by seoh on 31/10/2015.
 */
class CalculationActor extends Actor {
  private val log = Logging(context.system, this)

  override def receive: Receive = {
    case n: Integer =>
      log.info("CalculationActor received {}", n)
      work(n)
      sender ! (n * 2)
  }


  private def work(n: Int) {
    log.info("CalculationActor working on " + n)
    Thread.sleep(1000)
    log.info("CalculationActor completed " + n)
  }
}
