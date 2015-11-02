package org.study.ch7.actor

import akka.actor.{Actor, Props}
import akka.event.Logging
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

/**
 * Created by seoh on 31/10/2015.
 */
class BlockingActor extends Actor {
  private val log = Logging(context.system, this)
  private val child = context.actorOf(Props[CalculationActor], "calculationActor")
  private implicit val ec = context.system.dispatcher
  private implicit val timeout = Timeout(5 seconds)

  override def receive: Receive = {
    case n: Integer =>
      val result = Await.result(child ? n, 5 seconds).asInstanceOf[Integer]
      log.info("Final result is " + (result + 1));
    case msg: String =>
      log.info("BlockingActor received a messasge: " + msg)
  }
}
