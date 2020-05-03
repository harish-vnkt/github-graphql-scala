package client.json

import com.google.gson.JsonObject

trait JsonSerializeParser {

  def serializer(jsonObj:JsonObject):String

}
