package com.kunyan.htmlparse.hexun

import org.jsoup.Jsoup

/**
  * Created by Administrator on 2016/2/26.
  */
object Parser {

  def main(args: Array[String]): Unit ={
    val doc = Jsoup.connect("http://www.hexun.com/").get()

    val element = doc.select("#main .content > div:eq(5) > div:eq(1) ul:eq(0)")
    println(element)

  }
}
