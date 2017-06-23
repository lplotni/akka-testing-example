import akka.actor.{Actor, Props}
object SimpleActor {
  def props() = Props(new AnotherActor())
}
class SimpleActor extends Actor {
  override def receive: Receive = {
    case AnotherActor.Bzzz => println("Bzzz"); sender() ! "Bzzz back"
  }
}
