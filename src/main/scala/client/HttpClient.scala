package client

import builders.Query
import scalaj.http.Http
import com.google.gson.{Gson, JsonObject}
import client.json.{GsonDeserializer, GsonJsonSerializer, JacksonJsonDeserializer}
import models.objects.{GraphQLObject, Repository, Search, User}

case class HttpClient(headerPart:Map[String,String]= Map()){

  def executeQuery[T](queryObj:Query):T={
    val jsonQuery:String = queryObj.getQueryString
    val returnType =  queryObj.getReturnType
    val jsonObj = jsonObjectCreation(jsonQuery)
    val jsonAst = GsonJsonSerializer.build.serialize(jsonObj)
    val response = Http("https://api.github.com/graphql")
      .headers(
        headerPart
      ).postData(jsonAst)
    val responseJson = GsonDeserializer.build.deserialize(response.asString.body)
    val data = responseJson.getAsJsonObject("data").getAsJsonObject(returnType)
    val jsonString = GsonJsonSerializer.build.serialize(data)
    returnType match {
      case "repository" => JacksonJsonDeserializer.build.deserialize[Repository](jsonString).asInstanceOf[T]
      case "user" => JacksonJsonDeserializer.build.deserialize[User](jsonString).asInstanceOf[T]
      case "search" => JacksonJsonDeserializer.build.deserialize[Search](jsonString).asInstanceOf[T]
    }


  }

  private def jsonObjectCreation(jsonString:String)={
    val jsonObj: JsonObject = new JsonObject()
    jsonObj.addProperty("query", jsonString)
    jsonObj
  }

}
