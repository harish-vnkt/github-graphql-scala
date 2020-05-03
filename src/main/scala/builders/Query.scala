package builders

import builders.queryBuilders.RepositoryQueryBuilder

case class Query(queryString: String) {

  def getQueryString: String = this.queryString

  def findRepository(
                      name: String,
                      owner: String,
                      repositoryQueryBuilder: RepositoryQueryBuilder
                    ): Query = {
    repositoryQueryBuilder.topQuery = repositoryQueryBuilder.topQuery +
      s"(name: \"$name\", owner: \"$owner\")"
    new Query(repositoryQueryBuilder.construct())
  }

}
