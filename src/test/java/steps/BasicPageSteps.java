package steps;

import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class BasicPageSteps {
    @Then("the page title contains {string}")
    public void the_page_title_contains(String expected) {
        String title = PlaywrightContext.page.title();
        assertTrue("Title check failed. Observed: " + (title == null ? "<null>" : title),
                title != null && title.toLowerCase().contains(expected.toLowerCase()));
    }

    @Then("the page contains text {string}")
    public void the_page_contains_text(String expected) {
        String bodyText = PlaywrightContext.page.locator("body").innerText();
        assertTrue("Body check failed. Observed body snippet: " + (bodyText == null ? "<null>" : bodyText.substring(0, Math.min(80, bodyText.length()))),
                bodyText != null && bodyText.toLowerCase().contains(expected.toLowerCase()));
    }
}
