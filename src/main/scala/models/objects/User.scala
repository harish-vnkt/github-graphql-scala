package models.objects

import akka.http.scaladsl.model.DateTime
import models.connections.{RepositoryConnection, UserConnection}

case class User(company: Option[String], createdAt: DateTime, email: Option[String], login: String, name: String, url: String,
               followers: UserConnection, following: UserConnection, repositories: RepositoryConnection) extends GraphQLObject
