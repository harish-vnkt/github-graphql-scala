package client

import builders.Query
import scalaj.http.Http
import com.google.gson.{Gson, JsonObject}
import client.json.{GsonDeserializer, GsonJsonSerializer, JacksonJsonDeserializer}
import models.objects.{GraphQLObject, Repository, Search, User}
import scala.reflect.runtime.universe._


case class HttpClient(headerPart:Map[String,String]= Map()){

  def executeQuery[T <: GraphQLObject](queryObj:Query)(implicit b:TypeTag[T]):Option[T]={
    val jsonQuery:String = queryObj.getQueryString
    val returnType =  queryObj.getReturnType
    val jsonObj = jsonObjectCreation(jsonQuery)
    val jsonAst = GsonJsonSerializer.build.serialize(jsonObj)
    val response = Http("https://api.github.com/graphql")
      .headers(
        headerPart
      ).postData(jsonAst)
    val responseJson = GsonDeserializer.build.deserialize(response.asString.body)
    if(!responseJson.has("errors")) {
      val data = responseJson.getAsJsonObject("data").getAsJsonObject(returnType)
      val jsonString = GsonJsonSerializer.build.serialize(data)
      returnType match {
        case "repository" => if(b.tpe.toString == "models.objects.Repository"){
          Some(JacksonJsonDeserializer.build.deserialize[Repository](jsonString).asInstanceOf[T])
        }else{
          println("Please provide Repository Type for Casting since the query created is of type Repository")
          None
        }
        case "user" => if(b.tpe.toString == "models.objects.User"){
          Some(JacksonJsonDeserializer.build.deserialize[User](jsonString).asInstanceOf[T])
        }else{
          println("Please provide User Type for Casting since the query created is of type User")
          None
        }
        case "search" => if(b.tpe.toString == "models.objects.Search"){
          Some(JacksonJsonDeserializer.build.deserialize[Search](jsonString).asInstanceOf[T])
        }else{
          println("Please provide Search Type for Casting since the query created is of type Search")
          None
        }
      }
    }
    else{
      println("Build Query in the proper Format")
      None
    }
  }


  private def jsonObjectCreation(jsonString:String)={
    val jsonObj: JsonObject = new JsonObject()
    jsonObj.addProperty("query", jsonString)
    jsonObj
  }

}
