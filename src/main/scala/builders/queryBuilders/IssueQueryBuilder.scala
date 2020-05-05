package builders.queryBuilders

import builders.QueryBuilder

case class IssueQueryBuilder(scalars: List[String] = List(),
                        fields: List[QueryBuilder] = List(),
                        connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "issue"

  def modifyTopQuery(queryBuilder: IssueQueryBuilder): IssueQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeAuthor(authorQueryBuilder: RepositoryOwnerQueryBuilder): IssueQueryBuilder = {
    authorQueryBuilder.topQuery = "author"
    val issueQueryBuilder: IssueQueryBuilder = new IssueQueryBuilder(
      this.scalars,
      authorQueryBuilder :: this.fields,
      this.connections
    )
    this.modifyTopQuery(issueQueryBuilder)
  }

  def includeIsClosed(): IssueQueryBuilder = {
    val issueQueryBuilder: IssueQueryBuilder = new IssueQueryBuilder(
      "closed" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(issueQueryBuilder)
  }

  def includeRepository(repositoryQueryBuilder: RepositoryQueryBuilder): IssueQueryBuilder = {
    val issueQueryBuilder: IssueQueryBuilder = new IssueQueryBuilder(
      this.scalars,
      repositoryQueryBuilder :: this.fields,
      this.connections
    )
    this.modifyTopQuery(issueQueryBuilder)
  }

  def includeTitle(): IssueQueryBuilder = {
    val issueQueryBuilder: IssueQueryBuilder = new IssueQueryBuilder(
      "title" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(issueQueryBuilder)
  }

  def includeUrl(): IssueQueryBuilder = {
    val issueQueryBuilder: IssueQueryBuilder = new IssueQueryBuilder(
      "url" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(issueQueryBuilder)
  }

}
