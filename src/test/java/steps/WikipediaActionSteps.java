package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class WikipediaActionSteps {
    @When("I type {string} in the Wikipedia search box")
    public void i_type_in_the_wikipedia_search_box(String value) {
        PlaywrightContext.page.locator("input[name='search']").fill(value);
        PlaywrightContext.pauseForAction();
    }

    @Then("the Wikipedia search box contains {string}")
    public void the_wikipedia_search_box_contains(String expected) {
        String actual = PlaywrightContext.page.locator("input[name='search']").inputValue();
        assertTrue("Wikipedia search value mismatch. Expected: " + expected + ", Actual: " + actual,
                expected.equals(actual));
    }
}
