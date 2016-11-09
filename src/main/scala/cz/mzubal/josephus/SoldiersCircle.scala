package cz.mzubal.josephus

import scala.collection.mutable

/**
  * Mutable circular buffer of soldiers using mutable Buffer and index to represent rotation state.
  */
class SoldiersCircle[A](val data: mutable.Buffer[A]) {
  var index: Int = 0

  def step(stepSize: Int) = {index = (index + stepSize - 1) % data.size}
  def eliminate = data.remove(index)
  def remaining = data.size
  def current = data(index)
  def last = data.head
}
