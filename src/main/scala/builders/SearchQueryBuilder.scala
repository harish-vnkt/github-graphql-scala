package builders

import builders.queryBuilders.RepositoryQueryBuilder

case class SearchQueryBuilder(
                               numberOfResults: PaginationValue,
                               connections: List[QueryBuilder] = List(),
                               queryString: String = "",
                               after: String = ""
                             ) {

  private var typeString: String = "type:REPOSITORY"

  private var afterString: String = s"""after: \"$after\""""

  def construct(): String = {

    var returnString: String =
      s"""search(query: \"$queryString\", $typeString, ${numberOfResults.argument}"""

    if (!this.after.equals("")) {
      returnString = returnString + s", $afterString"
    }

    returnString = returnString + ") {"

    for (connection <- this.connections) {
      returnString = returnString + " nodes { " + connection.construct() + " }"
    }

    returnString = returnString + " }"
    returnString
  }

  def setSearchTerms(terms: String*): SearchQueryBuilder = {
    var newString: String = this.queryString
    for (term <- terms) {
      newString = newString + " " + term
    }
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setSearchInContent(contents: SearchQueryBuilder.Content*): SearchQueryBuilder = {
    var newString = this.queryString + " in:"
    for (content <- contents) {
      newString = newString + content + ","
    }
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setSearchInUser(userName: String): SearchQueryBuilder = {
    var newString = this.queryString + s" user:$userName"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setSearchInOrg(orgName: String): SearchQueryBuilder = {
    var newString = this.queryString + s" org:$orgName"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setNumberOfFollowers(operation: Operation): SearchQueryBuilder = {
    var newString = this.queryString + s" followers:${operation.argument}"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setNumberOfForks(operation: Operation): SearchQueryBuilder = {
    var newString = this.queryString + s" forks:${operation.argument}"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setNumberOfStars(operation: Operation): SearchQueryBuilder = {
    var newString = this.queryString + s" stars:${operation.argument}"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setLanguages(languages: String*): SearchQueryBuilder = {
    var newString = this.queryString + " language:"
    for (language <- languages) {
      newString = newString + language + ","
    }
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setTopic(topic: String): SearchQueryBuilder = {
    var newString = this.queryString + s" topic:$topic"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setNumberOfTopics(operation: Operation): SearchQueryBuilder = {
    var newString = this.queryString + s" topics:${operation.argument}"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def setPublicOrPrivate(access: SearchQueryBuilder.Access): SearchQueryBuilder = {
    var newString = this.queryString + s" is:$access"
    new SearchQueryBuilder(
      this.numberOfResults,
      this.connections,
      newString,
      this.after
    )
  }

  def includeRepository(repositoryQueryBuilder: RepositoryQueryBuilder): SearchQueryBuilder = {
    repositoryQueryBuilder.topQuery = "... on Repository"
    val searchQueryBuilder = new SearchQueryBuilder(
      this.numberOfResults,
      repositoryQueryBuilder :: this.connections,
      this.queryString,
      this.after
    )
    searchQueryBuilder
  }

}

case object SearchQueryBuilder {

  type Content = String
  val NAME: Content = "name"
  val DESCRIPTION: Content = "description"
  val README: Content = "readme"

  type Access = String
  val PUBLIC: Access = "public"
  val PRIVATE: Access = "private"

}
