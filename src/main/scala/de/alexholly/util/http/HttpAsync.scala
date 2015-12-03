package de.alexholly.util.http

/**
 * Created by alex on 10.11.15.
 */

import com.ning.http.client.AsyncHttpClientConfigBean
import play.api.libs.ws.WSResponse
import play.api.libs.ws.ning.NingWSClient
import scala.concurrent.Future

object HttpAsync {
  val config = new AsyncHttpClientConfigBean().setAcceptAnyCertificate(true)
  val client = new NingWSClient(config)
  //  val header = ("content-type" -> "application/json")

  //GET
  def get(_url: String): Future[WSResponse] = {
    client.url(_url).get()
  }

  def get(_url: String, header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).get()
  }

  //POST
  def post(_url: String): Future[WSResponse] = {
    client.url(_url).post("")
  }

  def post(_url: String, header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).post("")
  }

  def post(_url: String, body: String): Future[WSResponse] = {
    client.url(_url).post(body)
  }

  def post(_url: String, body: String, header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).post(body)
  }

  def post(_url: String, params: Map[String, Seq[String]]): Future[WSResponse] = {
    client.url(_url).post(params)
  }

  def post(_url: String, params: Map[String, Seq[String]], header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).post(params)
  }

  //PUT
  def put(_url: String): Future[WSResponse] = {
    client.url(_url).put("")
  }

  def put(_url: String, header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).put("")
  }

  def put(_url: String, body: String): Future[WSResponse] = {
    client.url(_url).put(body)
  }

  def put(_url: String, body: String, header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).put(body)
  }

  def put(_url: String, params: Map[String, Seq[String]]): Future[WSResponse] = {
    client.url(_url).put(params)
  }

  def put(_url: String, params: Map[String, Seq[String]], header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).put(params)
  }

  //DELETE
  def delete(_url: String): Future[WSResponse] = {
    client.url(_url).delete()
  }

  def delete(_url: String, header: (String, String)): Future[WSResponse] = {
    client.url(_url).withHeaders(header).delete()
  }
}
