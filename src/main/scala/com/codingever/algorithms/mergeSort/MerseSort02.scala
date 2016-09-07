package com.codingever.algorithms.mergeSort

import scala.collection.immutable.Nil

/**
  * Created by andrii on 05.09.16.
  */
object MerseSort02 extends App {

  def sort(xs: List[Int]): List[Int] = {
    def sortParts(tuple: (List[Int], List[Int])): (List[Int], List[Int]) = (sort(tuple._1), sort(tuple._2))

    xs match {
      case Nil => xs
      case y :: Nil => xs
      case _ => merge(sortParts(xs splitAt xs.size / 2))
    }
  }

  def merge(xs: (List[Int], List[Int])): List[Int] = {
    xs match {
      case (Nil, _) => xs._2
      case (_, Nil) => xs._1
      case (x1 :: s1, x2 :: s2) => if (x1 > x2) x2 :: merge((xs._1, s2)) else x1 :: merge((s1, xs._2))
    }
  }

  val xs = List(7, 1, 2, 5, -100, 6, 2, -99, -101)
  println(sort(xs))
}
