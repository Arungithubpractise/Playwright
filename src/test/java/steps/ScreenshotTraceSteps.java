package steps;

import com.microsoft.playwright.BrowserContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class ScreenshotTraceSteps {
    @When("I capture a screenshot named {string}")
    public void i_capture_a_screenshot_named(String fileName) throws Exception {
        Path path = Paths.get("target", fileName + ".png");
        Files.createDirectories(path.getParent());
        PlaywrightContext.page.screenshot(new com.microsoft.playwright.Page.ScreenshotOptions().setPath(path));
    }

    @Then("the screenshot file exists")
    public void the_screenshot_file_exists() {
        Path path = Paths.get("target", "screenshot.png");
        assertTrue("Screenshot file not found", Files.exists(path));
    }

    @When("I record a trace named {string}")
    public void i_record_a_trace_named(String fileName) throws Exception {
        BrowserContext context = PlaywrightContext.browser.newContext();
        context.tracing().start(new com.microsoft.playwright.Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
        context.newPage().navigate("file:///" + System.getProperty("user.dir") + "/src/test/resources/pages/advanced-browser.html");
        Path tracePath = Paths.get("target", fileName + ".zip");
        Files.createDirectories(tracePath.getParent());
        context.tracing().stop(new com.microsoft.playwright.Tracing.StopOptions().setPath(tracePath));
        context.close();
    }

    @Then("the trace file exists")
    public void the_trace_file_exists() {
        Path path = Paths.get("target", "trace.zip");
        assertTrue("Trace file not found", Files.exists(path));
    }
}
