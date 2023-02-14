package controllers.test

import controllers.Service

class ServiceImplTest() extends Service {

  override def externalCall(): Unit = println("Calling test service")

}
