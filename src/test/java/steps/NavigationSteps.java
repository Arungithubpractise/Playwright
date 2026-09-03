package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class NavigationSteps {
    @When("I reload the page")
    public void i_reload_the_page() {
        PlaywrightContext.page.reload();
    }

    @Then("the page should still be open")
    public void the_page_should_still_be_open() {
        assertTrue("Page should still be loaded after reload", PlaywrightContext.page.url() != null && !PlaywrightContext.page.url().isEmpty());
    }
}
