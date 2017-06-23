import akka.actor.{Actor, ActorRef, Props}
object AnotherActor{
  def props() = Props(new AnotherActor())

  case object Bzzz
}

class AnotherActor() extends Actor {
  import AnotherActor._

  val yetAntotherActor = context.actorOf(SimpleActor.props())

  override def receive: Receive = {
    case  FirstActor.GrabMagicWand => yetAntotherActor ! Bzzz
  }
}
