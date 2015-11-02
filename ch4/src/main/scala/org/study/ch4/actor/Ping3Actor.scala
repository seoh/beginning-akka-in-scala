package org.study.ch4.actor

import akka.actor.Actor
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class Ping3Actor extends Actor {
  private val log = Logging(context.system, this)

  log.info("Ping3Actor constructor..")

  override def preRestart(reason: Throwable, message: Option[Any]): Unit =
    log.info("Ping3Actor preRestart..")

  override def postRestart(reason: Throwable): Unit =
    log.info("Ping3Actor postRestart..")

  override def postStop(): Unit =
    log.info("Ping3Actor postStop..")

  def goodWork: Unit = log.info("Ping3Actor is good.")

  def badWork: Unit = throw new NullPointerException

  override def receive: Receive = {
    case "good" =>
      goodWork
      sender ! "done"
    case "bad" => badWork
    case msg => unhandled(msg)

  }
}
