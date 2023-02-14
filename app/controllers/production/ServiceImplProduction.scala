package controllers.production

import controllers.Service

class ServiceImplProduction() extends Service {

  override def externalCall: String = "Production implementation"
}
