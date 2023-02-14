package controllers.production

class ServiceBController() extends Service {

  override def externalCall(data: String): Unit = println("Calling Service B with: " + data)

}
