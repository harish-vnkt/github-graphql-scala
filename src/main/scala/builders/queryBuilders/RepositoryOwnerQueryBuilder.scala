package builders.queryBuilders

import builders.QueryBuilder

case class RepositoryOwnerQueryBuilder(scalars: List[String] = List(),
                                       fields: List[QueryBuilder] = List(),
                                       connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "owner"

  def modifyTopQuery(queryBuilder: RepositoryOwnerQueryBuilder): RepositoryOwnerQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeLogin(): RepositoryOwnerQueryBuilder = {
    val repositoryOwnerQueryBuilder: RepositoryOwnerQueryBuilder = new RepositoryOwnerQueryBuilder(
      "login" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryOwnerQueryBuilder)
  }

  def includeUrl(): RepositoryOwnerQueryBuilder = {
    val repositoryOwnerQueryBuilder: RepositoryOwnerQueryBuilder = new RepositoryOwnerQueryBuilder(
      "url" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryOwnerQueryBuilder)
  }

}
