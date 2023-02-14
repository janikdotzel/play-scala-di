package controllers

import javax.inject._
import play.api._
import play.api.mvc._


@Singleton
class DemoController @Inject() (service: Service, cc: ControllerComponents) extends AbstractController(cc) {

  def demo() = Action { Ok(service.externalCall) }
}
