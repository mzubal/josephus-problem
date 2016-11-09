package cz.mzubal.josephus

import org.scalatest.FunSuite

/**
  * Several Test Cases to cover the implementation
  */
class JosephusProblemSolverTest extends FunSuite {

  // Inputs handling
  test("Both arguments must be positive integers, solver shall throw IllegalArgumentException otherwise") {
    assertThrows[IllegalArgumentException]{JosephusProblemSolver.findJosephus(-1, -1)}
  }

  test("Soldiers count must be positive integer, solver shall throw IllegalArgumentException otherwise") {
    assertThrows[IllegalArgumentException]{JosephusProblemSolver.findJosephus(-1, 2)}
  }

  // Soldier count equals step size
  test("Step must be positive integers, solver shall throw IllegalArgumentException otherwise") {
    assertThrows[IllegalArgumentException]{JosephusProblemSolver.findJosephus(3, 0)}
  }

  test("1 soldier with step 1 shall result in soldier 1 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(1, 1) == 1)
  }

  test("5 soldiers with step 5 shall result in soldier 2 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(5, 5) == 2)
  }

  test("7 soldiers with step 7 shall result in soldier 5 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(7, 7) == 5)
  }

  // Basic Test Cases

  test("3 soldiers with step 2 shall result in soldier 3 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(3, 2) == 3)
  }

  test("7 soldiers with step 3 shall result in soldier 4 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(7, 3) == 4)
  }

  test("10 soldiers with step 7 shall result in soldier 9 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(10, 7) == 9)
  }

  // Large inputs Test Cases

  test("100000 soldiers with step 2 shall result in soldier 68929 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(100000, 2) == 68929)
  }

  test("1000000 soldiers with step 2 shall result in soldier 951425 being Josephus") {
    assert(JosephusProblemSolver.findJosephus(1000000, 2) == 951425)
  }
}
