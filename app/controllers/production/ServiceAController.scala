package controllers.production

class ServiceAController() extends Service{

  override def externalCall(data: String): Unit = println("Calling Service A with: " + data)
}
