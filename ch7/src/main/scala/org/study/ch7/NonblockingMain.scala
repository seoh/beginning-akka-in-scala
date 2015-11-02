package org.study.ch7

import akka.actor.{ActorSystem, Props}
import org.study.ch7.actor.NonblockingActor

/**
 * Created by seoh on 31/10/2015.
 */
object NonblockingMain {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch7System")
    val nonblock = system.actorOf(Props[NonblockingActor], "nonblockingActor")

    nonblock ! 10
    nonblock ! "hello"
  }
}
