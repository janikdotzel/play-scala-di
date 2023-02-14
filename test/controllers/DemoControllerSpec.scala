package controllers

import controllers.mock.ServiceImplMock
import controllers.production.ServiceImplProduction
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers.{status, _}

class DemoControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "DemoController GET" should {

    "return the production message when the production implementation is used" in {
      val controller = new DemoController(new ServiceImplProduction, stubControllerComponents())
      val response = controller.demo().apply(FakeRequest(GET, "/"))

      status(response) mustBe OK
      contentAsString(response) must include("Production implementation")
    }

    "return the mock message when the mock implementation is used" in {
      val controller = new DemoController(new ServiceImplMock, stubControllerComponents())
      val response = controller.demo().apply(FakeRequest(GET, "/"))

      status(response) mustBe OK
      contentAsString(response) must include("Mock implementation")
    }
  }
}
