package models.objects

import akka.http.scaladsl.model.DateTime
import models.connections.{IssueConnection, LanguageConnection, RepositoryConnection, TopicConnection}

case class Repository(name: String, owner: RepositoryOwner, url: String, createdAt: DateTime, isFork: Boolean,
                      forks: RepositoryConnection, issues: IssueConnection,
                      languages: LanguageConnection, repositoryTopics: TopicConnection) extends GraphQLObject
