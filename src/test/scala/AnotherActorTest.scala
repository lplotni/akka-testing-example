import akka.actor.{ActorRef, ActorSystem}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers, WordSpecLike}

class AnotherActorTest extends TestKit(ActorSystem("MySpec"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "AnotherActor" must {

    //Use testActor whenever asserting 1 to 1 interactions
    "" in {
//      val firstActor = system.actorOf(FirstActor.props(system.actorOf(AnotherActor.props())))
      val firstActor = TestActorRef(FirstActor.props(TestActorRef(AnotherActor.props())))

      firstActor ! FirstActor.DoYourMagic

      expectMsg("Bzz back")
    }


  }
}
