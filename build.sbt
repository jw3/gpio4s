organization := "gpio4s"
name := "gpio4s"
version := "0.2-SNAPSHOT"
licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.11.5"
scalacOptions += "-target:jvm-1.8"

resolvers += "jw3 at bintray" at "https://dl.bintray.com/jw3/maven"
credentials += Credentials(Path.userHome / ".bintray" / ".credentials")

libraryDependencies ++= Seq(
    "gpio4s" %% "gpiocfg" % "0.1",

    "com.typesafe" % "config" % "1.3.0",
    "net.ceedubs" %% "ficus" % "1.1.2",

    "com.typesafe.akka" %% "akka-actor" % "2.4.0",
    "com.typesafe.akka" %% "akka-slf4j" % "2.4.0" % Runtime,

    "org.scalatest" %% "scalatest" % "2.2.5" % Test,
    "com.typesafe.akka" %% "akka-testkit" % "2.4.0" % Test,
    "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % Test
)
