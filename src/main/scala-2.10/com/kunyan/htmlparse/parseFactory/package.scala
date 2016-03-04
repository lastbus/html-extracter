package com.kunyan.htmlparse

import java.net.URL

/**
  * Created by Administrator on 2016/3/4.
  */
package object parseFactory {


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
      u.getProtocol + "://"+ u.getHost + url
    } else { //链接是网站的 相对路径
    val u = rootPath.lastIndexOf("/")
      rootPath.substring(0, u + 1) + url
    }

}
