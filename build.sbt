import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.{libraryDependencies, _}
import sbt._

import scala.language.postfixOps

val scalaJsIOVersion = "0.5.0"
val apiVersion = scalaJsIOVersion
val scalaJsVersion = "2.12.8"

lazy val root = (project in file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(
    name := "nodejs",
    version := apiVersion,
    organization := "io.scalajs",
    description := "NodeJS v8.7.0 API for Scala.js",
    homepage := Some(url("https://github.com/scalajs-io/nodejs")),
    scalaVersion := scalaJsVersion,
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    autoCompilerPlugins := true,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
    logBuffered in Test := true,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaJsVersion,
      "io.scalajs" %%% "core" % scalaJsIOVersion,
      "org.scalactic" %% "scalactic" % "3.0.1",
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
    ))

lazy val publishingSettings = Seq(
  sonatypeProfileName := "org.xerial",
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <url>https://github.com/scalajs-io/nodejs</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/scalajs-io/nodejs.git</connection>
        <developerConnection>scm:git:git@github.com:scalajs-io/nodejs.git</developerConnection>
        <url>github.com/scalajs-io/nodejs.git</url>
      </scm>
      <developers>
        <developer>
          <id>scalajs-io</id>
          <name>Lawrence Daniels</name>
          <email>lawrence.daniels@gmail.com</email>
          <organization>io.scalajs</organization>
          <organizationUrl>https://github.com/scalajs-io</organizationUrl>
          <roles>
            <role>Project-Administrator</role>
            <role>Developer</role>
          </roles>
          <timezone>+7</timezone>
        </developer>
      </developers>
)

// loads the Scalajs-io root project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value