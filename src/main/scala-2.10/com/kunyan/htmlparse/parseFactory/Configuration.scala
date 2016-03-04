package com.kunyan.htmlparse.parseFactory

import scala.collection.mutable
import scala.xml.XML

/**
  * Created by make on 2016/3/3.
  */
object Configuration {

  // key is website's URL, first tuple of value is Jsoup/xpath, query string and result number,
  // other is the way to extract the data, the-field-mapping-class and whether is needed.
  private val urlMaps = mutable.Map.empty[String, (String, (String, String, String), Array[(String, String, Boolean)])]

  def loadConfiguration(path: String): Unit = {
    val xml = XML.load(path)

    val root = xml.attribute("test").get.text.toBoolean
    println(root)

    val urls = xml \ "url"
    for (url <- urls) {
      val urlString = (url \ "@value").text
      // 一个网站有几个数据块
      val blockData = url \ "query-string"
      for (block <- blockData) {
        val parseEngine = (block \ "@type").text
        val number = (block \ "@num").text
        val mappingClass = (block \ "mapping-class").text
        val mappingFields = block \ "extract"
        val queryValue = (block \ "value").text

        val selectElement = (mappingClass, queryValue, number)
        val fieldsArray = new Array[(String, String, Boolean)](mappingFields.size)

        for (i <- 0 until mappingFields.size) {
          val extractType = (mappingFields(i) \ "@type").text
          val mapToField = (mappingFields(i) \ "@field").text
          val notNull = (mappingFields(i) \ "@must").text
          fieldsArray(i) = (extractType, mapToField, if (notNull.length > 0) notNull.toBoolean else false)
        }
        urlMaps(urlString) = (parseEngine, selectElement, fieldsArray)
      }
    }

  }

  def getUrlMaps = urlMaps

}
