package de.alexholly.util.http

/**
 * Created by alex on 10.11.15.
 */

import com.ning.http.client.{ AsyncHttpClientConfigBean }
import play.api.libs.json.JsValue
import play.api.libs.ws.{ WSCookie, WSResponse }
import play.api.libs.ws.ning.NingWSClient
import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._
import scala.xml.Elem

object HttpSync {
  val config = new AsyncHttpClientConfigBean().setAcceptAnyCertificate(true)
  val client = new NingWSClient(config)
  //  val header = ("content-type" -> "application/json")

  //GET
  def get(_url: String, timeout: Int): WSResponse = {
    handle(client.url(_url).get(), timeout)
  }

  def get(_url: String, timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).get(), timeout)
  }

  //POST
  def post(_url: String, timeout: Int): WSResponse = {
    handle(client.url(_url).post(""), timeout)
  }

  def post(_url: String, timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).post(""), timeout)
  }
  def post(_url: String, body: String, timeout: Int): WSResponse = {
    handle(client.url(_url).post(body), timeout)
  }

  def post(_url: String, body: String, timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).post(body), timeout)
  }

  def post(_url: String, params: Map[String, Seq[String]], timeout: Int): WSResponse = {
    handle(client.url(_url).post(params), timeout)
  }

  def post(_url: String, params: Map[String, Seq[String]], timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).post(params), timeout)
  }

  //PUT
  def put(_url: String, timeout: Int): WSResponse = {
    handle(client.url(_url).put(""), timeout)
  }

  def put(_url: String, timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).put(""), timeout)
  }

  def put(_url: String, body: String, timeout: Int): WSResponse = {
    handle(client.url(_url).put(body), timeout)
  }

  def put(_url: String, body: String, timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).put(body), timeout)
  }

  def put(_url: String, params: Map[String, Seq[String]], timeout: Int): WSResponse = {
    handle(client.url(_url).put(params), timeout)
  }

  def put(_url: String, params: Map[String, Seq[String]], timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).put(params), timeout)
  }

  //DELETE
  def delete(_url: String, timeout: Int): WSResponse = {
    handle(client.url(_url).delete(), timeout)
  }

  def delete(_url: String, timeout: Int, header: (String, String)): WSResponse = {
    handle(client.url(_url).withHeaders(header).delete(), timeout)
  }

  //Make it Synchronized
  def handle(request: Future[WSResponse], timeout: Int): WSResponse = {
    try {
      Await.result(request, Duration(timeout, MILLISECONDS))
    } catch {
      case e: Throwable => println(e); Timeout()
    }
  }

  case class Timeout() extends WSResponse {
    var status = 408

    override def allHeaders: Map[String, Seq[String]] = ???

    override def statusText: String = "408"

    override def underlying[T]: T = ???

    override def xml: Elem = ???

    override def body: String = ???

    override def header(key: String): Option[String] = ???

    override def cookie(name: String): Option[WSCookie] = ???

    override def bodyAsBytes: Array[Byte] = ???

    override def cookies: Seq[WSCookie] = ???

    override def json: JsValue = ???
  }
}
