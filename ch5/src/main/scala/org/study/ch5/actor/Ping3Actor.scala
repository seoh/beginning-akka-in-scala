package org.study.ch5.actor

import akka.actor.Actor
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class Ping3Actor extends Actor {
  private val log = Logging(context.system, this)

  override def receive: Receive = {
    case msg: String =>
      log.info("Ping3 received {}", msg)
      work
      sender ! "done"
  }

  private def work = {
    Thread.sleep(1000)
    log.info("Ping3 working...")
  }
}
