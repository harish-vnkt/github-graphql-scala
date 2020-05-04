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

//  def searchRepositories(
//                          searchCriteriaBuilder: SearchCriteriaBuilder,
//                          after: String
//                        ): Query = {
//    if (!after.equals("")) {
//      searchCriteriaBuilder = searchCriteriaBuilder.setAfter(after)
//    }
//    val queryObject = new Query("query { " + searchCriteriaBuilder.construct() + " }")
//    queryObject.returnType = "search"
//  }

}
