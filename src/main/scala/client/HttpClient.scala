package client

import builders.Query
import scalaj.http.Http
import com.google.gson.{Gson, JsonObject}
import client.json.{GsonDeserializer, GsonJsonSerializer, JacksonJsonDeserializer}
import models.objects.{GraphQLObject, Repository, Search, User}



case class HttpClient(headerPart:Map[String,String]= Map()){

  def executeQuery[T <: GraphQLObject](queryObj:Query):Option[T]={
    val jsonQuery:String = queryObj.getQueryString
    val returnType =  queryObj.getReturnType
    val jsonObj = jsonObjectCreation(jsonQuery)
    val jsonAst = GsonJsonSerializer.build.serialize(jsonObj)
    val response = Http("https://api.github.com/graphql")
      .headers(
        headerPart
      ).postData(jsonAst)
    println(response.asString.body)
    val responseJson = GsonDeserializer.build.deserialize(response.asString.body)
    if(!responseJson.has("errors")) {
      val data = responseJson.getAsJsonObject("data").getAsJsonObject(returnType)
      val jsonString = GsonJsonSerializer.build.serialize(data)
      returnType match {
        case "repository" => Some(JacksonJsonDeserializer.build.deserialize[Repository](jsonString).asInstanceOf[T])
        case "user" => Some(JacksonJsonDeserializer.build.deserialize[User](jsonString).asInstanceOf[T])
        case "search" => Some(JacksonJsonDeserializer.build.deserialize[Search](jsonString).asInstanceOf[T])
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
