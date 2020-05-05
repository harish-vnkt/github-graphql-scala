package builders.queryBuilders

import builders.QueryBuilder

case class LanguageQueryBuilder(scalars: List[String] = List(),
                             fields: List[QueryBuilder] = List(),
                             connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "language"

  def modifyTopQuery(queryBuilder: LanguageQueryBuilder): LanguageQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeName(): LanguageQueryBuilder = {
    val languageQueryBuilder: LanguageQueryBuilder = new LanguageQueryBuilder(
      "name" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(languageQueryBuilder)
  }

  def includeColor(): LanguageQueryBuilder = {
    val languageQueryBuilder: LanguageQueryBuilder = new LanguageQueryBuilder(
      "color" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(languageQueryBuilder)
  }

}
