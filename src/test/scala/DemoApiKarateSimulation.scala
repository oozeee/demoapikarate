package demoTest

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._


class DemoApiKarateSimulation extends Simulation{


  // scenario definition
  val userLogin = scenario("userLogin").exec(karateFeature("classpath:demoTest/userLogin/userLogin.feature"))

  // setup load model
  setUp(
    userLogin.inject(constantUsersPerSec(5) during(10 second))
  )

}