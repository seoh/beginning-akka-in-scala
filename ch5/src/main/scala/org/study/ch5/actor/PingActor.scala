package org.study.ch5.actor

import akka.actor.{Actor, Props, Stash}
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class PingActor extends Actor with Stash {
  private val log = Logging(context.system, this)
  private val child = context.actorOf(Props[Ping1Actor], "ping1Actor")

  override def receive: Receive = initial

  val initial: Receive = {
    case "work" =>
      child ! "work"
      context become zeroDone
    case _ => stash
  }

  val zeroDone: Receive = {
    case "done" =>
      log.info("Received the first done")
      context become oneDone
    case _ => stash
  }

  val oneDone: Receive = {
    case "done" =>
      log.info("Received the second done")
      context become allDone
      unstashAll
    case _ => stash
  }

  val allDone: Receive = {
    case "reset" =>
      log.info("Received a reset")
      context become initial
  }
}
