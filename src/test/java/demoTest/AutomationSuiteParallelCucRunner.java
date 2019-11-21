package demoTest;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import cucumber.api.CucumberOptions;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@CucumberOptions(tags = {"~@ignore"})

public class AutomationSuiteParallelCucRunner {

    @Test
    public void testParallel() {
        String karateOutputPath = "target/surefire-reports";
        KarateStats stats = CucumberRunner.parallel(getClass(), 3, karateOutputPath);
        assertTrue("SCENARIO FAILURES!!", stats.getFailCount() == 0);
        //Results results = Runner.parallel(getClass(), 3, "target/surefire-reports");
    }

}
