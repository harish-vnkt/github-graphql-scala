package models.connections

import models.objects.User

case class UserConnection(val nodes:List[User]) extends Connection[User]