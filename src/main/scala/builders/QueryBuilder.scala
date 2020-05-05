package builders

trait QueryBuilder {

  def scalars: List[String]
  def fields: List[QueryBuilder]
  def connections: List[QueryBuilder]

  var topQuery: String

  def construct(): String = {

    var returnString: String = topQuery + " {"

    for (scalar <- this.scalars) {
      returnString = returnString + " " + scalar
    }

    for (field <- this.fields) {
      returnString = returnString + " " + field.construct()
    }

    for (connection <- this.connections) {
      connection.topQuery = connection.topQuery + " { nodes"
      returnString = returnString + " " + connection.construct()
      returnString = returnString + " }"
    }

    returnString + " }"
  }

}
