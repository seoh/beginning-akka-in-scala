package org.study.ch5

import akka.actor.{ActorSystem, Props}
import org.study.ch5.actor.PingActor

/**
 * Created by seoh on 31/10/2015.
 */
object Main {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch5System")
    val ping = system.actorOf(Props[PingActor], "pingActor")
    ping ! "work"
    ping ! "reset"
  }
}
