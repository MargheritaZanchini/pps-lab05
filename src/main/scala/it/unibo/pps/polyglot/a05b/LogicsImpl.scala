package it.unibo.pps.polyglot.a05b

import it.unibo.pps.polyglot.a05b.Logics
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:
  private var firstRide = true
  private val random = scala.util.Random()
  private var tickCount = 0
  private val initial = (random.nextInt(size - 2) + 1, random.nextInt(size - 2) + 1)
  println(initial)

  override def tick(): Unit = {
    tickCount = tickCount + 1
  }

  override def isOver: Boolean = initial match {
    case (xi, yi) => (yi - tickCount) < 0 || yi + tickCount >= size ||
      xi - tickCount < 0 || xi + tickCount >= size
  }

  override def hasElement(x: Int, y: Int): Boolean = initial match {
    case (xi, yi) => x == xi && (y - yi).abs <= tickCount ||
      y == yi && (x - xi).abs <= tickCount ||
      (x - y) == (xi - yi) && (x - xi).abs <= tickCount ||
      (x + y) == (xi + yi) && (x - xi).abs <= tickCount
  }