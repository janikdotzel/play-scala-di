package controllers.production

class ServiceCController() extends Service {

  override def externalCall(data: String): Unit = println("Calling Service C with: " + data)

}
