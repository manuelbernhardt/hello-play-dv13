name := "hello-play"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

scalariformSettings

org.scalastyle.sbt.ScalastylePlugin.Settings

com.jamesward.play.BrowserNotifierPlugin.livereload

def playProject(name: String) = play.Project(name = name, path = file("modules/" + name)).
  settings(scalariformSettings :_*).
  settings(org.scalastyle.sbt.ScalastylePlugin.Settings :_*)

lazy val core = playProject("core")

lazy val module1 = playProject("module1").dependsOn(core)

lazy val module2 = playProject("module2").dependsOn(core)

lazy val root = playProject("hello-play").in(file(".")).
		          dependsOn(module1, module2).
                  aggregate(module1, module2).
                  settings(scalariformSettings :_*)
