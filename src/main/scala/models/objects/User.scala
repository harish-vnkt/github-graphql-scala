package models.objects

import models.connections.{RepositoryConnection, UserConnection}

case class User(company: Option[String], createdAt: String, email: Option[String], login: String, name: String, url: String,
                followers: UserConnection, following: UserConnection, repositories: RepositoryConnection) extends GraphQLObject{

  def getCompanyName:Option[String] = company

  def getCreatedDate : String = createdAt

  def getUserEmail : Option[String] = email

  def getUserLoginName : String = login

  def getUserName : String = name

  def getUserHttpUrl : String = url

  def getFollowers : UserConnection = followers

  def getFollowing : UserConnection = following

  def getRepositories : RepositoryConnection = repositories
}