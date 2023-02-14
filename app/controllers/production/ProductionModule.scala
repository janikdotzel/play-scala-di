package controllers.production

import controllers.Service
import play.api.{Configuration, Environment}
import play.api.inject.{Binding, Module}

class ProductionModule extends Module {

  override def bindings(environment: Environment, configuration: Configuration) = Seq(
    bind[Service].to(classOf[ServiceImplProduction])
  )
}
