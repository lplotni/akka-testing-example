import akka.actor.{Actor, ActorRef, Props}
object FirstActor {
  def props(secondActor: ActorRef) = Props(new FirstActor(secondActor))

  case object DoYourMagic
  case object GrabMagicWand
}

class FirstActor(secondActor: ActorRef) extends Actor {
  import FirstActor._
  override def receive: Receive = {
    case DoYourMagic => secondActor ! GrabMagicWand
  }
}
