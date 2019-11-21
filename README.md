###Features
- Environment switching using *'karate.env'* variable. Environments available in test suite are local and aws
- Reuse tests scripts by calling in other scripts. This allows easy re-use and maintenance of authentication and set-up flows
- Data driven tests using Cucumber data-tables
- Narrow down test run scope to a single folder or single script
- Re-using functional test scripts to execute load test with Gatling
- Multiple Test Runners to run tests of choice and select between non-parallel and parallel execution modes
    - AutomationSuiteTest: is a non-parallel test runner which generates a surefire and junit XML reports
    - AutomationSuiteParallelRunner: runs tests faster in *karate* parallel execution mode and generates a cucumber html report


#####Pre-requisites
- Java
- Scala

#####Run entire test suite in non parallel mode
````
mvn clean test
mvn clean test -Dtest=AutomationSuiteTest
````

#####Run entire test suite in parallel mode
````
mvn clean test -Dtest=AutomationSuiteParallelRunner
````

####Test execution examples
Switch between environments (local and aws)
````
mvn clean test -DargLine="-Dkarate.env=local" -Dtest=AutomationSuiteTest
````

Narrow down test run scope to a single folder via the command-line argument
````
mvn test -Dkarate.options="--tags ~@ignore classpath:demoTest/viewRequests" -Dtest=AutomationSuiteTest
mvn test -Dkarate.options="--tags ~@ignore classpath:demoTest/healthCheck" -Dtest=AutomationSuiteTest
````

###Performance Test Execution
Run gatling test with the following command
````
mvn clean test-compile gatling:test
mvn clean test-compile gatling:test -DargLine="-Dkarate.env=local"
````

###Interested to know more about Karate
To see more details about *karate* API testing tool, visit *Karate* home page on github: https://github.com/intuit/karate