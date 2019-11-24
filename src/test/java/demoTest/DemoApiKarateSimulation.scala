package demoTest

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class DemoApiKarateSimulation extends Simulation{

  /// Scenario definition
  val healthCheck = scenario("healthCheck").exec(karateFeature("classpath:demoTest/healthCheck/healthCheck.feature"))

  /// Setup load model
  setUp(
    healthCheck.inject(constantUsersPerSec(30) during(180 second))
  )
}