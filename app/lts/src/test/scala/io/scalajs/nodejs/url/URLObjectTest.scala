package io.scalajs.nodejs.url

import io.scalajs.util.JSONHelper._
import io.scalajs.util.JsUnderOrHelper._
import org.scalatest.FunSpec

/**
  * URLObject Tests
  * @author lawrence.daniels@gmail.com
  */
class URLObjectTest extends FunSpec {

  describe("URLObject") {

    val originalUrl = "https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"
    val urlObject = URL.parse(originalUrl)

    it("should break down URLs into components") {
      assert(
        urlObject.toJson == """{"protocol":"https:","slashes":true,"auth":null,"host":"www.google.com","port":null,"hostname":"www.google.com","hash":"#q=node","search":"?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","query":"sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","pathname":"/webhp","path":"/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8","href":"https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=node"}""")
    }

    it("should be properly extracted") {
      assert(urlObject.query ?== "sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8")
    }

    it("should properly extract the search query") {
      assert(urlObject.search ?== "?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8")
    }

    it("should reconstituted the URL to match the original") {
      assert(URL.format(urlObject) == originalUrl)
    }

  }

}
