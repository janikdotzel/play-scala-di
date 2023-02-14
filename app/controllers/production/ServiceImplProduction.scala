package controllers.production

import controllers.Service

class ServiceImplProduction() extends Service {

  override def externalCall(): Unit = println("Calling production service")
}
