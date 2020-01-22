package zad2

import akka.actor._

import scala.util.Random

class Player(val num: Int, val players: Array[ActorRef]) extends Actor {
  override def receive: Receive = {
    case Ball(count) => {
      Thread.sleep(100)
      println("gracz " + num + " przyjął " + count)
      val player = players.filter(_ != self)(Random.nextInt(players.length-1))
      println("gracz " + num + " rzuca")
      player ! Ball(count + 1)
    }
  }

}

case class Ball(counter: Int)


object Main extends App {
  val system = ActorSystem();

  val players = new Array[ActorRef](3)

  players(0) = system.actorOf(Props(classOf[Player], 1, players))
  players(1) = system.actorOf(Props(classOf[Player], 2, players))
  players(2) = system.actorOf(Props(classOf[Player], 3, players))

  players(0) ! Ball(0)
}
