import akka.actor.{ActorRef, ActorSystem}
import akka.testkit.{ImplicitSender, TestActorRef, TestActors, TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class FirstActorTest extends TestKit(ActorSystem("MySpec"))
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }

  "1stActor" must {

    "inform 2ndActor upon receiving doYouMagic (using testActor)" in {
      val first: ActorRef = TestActorRef(FirstActor.props(testActor))
      first ! FirstActor.DoYourMagic
      expectMsg(FirstActor.GrabMagicWand)
    }

    "inform 2ndActor upon receiving doYouMagic (using TestProbe)" in {
      val probe = TestProbe()
      val first: ActorRef = TestActorRef(FirstActor.props(probe.ref))
      first ! FirstActor.DoYourMagic
      probe.expectMsg(FirstActor.GrabMagicWand)
    }

  }
}
