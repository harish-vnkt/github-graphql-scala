package models.objects

import models.connections.{IssueConnection, LanguageConnection, RepositoryConnection, TopicConnection}

case class Repository(name: String, owner: RepositoryOwner, url: String, createdAt: String, isFork: Boolean,
                      forks: RepositoryConnection, issues: IssueConnection,
                      languages: LanguageConnection, repositoryTopics: TopicConnection) extends GraphQLObject {

  def getUrl: String = url

  def getRepositoryName:String = name

  def getOwner:RepositoryOwner = owner

  def getCreatedAt : String = createdAt

  def getIsFork : Boolean= isFork

  def getForks : RepositoryConnection = forks

  def getIssues : IssueConnection = issues

  def getLanguages : LanguageConnection = languages

  def getRepositoryTopics : TopicConnection = repositoryTopics


}