package com.kunyan.htmlparse.cfi

import java.net.URL

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

/**
  * Created by Administrator on 2016/2/29.
  */
object CFIParser {

  val rootPath = "http://www.cfi.net.cn/"
  val cssString = Array("#pagecontent table.ln_fy tbody tr td a",
                    "#pagecontent table.fphead:contains(股讯快递) + table a",
                    "#pagecontent table tr:contains(产经) + tr a",
                    "#pagecontent table.fphead:contains(上市公司) + table a")

  val rootPath2 = "http://industry.cfi.cn/"
  val cssString2 = Array("table.zt tbody > tr div.middle div.toutiao table tbody a",
                    "div.middle div.div2 a",
                    "div.bottoml table > tbody > tr:gt(0) td > div a[href^=p]")

  val rootPath3 = "http://industry.cfi.cn/BCA0A4127A4128A4132.html"
  val cssString3 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath4 = "http://industry.cfi.cn/BCA0A4127A4128A4136.html"
  val cssString4 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath5 = "http://industry.cfi.cn/BCA0A4127A4128A4135.html"
  val cssString5 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath6 = "http://industry.cfi.cn/BCA0A4127A4128A4138.html"
  val cssString6 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath7 = "http://industry.cfi.cn/BCA0A4127A4128A4139.html"
  val cssString7 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath8 = "http://industry.cfi.cn/BCA0A4127A4128A4140.html"
  val cssString8 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath9 = "http://industry.cfi.cn/BCA0A4127A4128A4141.html"
  val cssString9 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath10 = "http://industry.cfi.cn/BCA0A4127A4128A4142.html"
  val cssString10 = Array("table.ziyemian tbody tr > td:eq(2) div.zidiv2 > a")

  val rootPath11 = "http://industry.cfi.cn/BCA0A4127A4128A4143.html"

  val rootPath12 = "http://industry.cfi.cn/BCA0A4127A4128A4144.html"

  val rootPath13 = "http://industry.cfi.cn/BCA0A4127A4128A4137.html"

  val rootPath14 = "http://stock.cfi.cn/"
  val cssString14 = Array("div.zhengtidiv3 > table > tbody > tr:eq(2) > td > a",
                      "div.zhengtidiv3 > table > tbody > tr:eq(3) > td > a",
                      "div.zhengtidiv3 > table > tbody > tr:eq(6) > td > a",
                      "div.zhengtidiv3 > table > tbody > tr:last-child > td > a")

  val rootPath15 = "http://stock.cfi.cn/BCA0A4127A4346A4436.html"
  val cssString15 = Array("table.ziyemian tbody tr td:eq(2) > div.xinwen > a")

  val rootPath16 = "http://stock.cfi.cn/BCA0A4127A4346A4439.html"
  val cssString16 = Array("table.ziyemian tbody tr td:eq(2) > div.xinwen > a")

  val rootPath17 = "http://stock.cfi.cn/BCA0A4127A4346A4442.html" //css is the same as 15



  def main(args: Array[String]) {
    val document = Jsoup.connect(rootPath2).
      header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0").
      get()

    var count = 0
    for(css <- cssString2) {
      val elements = document.select(css)
//      println(elements)
//      if(count == 2) println(elements)
      val size = elements.size()
      if(size == 0) sys.exit(-99)
      val list = new Array[(String, String)](elements.size())
      var i = 0
      for(element <- 0 until elements.size()){

        list(i) = if(count == 0) (elements.get(element).select("img").attr("alt"), formatUrl(rootPath2, elements.get(element).attr("href")))
        else (elements.get(element).text(), formatUrl(rootPath2, elements.get(element).attr("href")))
         if(count == 0) {
           println(elements.get(element))
           println(list(i))
         }
        i += 1
      }

      println(i)

//      list.foreach(println(_))
      println("========================")

      count += 1
    }

  }


  /**
    * 将从 html 网页中取出来的路径统一转为 URL
    *
    * @param url html 网页中取出的路径
    * @return 正规化以后的 URL
    */
  def formatUrl(rootPath: String, url: String): String = {
    if(url.startsWith("http:")) url // 链接是完整的 url 路径
    else if(url.startsWith("/")) {  // 链接是网站的 绝对路径
      val u = new URL(rootPath)
      u.getProtocol + u.getHost + url
    } else { //链接是网站的 相对路径
      val u = rootPath.lastIndexOf("/")
      rootPath.substring(0, u + 1) + url
    }
  }


}
