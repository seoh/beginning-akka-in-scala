package org.study.ch7_1

import akka.actor.{Actor, ActorSystem, Props}
import akka.agent.Agent
import akka.event.Logging


/**
 * Created by seoh on 01/11/2015.
 */
object Main {
  def main(args: Array[String]) {
    val system = ActorSystem.create("ch7System")
    val agent = system.actorOf(Props[AgentActor], "agentActor")
    agent ! ""
  }
}


class AgentActor extends Actor {
  private val log = Logging(context.system, this)
  private val ec = context.dispatcher

  override def receive = {
    case msg =>
      val agent = Agent.create(5, ec)
      agent.send(_ * 2)
      log.info("Current agent value = " + agent.get)
      Thread.sleep(100)
      log.info("Current agent value = " + agent.get)
  }
}