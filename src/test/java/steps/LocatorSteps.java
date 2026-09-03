package steps;

import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class LocatorSteps {
    @Then("the username field is visible")
    public void the_username_field_is_visible() {
        assertTrue("Username field should be visible", PlaywrightContext.page.locator("#username").isVisible());
    }

    @Then("the submit button is visible")
    public void the_submit_button_is_visible() {
        assertTrue("Submit button should be visible", PlaywrightContext.page.locator("#submit-btn").isVisible());
    }

    @Then("the modal dialog is visible")
    public void the_modal_dialog_is_visible() {
        assertTrue("Modal dialog should be visible", PlaywrightContext.page.getByTestId("modal-dialog").isVisible());
    }
}
