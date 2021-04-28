package com.codergarden.ex1
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ApplicationSpec extends AnyFlatSpec with Matchers {

  "The getShorterAndLonger function" should "get two lists containing Shorter and longer words of the list passed" in {
    Application.getShorterLonger(List()) shouldEqual((0,List()) , (0, List()))
    Application.getShorterLonger(List("one")) shouldEqual((3 , List("one")), (3 , List("one")))
    Application.getShorterLonger(List("one", "three")) shouldEqual((3, List("one")), (5, List("three")))
    Application.getShorterLonger(List("one", "two", "three", "four")) shouldEqual((3, List("one", "two")), (5, List("three")))
    Application.getShorterLonger(List("one", "two", "eleven", "three", "four", "twelve", "no")) shouldEqual((3 ,List("one", "two")), (6, List("eleven", "twelve")))
    Application.getShorterLonger(List("on", "th", "ciao", "cinque", "si")) shouldEqual((4, List("ciao")), (6, List("cinque")))
  }
}