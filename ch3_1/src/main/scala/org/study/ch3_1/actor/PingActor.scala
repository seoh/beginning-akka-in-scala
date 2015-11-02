package org.study.ch3_1.actor

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class PingActor extends Actor {
  private val log = Logging(context.system, this)
  private val child = context.actorOf(Props[Ping1Actor], "ping1Actor")

  override def receive: Receive = {
    case msg@"work" => child ! msg
    case msg@"done" => context become half
  }

  val half: Receive = {
    case msg@"done" => log.info("all works are completed.")
  }
}
