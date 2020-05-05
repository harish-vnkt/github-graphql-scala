package models.objects

case class Search(nodes: List[Repository], pageInfo: PageInfo) extends GraphQLObject {

  def getPageInfo: PageInfo = pageInfo

}