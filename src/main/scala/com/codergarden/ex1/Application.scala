package com.codergarden.ex1

import scala.::

object Application {

  def getShorterLonger(wordlist: List[String]): ((Int, List[String]), (Int, List[String])) = {

     wordlist.foldLeft ((0 , List[String] ()) , (0 , List[String]() ))  {
      case ((shorter, longer), currWord) =>
        val long = currWord.length - longer._1 match {
          case m if m < 0 || currWord.length < 3 => (longer._1, longer._2)
          case m if m > 0 => (currWord.length , currWord :: Nil)
          case m if m == 0 => (longer._1 , longer._2 :+ currWord)
        }
        val short = currWord.length - shorter._1 match {
          case m if (m < 0 || shorter._2.isEmpty) && currWord.length > 2 => (currWord.length , currWord :: Nil)
          case m if m > 0 || currWord.length < 3 => (shorter._1, shorter._2)
          case m if m == 0 => (shorter._1, shorter._2 :+ currWord)
        }
        (short , long)
    }
  }
  def main(args: Array[String]): Unit = {
    val  shorterlonger = getShorterLonger(args.toList)
    println(s"""Shorter word/s: ${shorterlonger._1._2.mkString(" ")} with num letters ${shorterlonger._1._1} \n Longer word/s: ${shorterlonger._2._2.mkString(" ")} with num letters ${shorterlonger._2._1}""" )
  }
}

