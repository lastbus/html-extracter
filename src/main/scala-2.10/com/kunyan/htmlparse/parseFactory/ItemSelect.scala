package com.kunyan.htmlparse.parseFactory

import org.jsoup.nodes.Element

/**
  * Created by Administrator on 2016/3/4.
  */
object ItemSelect {

  /**
    * 取出来某个 element ， 然后怎样提取数据
 *
    * @param command
    * @param element
    * @param parameter
    * @return
    */
  def select(command: String, element: Element, parameter: String): String ={
    if (command.equals("text")) {
      element.select(parameter)text()
    } else if (command.equals("attr")) {
      element.attr(parameter)
    } else {
      "not-find-select-command!"
    }
  }

  /**
    * 将
    * @param command
    * @param string
    * @param parameters
    * @return
    */
  def filter(command: String, string: String, parameters: String): String = {
    if (command.equals("prefix")) {
      parameters + string
    } else if (command.equals("append")) {
      string + parameters
    } else if (command.equals("format-url")){
      formatUrl(parameters, string)
    } else {
      "not-find-filter-command!"
    }
  }


}
