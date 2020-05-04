package models.objects

case class Issue(author: User, closed: Boolean, repository: Repository, title: String, url: String) extends GraphQLObject
