package controllers

import play.api._
import play.api.mvc._

object Application extends BaseController {

  def index = Action {
    Ok(views.html.index("Look ma, refreshing the browser without my hands!"))
  }

  def methodOnOneLine = Action { request => Ok("Well, this one's going to be a rather long line and fail the ScalaStyle check") }

}