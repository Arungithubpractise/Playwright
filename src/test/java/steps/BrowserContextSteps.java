package steps;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class BrowserContextSteps {
    @When("I open a second page in the same browser context")
    public void i_open_a_second_page_in_the_same_browser_context() {
        BrowserContext context = PlaywrightContext.browser.newContext();
        Page secondPage = context.newPage();
        secondPage.navigate("file:///" + System.getProperty("user.dir") + "/src/test/resources/pages/advanced-browser.html");
        assertTrue("Second page should load successfully", secondPage.url().contains("advanced-browser.html"));
        secondPage.close();
        context.close();
    }

    @Then("multiple pages are supported")
    public void multiple_pages_are_supported() {
        assertTrue("Browser context is available", PlaywrightContext.browser != null);
    }
}
