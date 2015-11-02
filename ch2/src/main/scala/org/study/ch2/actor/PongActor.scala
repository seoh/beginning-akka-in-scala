package org.study.ch2.actor

import akka.actor.Actor
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class PongActor extends Actor {
  private val log = Logging(context.system, this)

  def receive: Receive = {
    case msg@"Ping" =>
      log.info("Pong received {}", msg)
      sender ! "Pong"
    case x@_ => log.info(">>> received {}", x)
  }
}
