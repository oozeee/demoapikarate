import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class DemoApiKarateSimulation extends Simulation{



  /// Scenario definition
  //val healthCheck = scenario("healthCheck").exec(karateFeature("classpath:demoTest/healthCheck/healthCheck.feature"))
  val viewRequests = scenario("viewRequests").exec(karateFeature("classpath:demoTest/viewRequests/viewRequests.feature"))
  /// Setup workload
  setUp(
    viewRequests.inject(constantUsersPerSec(5) during(10 second))
  )
}

