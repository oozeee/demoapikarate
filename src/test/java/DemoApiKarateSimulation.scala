import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class DemoApiKarateSimulation extends Simulation {

  val protocol = karateProtocol("/api/products/login" -> pauseFor("post" -> 1000),
    "/api/products/healthcheck" -> pauseFor("get" -> 1000),
    "/api/products/viewrequests" -> pauseFor("get" -> 1000))

  /*val protocol = karateProtocol("/api/products/login" -> Nil,
                                "/api/products/healthcheck" -> Nil,
                                "/api/products/viewrequests" -> Nil)*/

  ///// SCENARIOS FOR PERFORMANCE TESTING
  val healthCheck = scenario("healthCheck").exec(karateFeature("classpath:demoTest/healthCheck/healthCheck.feature"))
  val userLogin = scenario("userLogin").exec(karateFeature("classpath:demoTest/userLogin/userLogin.feature"))
  val viewRequests = scenario("viewRequests").exec(karateFeature("classpath:demoTest/viewRequests/viewRequests.feature"))

  ///// SETUP WORKLOAD
  setUp(
    healthCheck.inject(constantUsersPerSec(3) during (5 second)),
    userLogin.inject(constantUsersPerSec(3) during (5 second)),
    viewRequests.inject(constantUsersPerSec(3) during (5 second))
  ).protocols(protocol)

  ///// THROTTLE AND RELATED CONCEPTS OF GATLING ARE NOT SUPPORTED YET
  //setUp(userLogin.inject(rampUsers(5) during (1 minutes))).protocols(protocol).throttle(reachRps(10) in (10 seconds), holdFor(30 minutes))

}