package org.study.ch8

import akka.actor.{ActorSystem, Props}
import akka.routing.FromConfig
import org.study.ch8.http.HttpActor
import org.study.ch8.service.PingService

/**
 * Created by seoh on 01/11/2015.
 */
object Main {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch8System")
    val router = system.actorOf(FromConfig.props(Props[PingService]), "serviceRouter")
    val http = system.actorOf(Props.create(classOf[HttpActor], router), "httpActor")
  }
}
