import play.sbt.PlayScala
import play.sbt.PlayImport.guice

name := """play-scala-seed"""
organization := "io.janikdotzel"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
