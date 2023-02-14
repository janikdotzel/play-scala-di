package controllers.production

trait Service {
  def externalCall(data: String): Unit
}
