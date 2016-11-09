package cz.mzubal.josephus

import com.typesafe.scalalogging.LazyLogging

import scala.collection.mutable.ArrayBuffer

/**
  * Simple Josephus Problem Solver using Circular List (check #SoldiersCircle for more details).
  */
object JosephusProblemSolver extends LazyLogging {

  def main(args: Array[String]): Unit = {
    require(args.length == 2, "Please provide 2 integer arguments - soldiers count and step")
    val soldiersCount = args(0).toInt
    val stepSize = args(1).toInt
    println(findJosephus(soldiersCount, stepSize))
  }

  def findJosephus(soldiersCount: Int, stepSize: Int) : Int = {
    require(soldiersCount > 0, s"Soldier count must be more than 0 (passed value is $soldiersCount)")
    require(stepSize > 0, s"Step must be more than 0 (passed value is $stepSize)")
    logger.debug(s"Creating circular buffer of $soldiersCount} soldiers.")
    // ArrayBuffer is used as it gave better results from performance perspective
    val soldiers = new SoldiersCircle(ArrayBuffer.range(1, soldiersCount + 1))
    logger.debug(s"Starting to solve Josephus problem for $soldiersCount soldiers and step of $stepSize.")
    while (soldiers.remaining > 1) {
      soldiers.step(stepSize)
      logger.debug(s"Eliminating soldier ${soldiers.current}")
      soldiers.eliminate
      logger.debug(s"${soldiers.remaining} soldiers remaining.")
    }
    logger.debug(s"Soldier ${soldiers.last} has survived.")
    soldiers.last
  }

}

