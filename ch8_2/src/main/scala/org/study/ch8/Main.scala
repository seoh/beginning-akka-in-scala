package org.study.ch8

import akka.actor.{Props, ActorSystem}
import org.study.ch8.service.PingService

/**
 * Created by seoh on 01/11/2015.
 */
object Main {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch8System")
    val ping = system.actorOf(Props[PingService], "pingService")
  }
}
