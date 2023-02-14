package controllers.production

import com.google.inject.AbstractModule

class ProductionModule extends AbstractModule {

  override def configure(): Unit =
    bind(classOf[Service]).to(classOf[ServiceAController])
}
