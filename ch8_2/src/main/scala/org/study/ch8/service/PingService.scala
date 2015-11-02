package org.study.ch8.service

import akka.actor.Actor
import akka.event.Logging

/**
 * Created by seoh on 01/11/2015.
 */
class PingService extends Actor {
  private val log = Logging(context.system, this)
  private var count = 0

  override def receive: Receive = {
    case msg: String => sender ! s"PING: ${count += 1}"
    case msg@_ => unhandled(msg)
  }
}
