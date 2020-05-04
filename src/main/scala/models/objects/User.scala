package models.objects

import akka.http.scaladsl.model.DateTime

case class User(company: Option[String], createdAt: DateTime, email: Option[String], login: String, name: String, url: String)
