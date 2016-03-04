package com.kunyan.htmlparse.cfi

import org.jsoup.Jsoup

/**
  * Created by Administrator on 2016/2/29.
  */
object NthOfChild  extends App{

  val document = Jsoup.connect("http://stock.cfi.cn/BCA0A4127A4346A4436.html").
    header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0").get()
  println(document.select("b").text())
  println(document.select("b").text().length)


}
