package org.study.ch8.http

import akka.actor.ActorRef
import akka.camel.{CamelMessage, Consumer}

/**
 * Created by seoh on 01/11/2015.
 */
class HttpActor(service: ActorRef) extends Consumer {
  override def endpointUri: String = "jetty:http://localhost:8877/akkaStudy"

  override def receive: Receive = {
    case msg: CamelMessage => service ! "hello"
    case msg: String => sender ! msg
    case _@msg => unhandled(msg)
  }
}
