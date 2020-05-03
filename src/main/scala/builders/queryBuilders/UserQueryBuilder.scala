package builders.queryBuilders

import builders.QueryBuilder

class UserQueryBuilder(scalars: List[String] = List(),
                        fields: List[QueryBuilder] = List(),
                        connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "user"

  def modifyTopQuery(queryBuilder: UserQueryBuilder): UserQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeCompany(): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      "company" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeCreatedAt(): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      "createdAt" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeEmail(): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      "email" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeLogin(): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      "login" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeName(): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      "name" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeUrl(): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      "url" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeFollowing(followingQueryBuilder: UserQueryBuilder): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      this.scalars,
      this.fields,
      followingQueryBuilder :: this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeFollowers(followersQueryBuilder: UserQueryBuilder): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      this.scalars,
      this.fields,
      followersQueryBuilder :: this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

  def includeRepositories(repositoryQueryBuilder: RepositoryQueryBuilder): UserQueryBuilder = {
    val userQueryBuilder: UserQueryBuilder = new UserQueryBuilder(
      this.scalars,
      this.fields,
      repositoryQueryBuilder :: this.connections
    )
    this.modifyTopQuery(userQueryBuilder)
  }

}
