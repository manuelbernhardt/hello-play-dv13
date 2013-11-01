name := "hello-play"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

scalariformSettings

com.jamesward.play.BrowserNotifierPlugin.livereload

def playProject(name: String) = play.Project(name = name, path = file(name)).settings(scalariformSettings :_*)

lazy val core = playProject("core")

lazy val module1 = playProject("module1").dependsOn(core)

lazy val module2 = playProject("module2").dependsOn(core)

lazy val root = play.Project(name = "hello-play", path = file(".")).
		          dependsOn(module1, module2).
                  aggregate(module1, module2).
                  settings(scalariformSettings :_*)
