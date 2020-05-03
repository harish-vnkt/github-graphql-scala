package client.json

import com.google.gson.JsonObject

trait JsonSerializeParser {

  def serialize(jsonObj:JsonObject):String

}
