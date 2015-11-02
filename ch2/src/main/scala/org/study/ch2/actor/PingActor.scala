package org.study.ch2.actor

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class PingActor extends Actor {
  private val log = Logging(context.system, this)
  private val pong = context.actorOf(Props[PongActor], "pongActor")
  /*
    #TODO
    `val pong` is equivalent with Java example. but why use implicit?

    in scala example,
      root - ping
           - pong (implicit)

    in java example,
      root - ping - pong
   */

  override def receive: Receive = {
    case msg@"Pong" =>
      log.info("Ping received {}", msg)
      Thread.sleep(1000); // Don't do this in real code!!
      pong ! "Ping"
  }
}
