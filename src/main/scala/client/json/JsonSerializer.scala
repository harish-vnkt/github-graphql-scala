package client.json

import com.google.gson.JsonObject

trait JsonSerializer {

  def serialize(jsonObj:JsonObject):String

}
