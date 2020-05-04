package models.objects

import akka.http.scaladsl.model.DateTime

case class Repository(name: String, owner: RepositoryOwner, url: String, createdAt: DateTime, isFork: Boolean)
