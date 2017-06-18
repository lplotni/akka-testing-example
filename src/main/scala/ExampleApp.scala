import akka.actor.ActorSystem

object ExampleApp extends App {

  println("About to spin up our actor sytstem")
  spinupActors

  def spinupActors = {
    println("Just a sec...")
    val actors = ActorSystem("MagicSystem")
  }


}
