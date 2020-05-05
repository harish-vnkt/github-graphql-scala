package client
import scalaj.http.Http

class HttpClientBuilder[HttpComponents <: HttpClientBuilder.HttpComponents](parts: Map[String, String] = Map(("Content-Type" -> "application/json"), ("Accept" -> "application/json"))) {

  import HttpClientBuilder.HttpComponents._


  def addBearerToken(token: String): HttpClientBuilder[HttpComponents with HttpToken] = {
    val map = parts + ("Authorization"->("Bearer "+token))
    new HttpClientBuilder(map)
  }

  def build(implicit ev: HttpComponents =:= HttpCall): Option[HttpClient] ={
    val response:Int = Http("https://api.github.com/graphql")
      .headers(
        parts
      ).postData("").asString.code
    response match {
      case 200 => Some(HttpClient(parts))
      case _ => {
        println("Please provide a proper Token!!!")
        None
      }
    }

  }


}

object HttpClientBuilder {

  sealed trait HttpComponents

  object HttpComponents {

    sealed trait HttpToken extends HttpComponents

    sealed trait HttpEmpty extends HttpComponents

    type HttpCall = HttpEmpty with HttpToken
  }

}
