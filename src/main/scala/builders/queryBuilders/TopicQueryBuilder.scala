package builders.queryBuilders

import builders.{PaginationValue, QueryBuilder}

case class TopicQueryBuilder(scalars: List[String] = List(),
                             fields: List[QueryBuilder] = List(),
                             connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "topic"

  def modifyTopQuery(queryBuilder: TopicQueryBuilder): TopicQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeName(): TopicQueryBuilder = {
    val topicQueryBuilder: TopicQueryBuilder = new TopicQueryBuilder(
      "name" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(topicQueryBuilder)
  }

  def includeStargazers(
                         stargazerQueryBuilder: UserQueryBuilder,
                         numberOfResults: PaginationValue
                       ): TopicQueryBuilder = {
    stargazerQueryBuilder.topQuery = "stargazers" + s"(${numberOfResults.argument})"
    val topicQueryBuilder: TopicQueryBuilder = new TopicQueryBuilder(
      this.scalars,
      this.fields,
      stargazerQueryBuilder :: this.connections
    )
    this.modifyTopQuery(topicQueryBuilder)
  }
}
