package mock

import com.google.inject.AbstractModule
import controllers.Service

class MockModule extends AbstractModule{

  override def configure(): Unit = bind(classOf[Service]).to(classOf[ServiceImplMock])

}
