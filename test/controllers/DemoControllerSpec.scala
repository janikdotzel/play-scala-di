package controllers

import mock.{MockModule, ServiceImplMock}
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.http.Status.OK
import play.api.test.Helpers.{GET, contentAsString, defaultAwaitTimeout, route, status, stubControllerComponents, writeableOf_AnyContentAsEmpty}
import play.api.test.{FakeRequest, Injecting}
import production.ServiceImplProduction

class DemoControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "DemoController GET" should {

    "return the production message when the production implementation is used" in {
      val controller = new DemoController(new ServiceImplProduction, stubControllerComponents())
      val response = controller.demo().apply(FakeRequest(GET, "/demo"))

      status(response) mustBe OK
      contentAsString(response) must include("Production implementation")
    }

    "return the mock message when the mock implementation is used" in {
      val controller = new DemoController(new ServiceImplMock, stubControllerComponents())
      val response = controller.demo().apply(FakeRequest(GET, "/demo"))

      status(response) mustBe OK
      contentAsString(response) must include("Mock implementation")
    }

    "return the production message when the endpoint is requested" in {
      val app = new GuiceApplicationBuilder()
        .build()

      val response: String = route(app, FakeRequest(GET, "/demo")).map(contentAsString(_)).getOrElse("")
      response must include("Production implementation")
    }

    "return the mock message when the endpoint is requested with overridden bindings" in {
      val app = new GuiceApplicationBuilder()
        .overrides(new MockModule)
        .build()

      val response: String = route(app, FakeRequest(GET, "/demo")).map(contentAsString(_)).getOrElse("")
      response must include("Mock implementation")
    }
  }
}
