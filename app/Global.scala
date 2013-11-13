import controllers.Users
import play.api.GlobalSettings

/**
 *
 * @author Manuel Bernhardt <manuel@bernhardt.io>
 */
object Global extends GlobalSettings {

  override def getControllerInstance[A](controllerClass: Class[A]): A = {

    val USERS = classOf[Users]

    val instance = controllerClass match {
      case USERS => new Users("Hello users")
      case _ => super.getControllerInstance(controllerClass)
    }

    instance.asInstanceOf[A]
  }
}
