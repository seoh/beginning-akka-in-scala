package org.study.ch3_1.actor

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class Ping1Actor extends Actor {
  private val log = Logging(context.system, this)

  private val child1 = context.actorOf(Props[Ping2Actor], "ping2Actor")
  private val child2 = context.actorOf(Props[Ping3Actor], "ping3Actor")

  override def receive: Receive = {
    case msg@"work" =>
      log.info("Ping1 received {}", msg)
      (child1 ! msg)(sender)
      (child2 ! msg)(sender)
  }
}
