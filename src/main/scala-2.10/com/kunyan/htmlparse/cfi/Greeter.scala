package com.kunyan.htmlparse.cfi

import JoesPrefs._
/**
  * Created by Administrator on 2016/3/2.
  */
object Greeter {

  def greet(name: String)(implicit prompt: PreferredPrompt) {
    println("Welcome, "+ name +". The system is ready.")
    println(prompt.preference)
  }

  def main(args: Array[String]): Unit ={

    greet("make")
  }


}
