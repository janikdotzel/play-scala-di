package controllers

import play.api.inject.Module
import play.api.{Configuration, Environment}

class ProductionModule extends Module {
  override def bindings(environment: Environment, configuration: Configuration) =
    Seq(bind[Service].to(classOf[ServiceImplProduction]))
}
