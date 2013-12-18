package simulations

import math.random

class EpidemySimulator extends Simulator {

  def randomBelow(i: Int) = (random * i).toInt

  protected[simulations] object SimConfig {
    val population: Int = 300
    val roomRows: Int = 8
    val roomColumns: Int = 8

    // to complete: additional parameters of simulation
    val sickDelay: Int = 6
    val deadDelay: Int = 14
    val immuneDelay: Int = 16
    val healthyDelay: Int = 18
    val prevalenceRate: Double = 0.01
    val transmissibilityRate: Double = 0.4
    val deadRate: Double = 0.25
  }

  import SimConfig._

  val persons: List[Person] = for {
    i <- (0 until population).toList
  } yield {
    val p = new Person(i)
    if (i < population * prevalenceRate)
      p.setInfected()
    p.init()
    p
  }

  class Person(val id: Int) {
    var infected = false
    var sick = false
    var immune = false
    var dead = false

    // demonstrates random number generation
    var row: Int = randomBelow(roomRows)
    var col: Int = randomBelow(roomColumns)

    //
    // to complete with simulation logic
    //
    def init() = {
      val moveDelay = randomBelow(5) + 1
      afterDelay(moveDelay)(move)
    }

    def setInfected() = {
      infected = true
      afterDelay(sickDelay)(setSick)
      afterDelay(deadDelay)(setDead)
      afterDelay(immuneDelay)(setImmune)
      afterDelay(healthyDelay)(setHealthy)

    }

    def setSick() = {
      sick = true
    }

    def setDead() = {
      if (random < deadRate)
        dead = true
    }

    def setImmune() = {
      if (!dead) {
        immune = true
        sick = false
      }
    }

    def setHealthy() = {
      if (!dead) {
        infected = false
        immune = false
      }
    }

    def move(): Unit = {
      if (!dead) {
        // select available rooms
        val rooms = findRooms(row, col) filter isClean
        if (!rooms.isEmpty) {
          // randomly choose room
          rooms(randomBelow(rooms.length)) match {
            case (r, c) => row = r; col = c
          }
        }

        // then check infection
        if ((!isNotInfected(row, col)) && (!immune && !infected) && (random > transmissibilityRate))
          setInfected()

        // init again
        init()
      }
    }

    def findRooms(row: Int, col: Int): List[(Int, Int)] = {
      List(((row - 1 + roomRows) % roomRows, col),
        ((row + 1) % roomRows, col),
        (row, (col - 1 + roomColumns) % roomColumns),
        (row, (col + 1) % roomColumns))
    }

    def isClean(room: (Int, Int)): Boolean = room match{
      case (row, col) => persons.find(p => p.row == row && p.col == col && (p.sick || p.dead)).isEmpty
    }

    def isNotInfected(row: Int, col: Int): Boolean = {
      persons.find(p => p.row == row && p.col == col && p.infected).isEmpty
    }
  }
}
