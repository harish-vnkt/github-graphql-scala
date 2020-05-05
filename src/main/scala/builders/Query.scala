package builders

import builders.queryBuilders.RepositoryQueryBuilder

case class Query(queryString: String = "") {

  var returnType: String = ""

  def getQueryString: String = this.queryString

  def getReturnType: String = this.returnType

  def findRepository(
                      name: String,
                      owner: String,
                      repositoryQueryBuilder: RepositoryQueryBuilder
                    ): Query = {
    repositoryQueryBuilder.topQuery = repositoryQueryBuilder.topQuery +
      s"""(name:\"$name\", owner:\"$owner\")"""
    val queryObject = new Query("{ " + repositoryQueryBuilder.construct() + " }")
    queryObject.returnType = "repository"
    queryObject
  }

  def searchRepositories(searchQueryBuilder: SearchQueryBuilder): Query = {
    val queryObject = new Query("{ " + searchQueryBuilder.construct() + " }")
    queryObject.returnType = "search"
    queryObject
  }

}
