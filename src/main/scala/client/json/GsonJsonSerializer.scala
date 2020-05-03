package client.json
import com.google.gson.{Gson, JsonObject}

class GsonSerializer(gson:Gson) extends JsonSerializer {

  override def serializer(jsonObj:JsonObject):String= gson.toJson(jsonObj)


}

object GsonSerializer{

  def build:GsonSerializer={
    val gson = new Gson()
    new GsonSerializer(gson)
  }
}
