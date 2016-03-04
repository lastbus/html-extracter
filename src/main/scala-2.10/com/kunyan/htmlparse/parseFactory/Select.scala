package com.kunyan.htmlparse.parseFactory

/**
  * Created by Administrator on 2016/3/3.
  */
trait Select {

  def select[T](t: T, select: String): Array[T]
}
