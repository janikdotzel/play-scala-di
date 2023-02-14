package controllers.mock

import controllers.Service

class ServiceImplMock() extends Service {

  override def externalCall: String = "Mock implementation"
}
