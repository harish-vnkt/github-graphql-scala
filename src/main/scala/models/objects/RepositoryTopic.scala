package models.objects

case class RepositoryTopic(topic: Topic) extends GraphQLObject {

  def getTopic: Topic = topic

}
