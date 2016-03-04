package com.kunyan.htmlparse.parseFactory

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

/**
  * Created by Administrator on 2016/3/3.
  */
object SelectContext {

  def select(bytes: Array[Byte], select: (String, (String, String, String), Array[(String, String, Boolean)])): Unit ={
    if(select._1.equalsIgnoreCase("jsoup")){
      val elements = JsoupSelect.select(bytes, (select._2, select._3))
//      println(elements.size())

    } else if (select._1.equalsIgnoreCase("htmlcleaner")){
      //TODO
     null
    } else {
      throw new Exception("configuration has error!")
    }
  }


}
