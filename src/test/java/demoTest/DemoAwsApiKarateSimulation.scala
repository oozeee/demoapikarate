package demoTest

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

import scala.concurrent.duration._

class DemoAwsApiKarateSimulation extends Simulation{

  /// Scenario definition
  val healthCheck = scenario("healthCheck").exec(karateFeature("classpath:demoTest/healthCheck/healthCheck.feature"))

  /// Setup load model
  setUp(
    healthCheck.inject(constantUsersPerSec(5) during(10 second))
  )
}


