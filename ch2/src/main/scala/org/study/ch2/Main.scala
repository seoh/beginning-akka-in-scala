package org.study.ch2

import akka.actor.{ActorSystem, Props}
import org.study.ch2.actor.PingActor

/**
 * Created by seoh on 31/10/2015.
 */

object Main {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch2System")
    val ping = system.actorOf(Props[PingActor], "pingActor")
//    implicit val pong = system.actorOf(Props[PongActor], "pongActor")

    ping ! "Pong"
  }
}
