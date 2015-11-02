package org.study.ch3.actor

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class PingActor extends Actor {
  private val log = Logging(context.system, this)
  private val child = context.actorOf(Props[Ping1Actor], "ping1Actor")
  private var count = 0

  /*
    How can I count received without mutable variable?
    -> see `ch3_1` project.
   */

  override def receive: Receive = {
    case msg@"work" => child ! msg
    case "done" =>
      if (count == 0) {
        count = count + 1
      } else {
        log.info("all works are completed.")
        count = 0
      }
  }
}
