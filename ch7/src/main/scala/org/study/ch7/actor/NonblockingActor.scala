package org.study.ch7.actor

import akka.actor.{Actor, Props}
import akka.event.Logging
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success}

/**
 * Created by seoh on 31/10/2015.
 */
class NonblockingActor extends Actor {
  private val log = Logging(context.system, this)
  private val child = context.actorOf(Props[CalculationActor], "calculationActor")
  private implicit val ec = context.system.dispatcher
  private implicit val timeout = Timeout(5 seconds)


  override def receive: Receive = {
    case n: Integer =>
      (child ? n) onComplete {
        case Success(result) => log.info("Succeeded with " + result)
        case Failure(t) => log.info("Failed with " + t)
      }
    case msg: String => log.info("NonblockingActor received a messasge: " + msg)
  }
}
