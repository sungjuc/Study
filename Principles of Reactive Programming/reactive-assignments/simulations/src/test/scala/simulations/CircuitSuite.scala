package simulations

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CircuitSuite extends CircuitSimulator with FunSuite {
  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5
  
  test("andGate example") {
    val in1, in2, out = new Wire
    andGate(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    
    assert(out.getSignal === false, "and 1")

    in1.setSignal(true)
    run
    
    assert(out.getSignal === false, "and 2")

    in2.setSignal(true)
    run
    
    assert(out.getSignal === true, "and 3")
  }

  test("orGate example") {
    val in1, in2, out = new Wire
    orGate(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    
    assert(out.getSignal === false, "and 1")

    in1.setSignal(true)
    run
    
    assert(out.getSignal === true, "and 2")

    in2.setSignal(true)
    run
    
    assert(out.getSignal === true, "and 3")
  }
  
  test("orGate2 example") {
    val in1, in2, out = new Wire
    orGate2(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    
    assert(out.getSignal === false, "and 1")

    in1.setSignal(true)
    run
    
    assert(out.getSignal === true, "and 2")

    in2.setSignal(true)
    run
    
    assert(out.getSignal === true, "and 3")
  }
  
  test("demux") {
    val d2in, d2c1, d2c0, d2o3, d2o2, d2o1, d2o0 = new Wire
    demux(d2in, List(d2c1,d2c0), List(d2o3,d2o2,d2o1,d2o0))

    d2in.setSignal(false)
    d2c0.setSignal(false)
    d2c1.setSignal(false)
    run
    assert(d2o0.getSignal == false, "demux2 1a")
    assert(d2o1.getSignal == false, "demux2 1b")
    assert(d2o2.getSignal == false, "demux2 1c")
    assert(d2o3.getSignal == false, "demux2 1d")

    d2c0.setSignal(true)
    run
    assert(d2o0.getSignal == false, "demux2 2a")
    assert(d2o1.getSignal == false, "demux2 2b")
    assert(d2o2.getSignal == false, "demux2 2c")
    assert(d2o3.getSignal == false, "demux2 2d")

    d2c0.setSignal(false)
    d2c1.setSignal(true)
    run
    assert(d2o0.getSignal == false, "demux2 3a")
    assert(d2o1.getSignal == false, "demux2 3b")
    assert(d2o2.getSignal == false, "demux2 3c")
    assert(d2o3.getSignal == false, "demux2 3d")

    d2c0.setSignal(true)
    d2c1.setSignal(true)
    run
    assert(d2o0.getSignal == false, "demux2 4a")
    assert(d2o1.getSignal == false, "demux2 4b")
    assert(d2o2.getSignal == false, "demux2 4c")
    assert(d2o3.getSignal == false, "demux2 4d")    

    d2in.setSignal(true)
    d2c0.setSignal(false)
    d2c1.setSignal(false)
    run
    assert(d2o0.getSignal == true, "demux2 5a")
    assert(d2o1.getSignal == false, "demux2 5b")
    assert(d2o2.getSignal == false, "demux2 5c")
    assert(d2o3.getSignal == false, "demux2 5d")

    d2c0.setSignal(true)
    run
    assert(d2o0.getSignal == false, "demux2 6a")
    assert(d2o1.getSignal == true, "demux2 6b")
    assert(d2o2.getSignal == false, "demux2 6c")
    assert(d2o3.getSignal == false, "demux2 6d")

    d2c0.setSignal(false)
    d2c1.setSignal(true)
    run
    assert(d2o0.getSignal == false, "demux2 7a")
    assert(d2o1.getSignal == false, "demux2 7b")
    assert(d2o2.getSignal == true, "demux2 7c")
    assert(d2o3.getSignal == false, "demux2 7d")

    d2c0.setSignal(true)
    run
    assert(d2o0.getSignal == false, "demux2 8a")
    assert(d2o1.getSignal == false, "demux2 8b")
    assert(d2o2.getSignal == false, "demux2 8c")
    assert(d2o3.getSignal == true, "demux2 8d")
  }
}
