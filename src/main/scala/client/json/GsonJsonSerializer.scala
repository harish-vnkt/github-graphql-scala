package client.json
import com.google.gson.{Gson, JsonObject}

class GsonJsonSerializer(gson:Gson) extends JsonSerializer {

  override def serialize(jsonObj:JsonObject):String= gson.toJson(jsonObj)


}

object GsonJsonSerializer{

  def build:GsonJsonSerializer={
    val gson = new Gson()
    new GsonJsonSerializer(gson)
  }
}
