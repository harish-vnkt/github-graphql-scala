package models.objects

case class Language(color: String, name: String) extends GraphQLObject{

  def getDefinedColor: String = color

  def getLanguageName : String = name
}