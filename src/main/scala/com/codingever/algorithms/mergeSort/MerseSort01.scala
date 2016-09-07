package com.codingever.algorithms.mergeSort

import scala.collection.immutable.Nil

/**
  * Created by andrii on 05.09.16.
  */
object MerseSort01 extends App {

  def sort(xs:List[Int]):List[Int] = {
    xs match {
      case Nil => xs
      case y::Nil => xs
      case _ => {
        val m = xs.size / 2
        val xs1 = sort(xs.slice(0, m))
        val xs2 = sort(xs.slice(m, xs.size))
        merge(xs1, xs2)
      }
    }
  }

  def merge(xs1: List[Int], xs2: List[Int]): List[Int] = {
    (xs1, xs2) match {
      case (Nil, _) => xs2
      case (_, Nil) => xs1
      case (x1::s1, x2::s2) => if (x1 > x2) x2::merge(xs1, s2) else x1::merge(s1, xs2)
    }
  }

  val xs = List(7,1,2,5,-100,6,2,-99, -101)
  println(sort(xs))
}
