name := "senSim"

version := "0.1"

scalaVersion := "2.12.4"

val guiceV = "4.2.2"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % guiceV
)