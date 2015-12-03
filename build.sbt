name := "http-client"

organization := "de.alexholly.util"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest"     %% "scalatest" % "2.2.4" % "test",
  "com.typesafe.play" %% "play-ws"   % "2.4.3" exclude("org.slf4j", "jcl-over-slf4j")
)
