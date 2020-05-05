package models.objects

case class Issue(author: User, closed: Boolean, repository: Repository, title: String, url: String) extends GraphQLObject{
  def getAuthorDetails : User = author

  def getIsIssueClosed : Boolean = closed

  def getRepositoryDetails: Repository = repository

  def getIssueTitle: String = title

  def getHttpUrl: String = url

}