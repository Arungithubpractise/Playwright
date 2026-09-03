package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class ActionSteps {
    @When("I fill the username with {string}")
    public void i_fill_the_username_with(String value) {
        PlaywrightContext.page.locator("#username").fill(value);
        PlaywrightContext.pauseForAction();
    }

    @When("I select {string} from the country dropdown")
    public void i_select_from_the_country_dropdown(String value) {
        PlaywrightContext.page.locator("#country").selectOption(value);
        PlaywrightContext.pauseForAction();
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        PlaywrightContext.page.locator("#submit-btn").click();
        PlaywrightContext.pauseForAction();
    }

    @When("I click the open modal button")
    public void i_click_the_open_modal_button() {
        PlaywrightContext.page.getByTestId("open-modal").click();
        PlaywrightContext.pauseForAction();
    }

    @Then("the value in username field is {string}")
    public void the_value_in_username_field_is(String expected) {
        String actual = PlaywrightContext.page.locator("#username").inputValue();
        assertTrue("Username value mismatch. Expected: " + expected + ", Actual: " + actual,
                expected.equals(actual));
    }
}
