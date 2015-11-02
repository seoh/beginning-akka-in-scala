package org.study.ch4

import akka.actor.{ActorSystem, Props}
import org.study.ch4.actor.PingActor

/**
 * Created by seoh on 31/10/2015.
 */
object GoodMain {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch4System")
    val ping = system.actorOf(Props[PingActor], "pingActor")
    ping ! "good"
  }
}
