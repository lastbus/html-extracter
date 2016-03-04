package com.kunyan.htmlparse.parseFactory

import java.net.{HttpURLConnection, URL}
import javax.xml.parsers.{DocumentBuilderFactory, DocumentBuilder}


import scala.collection.mutable.ArrayBuffer
import scala.xml.XML

/**
  * Created by Administrator on 2016/3/3.
  */
object Main {

  def main(args: Array[String]): Unit = {
    // load configuration file
    val absPath = this.getClass.getResource(".").getPath + "url.xml"
    Configuration.loadConfiguration(absPath)

    val maps = Configuration.getUrlMaps
    val url = "http://www.cfi.net.cn"
    for((key, value) <- maps){
      println(key)
      println(value._1)
      println(value._2)
      value._3.foreach(print(_))
    }
    val bytes = getWebBytes(url)
//    println(new String(bytes))

    val result = SelectContext.select(bytes, maps(url))






  }

  def getWebBytes(url: String): Array[Byte] ={
    val u = new URL(url)
    val httpConnection = u.openConnection().asInstanceOf[HttpURLConnection]
    httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0")
    val reader = httpConnection.getInputStream
    val byteBuffer = new ArrayBuffer[Byte]()
    var oneByte = 0
    if(reader.available() > 0){
      do {
        oneByte = reader.read()
        byteBuffer.append(oneByte.toByte)
      } while (oneByte != -1)
      byteBuffer.toArray
    } else {
      throw new Exception(s"${url} get none data")
    }
  }


}
