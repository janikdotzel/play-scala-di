package controllers.test

import com.google.inject.AbstractModule
import controllers.Service

class TestModule extends AbstractModule{

  override def configure(): Unit = bind(classOf[Service]).to(classOf[ServiceImplTest])

}
