package builders.queryBuilders

import builders.{PaginationValue, QueryBuilder}

case class RepositoryTopicQueryBuilder(scalars: List[String] = List(),
                                       fields: List[QueryBuilder] = List(),
                                       connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "repositoryTopic"

  def modifyTopQuery(queryBuilder: RepositoryTopicQueryBuilder): RepositoryTopicQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeTopic(topicQueryBuilder: TopicQueryBuilder): RepositoryTopicQueryBuilder = {
    val repositoryTopicQueryBuilder: RepositoryTopicQueryBuilder = new RepositoryTopicQueryBuilder(
      this.scalars,
      topicQueryBuilder :: this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryTopicQueryBuilder)
  }

}
