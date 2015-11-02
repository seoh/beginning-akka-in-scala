package org.study.ch6.actor

import akka.actor.{Actor, Props}
import akka.event.Logging
import akka.routing.RoundRobinPool

/**
 * Created by seoh on 31/10/2015.
 */
class PingActor extends Actor {
  private val log = Logging(context.system, this)
  private val childRouter = context.actorOf(RoundRobinPool(5).props(Props[Ping1Actor]), "ping1Actor")

  override def receive: Receive = {
    case msg: String =>
      for (i <- 0 until 10) childRouter ! i
      log.info("PingActor sent 10 messages to the router.")
    case msg@_ => unhandled(msg)
  }
}
