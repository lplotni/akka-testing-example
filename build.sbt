name:="akka-testing-example"
version:="0.1"
scalaVersion:="2.12.2"

lazy val versions = new {
  val mockito = "1.9.5"
  val scalatest = "3.0.1"
  val specs2 = "2.3.12"
  val akka = "2.5.2"
}

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-core" % versions.mockito % "test" withSources(),
  "org.scalatest" % "scalatest_2.12" % versions.scalatest % "test",
  "com.typesafe.akka" %% "akka-actor" % versions.akka,
  "com.typesafe.akka" %% "akka-testkit" % versions.akka % "test"
)

