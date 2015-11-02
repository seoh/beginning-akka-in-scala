package org.study.ch6

import akka.actor.{ActorSystem, Props}
import org.study.ch6.actor.PingActor

/**
 * Created by seoh on 31/10/2015.
 */
object Main {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch6System")
    val ping = system.actorOf(Props[PingActor], "pingActor")
    ping ! "start"
  }
}
