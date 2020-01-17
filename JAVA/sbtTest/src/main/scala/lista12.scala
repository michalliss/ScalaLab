import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

import scala.util.Random

class Player(val name: String) extends Actor with ActorLogging {
  override def receive: Receive = {
    case counter: Int => if (counter < 100) {
      println(name)
      sender() ! counter + 1
    } else {
      println("Koniec!")
    }
  }

}

case class Ball(counter: Int)

class Player2(val name: String, val players: Array[ActorRef]) extends Actor {
  override def receive: Receive = {
    case Ball(count) => {
      players(Random.nextInt(players.size)) ! Ball(count + 1)
    }
    case _ => println("błąd")
  }
}


object Main extends App {
  val system = ActorSystem();
  val player1: ActorRef = system.actorOf(Props(classOf[Player], "ping"))
  val player2: ActorRef = system.actorOf(Props(classOf[Player], "pong"))

  player1.tell(0, player2);

}


object Main2 extends App {
  val system = ActorSystem();
  val players1
  val player1: ActorRef = system.actorOf(Props(classOf[Player2], "ping", Arra))
  val player2: ActorRef = system.actorOf(Props(classOf[Player2], "pong"))

  player1.tell(0, player2);

}
