package models.objects

import models.connections.UserConnection

case class Topic(name: String, starGazers: UserConnection) extends GraphQLObject{

  def getTopicName: String = name

  def getStarGazerDetails: UserConnection = starGazers
}