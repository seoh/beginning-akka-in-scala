package org.study.ch4.actor

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, OneForOneStrategy, Props}
import akka.event.Logging

import scala.concurrent.duration._

/**
 * Created by seoh on 31/10/2015.
 */
class Ping1Actor extends Actor {
  private val log = Logging(context.system, this)
  private val child1 = context.actorOf(Props[Ping2Actor], "ping2Actor")
  private val child2 = context.actorOf(Props[Ping3Actor], "ping3Actor")

  override def receive: Receive = {
    case msg@("good" | "bad") =>
      log.info("Ping1Actor received {}", msg)
      (child1 ! msg)(sender)
      (child2 ! msg)(sender)
    case msg => unhandled(msg)
  }

  override def supervisorStrategy: OneForOneStrategy = Ping1Actor.strategy
}

object Ping1Actor {
  def strategy: OneForOneStrategy =
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
      case _: ArithmeticException => Resume
      case _: NullPointerException => Restart
      case _: IllegalArgumentException => Stop
      case _ => Escalate
    }
}
