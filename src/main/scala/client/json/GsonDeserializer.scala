package client.json

import com.google.gson.{Gson, JsonObject}


class GsonDeserializer(gson:Gson){

  def deserialize(json: String): JsonObject = gson.fromJson(json,classOf[JsonObject])

}

object GsonDeserializer{

  def build:GsonDeserializer={
    val gson = new Gson()
    new GsonDeserializer(gson)
  }
}