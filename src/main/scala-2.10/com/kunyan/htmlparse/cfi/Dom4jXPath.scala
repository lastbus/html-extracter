package com.kunyan.htmlparse.cfi

import java.net.URL

import org.dom4j.io.SAXReader

/**
  * Created by Administrator on 2016/3/2.
  */
object Dom4jXPath extends App{

  val document = (new SAXReader()).read(new URL("http://www.news.cn/fortune/"))
  val h2 = document.valueOf("h2")

}
