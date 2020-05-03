package client.json
import com.google.gson.{Gson, JsonObject}

class GsonSerializeParser(gson:Gson) extends JsonSerializeParser {

  override def serializer(jsonObj:JsonObject):String= gson.toJson(jsonObj)


}

object GsonSerializeParser{

  def build:GsonSerializeParser={
    val gson = new Gson()
    new GsonSerializeParser(gson)
  }
}
