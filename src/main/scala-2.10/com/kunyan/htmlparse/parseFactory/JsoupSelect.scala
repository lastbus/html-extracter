package com.kunyan.htmlparse.parseFactory

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
  * Created by Administrator on 2016/3/3.
  */
object JsoupSelect {

  def select(bytes: Array[Byte], select: ((String, String, String), Array[(String, String, Boolean)])): Elements = {
    val document = Jsoup.parse(new String(bytes, "UTF-8"))
    val elements = document.select(select._1._2)
    val size = elements.size()
    //判断取出的信息条数是否符合要求
    println(s"\n${size}  ${select._1._3}")
    if (!select._1._3.contains("-")) {
      println(size + "  " + select._1._3)
      if (size != select._1._3.toInt) {
        throw new Exception("dom has changed")
      }
    } else {
      val nums = select._1._3.split("-")
      println(s"${nums(0)}   ${nums(1)}")
      if (elements.size() < nums(0).toInt || elements.size() > nums(1).toInt)
        throw new Exception("dom has changed")
    }

    for (i <- 0 until size) {

      for (field <- select._2) {
        //取 html 元素的 文本 或者 属性值
        val text =
          if (field._1.equalsIgnoreCase("text")) {
            elements.get(i).text()
          } else if (field._1.startsWith("attr:")) {
            elements.get(i).attr(field._1.split(":")(1))
          } else {
            throw new Exception(s"cannot parse ${field._1}")
          }
//        println(text)
      }

    }

    elements
  }

  /**
    * 将取出的文本正规化。
    * 由于这部分逻辑较为复杂，需要单独处理！！！
    * @param text
    */
  def formatText(command: String, text: String*): String ={
    if(command.equalsIgnoreCase("url")){
      if(text.size != 2) throw new Exception("wrong parameters while formatText.")
      formatURL(text(1), text(2))
    } else {
      ""
    }
  }

  /**
    * format url
    * @param rootPath
    * @param relativeURL
    * @return
    */
  def formatURL(rootPath: String, relativeURL: String): String ={
    if(relativeURL.startsWith(rootPath)) relativeURL
    else if(relativeURL.startsWith("/")) rootPath + relativeURL.substring(1)
    else rootPath + relativeURL
  }
}
