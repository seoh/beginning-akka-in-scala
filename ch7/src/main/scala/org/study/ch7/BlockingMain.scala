package org.study.ch7

import akka.actor.{ActorSystem, Props}
import org.study.ch7.actor.BlockingActor

/**
 * Created by seoh on 31/10/2015.
 */
object BlockingMain {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch7System")
    val block = system.actorOf(Props[BlockingActor], "blockingActor")

    block ! 10
    block ! "hello"
  }
}
