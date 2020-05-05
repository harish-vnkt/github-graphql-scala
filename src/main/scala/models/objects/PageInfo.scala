package models.objects

case class PageInfo(endCursor: String) extends GraphQLObject {

  def getEndCursor: String = endCursor

}
