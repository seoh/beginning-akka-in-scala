package org.study.ch4.actor

import akka.actor.Actor
import akka.event.Logging

/**
 * Created by seoh on 31/10/2015.
 */
class Ping2Actor extends Actor {
  private val log = Logging(context.system, this)

  log.info("Ping2Actor constructor..")

  override def preRestart(reason: Throwable, message: Option[Any]): Unit =
    log.info("Ping2Actor preRestart..")

  override def postRestart(reason: Throwable): Unit =
    log.info("Ping2Actor postRestart..")

  override def postStop(): Unit =
    log.info("Ping2Actor postStop..")

  def goodWork: Unit = log.info("Ping2Actor is good.")

  def badWork: Int = 1 / 0

  override def receive: Receive = {
    case "good" =>
      goodWork
      sender ! "done"
    case "bad" => badWork
    case msg => unhandled(msg)
  }
}
