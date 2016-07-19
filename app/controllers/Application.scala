package controllers

import play.api.libs.json._
import play.api.mvc._

import models.Article._

object Application extends Controller {
  def listSections = Action {
    Ok(Json.toJson(sections))
  }  
}
