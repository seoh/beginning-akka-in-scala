package org.study.ch6.actor

import akka.actor.Actor
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class Ping1Actor extends Actor {
  private val log = Logging(context.system, this)

  override def receive: Receive = {
    case n: Integer =>
      log.info("Ping1Actor({}) received {}", hashCode(), n)
      work(n)
  }

  private def work(n: Integer) {
    log.info("Ping1Actor({}) working on {}", hashCode(), n)
    Thread.sleep(1000)
    log.info("Ping1Actor({}) completed ", hashCode())
  }
}
