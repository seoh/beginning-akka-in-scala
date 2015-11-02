name := "beginning-akka"

version := "1.0"


val commonDependencies = Seq[ModuleID](
  "com.typesafe.akka" %% "akka-actor" % "2.4.0"
)

val commonSetting = Seq(
  scalaVersion := "2.11.7",
  libraryDependencies := commonDependencies
)


lazy val ch2 = project.settings(commonSetting: _*)
lazy val ch3 = project.settings(commonSetting: _*)
lazy val ch3_1 = project.settings(commonSetting: _*)
lazy val ch4 = project.settings(commonSetting: _*)
lazy val ch5 = project.settings(commonSetting: _*)
lazy val ch6 = project.settings(commonSetting: _*)
lazy val ch7 = project.settings(commonSetting: _*)
lazy val ch7_1 = project.settings(commonSetting: _*)
  .settings(libraryDependencies += "com.typesafe.akka" %% "akka-agent" % "2.4.0")
lazy val ch8_1 = project.settings(commonSetting: _*)
  .settings(libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-camel" % "2.4.0",
    "com.typesafe.akka" %% "akka-cluster" % "2.4.0",
    "org.apache.camel" % "camel-jetty" % "2.16.0"
  ))
lazy val ch8_2 = project.settings(commonSetting: _*)
  .settings(libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.4.0")