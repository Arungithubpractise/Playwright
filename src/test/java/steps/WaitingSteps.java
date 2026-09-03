package steps;

import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class WaitingSteps {
    @Then("the page waits for the username field")
    public void the_page_waits_for_the_username_field() {
        PlaywrightContext.page.waitForSelector("#username");
        assertTrue("Username field should be visible after waiting", PlaywrightContext.page.locator("#username").isVisible());
    }

    @Then("the success banner is visible")
    public void the_success_banner_is_visible() {
        PlaywrightContext.page.locator("#success-banner").waitFor();
        assertTrue("Success banner should be visible", PlaywrightContext.page.locator("#success-banner").isVisible());
    }
}
