package builders.queryBuilders

import builders.{PaginationValue, QueryBuilder}

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

  def includeForks(
                    forkQueryBuilder: RepositoryQueryBuilder,
                    numberOfResults: PaginationValue
                  ): RepositoryQueryBuilder = {
    forkQueryBuilder.topQuery = "forks" + s"(${numberOfResults.argument})"
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      forkQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeIssues(
                     issueQueryBuilder: IssueQueryBuilder,
                     numberOfResults: PaginationValue
                   ): RepositoryQueryBuilder = {
    issueQueryBuilder.topQuery = "issues" + s"(${numberOfResults.argument})"
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      issueQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeLanguages(
                        languageQueryBuilder: RepositoryOwnerQueryBuilder,
                        numberOfResults: PaginationValue
                      ): RepositoryQueryBuilder = {
    languageQueryBuilder.topQuery = "languages" + s"(${numberOfResults.argument})"
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      languageQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

  def includeRepositoryTopics(
                               topicQueryBuilder: RepositoryTopicQueryBuilder,
                               numberOfResults: PaginationValue
                             ): RepositoryQueryBuilder = {
    topicQueryBuilder.topQuery = "repositoryTopics" + s"(${numberOfResults.argument})"
    val repositoryQueryBuilder: RepositoryQueryBuilder = new RepositoryQueryBuilder(
      this.scalars,
      this.fields,
      topicQueryBuilder :: this.connections
    )
    this.modifyTopQuery(repositoryQueryBuilder)
  }

}

