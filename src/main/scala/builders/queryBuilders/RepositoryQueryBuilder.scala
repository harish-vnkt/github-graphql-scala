package builders.queryBuilders

import builders.QueryBuilder

case class RepositoryQueryBuilder(scalars: List[String] = List(),
                                  fields: List[QueryBuilder] = List(),
                                  connections: List[QueryBuilder] = List()) extends QueryBuilder {

  override var topQuery: String = "repository"

  def modifyTopQuery(queryBuilder: RepositoryQueryBuilder): RepositoryQueryBuilder = {
    queryBuilder.topQuery = this.topQuery
    queryBuilder
  }

  def includeName(): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      "name" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeUrl(): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      "url" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeDateTime(): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      "createdAt" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeIsFork(): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      "isFork" :: this.scalars,
      this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeOwner(repositoryOwnerQueryBuilder: RepositoryOwnerQueryBuilder): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      repositoryOwnerQueryBuilder :: this.fields,
      this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeForks(forkQueryBuilder: RepositoryQueryBuilder): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      forkQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeIssues(issueQueryBuilder: IssueQueryBuilder): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      issueQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeLanguages(languageQueryBuilder: RepositoryOwnerQueryBuilder): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      languageQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeRepositoryTopics(
                               repositoryTopicQueryBuilder: RepositoryTopicQueryBuilder
                             ): RepositoryQueryBuilder = {
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      repositoryTopicQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

}

