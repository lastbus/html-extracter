package com.kunyan.htmlparse.parseFactory

import org.jsoup.select.Elements

/**
  * Created by Administrator on 2016/3/3.
  */
object HtmlCleanerSelect {

  def select[T](t: T, select: String): Array[T] = {
    val doc = t.asInstanceOf[Elements]
    doc.select(select).toArray().asInstanceOf[Array[T]]
  }
}
