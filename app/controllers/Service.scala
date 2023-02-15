package controllers

import com.google.inject.ImplementedBy

@ImplementedBy(classOf[ServiceImplProduction])
trait Service {
  def externalCall: String
}
