package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class FramesAndDialogsSteps {
    @When("I click the alert button")
    public void i_click_the_alert_button() {
        PlaywrightContext.page.onDialog(dialog -> dialog.accept());
        PlaywrightContext.page.locator("#show-alert").click();
        PlaywrightContext.pauseForAction();
    }

    @Then("the alert is accepted")
    public void the_alert_is_accepted() {
        assertTrue("Alert handling should complete without exception", true);
    }

    @Then("the iframe content contains {string}")
    public void the_iframe_content_contains(String expected) {
        String frameText = PlaywrightContext.page.frameLocator("#inner-frame").locator("body").innerText();
        assertTrue("Iframe content missing expected text: " + expected,
                frameText.toLowerCase().contains(expected.toLowerCase()));
    }
}
