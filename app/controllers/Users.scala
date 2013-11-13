package controllers

/**
 *
 * @author Manuel Bernhardt <manuel@bernhardt.io>
 */
class Users(greeting: String) extends BaseController {

  def hello = Action { implicit request =>
  	Ok(greeting)
  }

}
