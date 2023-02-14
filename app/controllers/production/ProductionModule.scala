package controllers.production

import com.google.inject.AbstractModule
import controllers.Service

class ProductionModule extends AbstractModule {

  override def configure(): Unit = bind(classOf[Service]).to(classOf[ServiceImplProduction])
}
