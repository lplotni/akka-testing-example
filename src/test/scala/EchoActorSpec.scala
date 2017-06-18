import akka.actor.ActorSystem
import akka.testkit.{ ImplicitSender, TestActors, TestKit }
import org.scalatest.{ BeforeAndAfterAll, Matchers, WordSpecLike }

class EchoActorSpec extends TestKit(ActorSystem("MySpec")) //the actor system passed here is exposed via system in the test
  with ImplicitSender // provides a TestActor that will be receiving all the msg send to sender() which can be checked via expectMsg() assertions
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system) // Mus be done!
  }

  "An Echo actor" must {

    "send back messages unchanged" in {
      val echo = system.actorOf(TestActors.echoActorProps)
      echo ! "hello world"
      expectMsg("hello world")
      // see http://doc.akka.io/docs/akka/current/scala/testing.html#built-in-assertions for the list of available assertions
      //as with actors we deal with asynchronous calls, we always operate within limits of timeouts -> if not defined explicitly
      //we always have a timeout of 3sec
    }

  }
}
