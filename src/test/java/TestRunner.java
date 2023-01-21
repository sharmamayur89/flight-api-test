//import cucumber.api.CucumberOptions;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
//
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/booking-api-feature/booking.feature" }, glue = { "api.steps" },
        plugin = { "pretty",
                "junit:target/junit-booking-api.html",
                "html:TestReports/cucumber-reports/cucumber-report.html",
                "json:TestReports/cucumber-reports/cucumber.json",
                "usage:TestReports/cucumber-reports/cucumber-usage.json",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "rerun:target/failedrerun.txt",
                "summary"
        }, monochrome = true, tags = "@Regression", dryRun = false)

public class TestRunner {

        @AfterClass
        public static void generateReport() throws Exception {

                CucumberResultsOverview results = new CucumberResultsOverview();
                try {
                        results.setOutputDirectory("TestReports/cucumber/");
                        results.setOutputName("cucumber-result");
                        results.setSourceFile("TestReports/cucumber-reports/cucumber.json");
                        results.execute();
                } catch (Exception e1) {
                        throw new RuntimeException("unable to generate overview report.");
                }
                CucumberDetailedResults result = new CucumberDetailedResults();
                try {
                        result.setOutputDirectory("TestReports/cucumber/");
                        result.setOutputName("cucumber-result");
                        result.setSourceFile("TestReports/cucumber-reports/cucumber.json");
                        result.setScreenShotLocation("resources/");
                        result.execute();
                } catch (Exception e1) {
                        throw new RuntimeException("unable to generate detailed report.");
                }
        }

}
