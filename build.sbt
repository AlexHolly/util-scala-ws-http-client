name := "http-client"

organization := "de.alexholly.util"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.7"

assemblyJarName in assembly := "http-client" + ".jar"

libraryDependencies ++= Seq(
  "org.scalatest"     %% "scalatest" % "2.2.4" % "test",
  "com.typesafe.play" %% "play-ws"   % "2.4.3" exclude("org.slf4j", "jcl-over-slf4j")
)

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
