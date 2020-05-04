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
    val queryObject = new Query("query { " + repositoryQueryBuilder.construct() + " }")
    queryObject.returnType = "repository"
    queryObject
  }

}
