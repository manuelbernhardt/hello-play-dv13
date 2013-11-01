package controllers

import play.api._
import play.api.mvc._

object Application extends BaseController {

  def index = Action {
    Ok(views.html.index("Look ma, refreshing the browser without my hands!"))
  }

}