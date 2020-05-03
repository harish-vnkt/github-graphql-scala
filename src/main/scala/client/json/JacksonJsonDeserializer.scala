package client.json

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.{DefaultScalaModule, ScalaObjectMapper}

/**
 * The simple readValue API of the ObjectMapper+ScalaObjectMapper is a good entry point.
 * We are using it to parse or deserialize JSON content into a Scala object.
 */
class JacksonJsonDeserializer(val mapper: ObjectMapper with ScalaObjectMapper) extends JsonDeserializer{

  /**
   *
   * @param json
   * @tparam T the scala case class that is passed to which the json string is deserialized
   * @return The object of the case class to which the json parts are mapped
   */
  override def deserialize[T:Manifest](json: String): T = {
    mapper.readValue[T](json)
  }
}

object JacksonJsonDeserializer{

  def build:JacksonJsonDeserializer={
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    new JacksonJsonDeserializer(mapper)
  }
}
