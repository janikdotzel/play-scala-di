package controllers

import com.google.inject.ImplementedBy
import production.ServiceImplProduction

@ImplementedBy(classOf[ServiceImplProduction])
trait Service {
  def externalCall: String
}
