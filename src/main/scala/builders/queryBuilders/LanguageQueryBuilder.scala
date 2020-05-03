package builders.queryBuilders

import builders.QueryBuilder

case class LanguageQueryBuilder(scalars: List[String] = List(),
                             fields: List[QueryBuilder] = List(),
                             connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "language"

  def modifyTopQuery(queryBuilder: RepositoryOwnerQueryBuilder): RepositoryOwnerQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeName(): RepositoryOwnerQueryBuilder = {
    val languageQueryBuilder: RepositoryOwnerQueryBuilder = new RepositoryOwnerQueryBuilder(
      "name" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(languageQueryBuilder)
  }

  def includeColor(): RepositoryOwnerQueryBuilder = {
    val languageQueryBuilder: RepositoryOwnerQueryBuilder = new RepositoryOwnerQueryBuilder(
      "color" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(languageQueryBuilder)
  }

}
