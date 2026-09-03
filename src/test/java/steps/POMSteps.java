package steps;

import com.microsoft.playwright.BrowserType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MockPage;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class POMSteps {
    private final MockPage mockPage = new MockPage();

    @When("I open the mock page")
    public void i_open_the_mock_page() {
        if (PlaywrightContext.browser == null || PlaywrightContext.page == null) {
            PlaywrightContext.playwright = com.microsoft.playwright.Playwright.create();
            PlaywrightContext.browser = PlaywrightContext.playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            PlaywrightContext.page = PlaywrightContext.browser.newPage();
        }
        mockPage.open();
    }

    @Then("the mock page title is {string}")
    public void the_mock_page_title_is(String expected) {
        String title = mockPage.getPage().title();
        assertTrue("Unexpected page title: " + title,
                expected.equals(title));
    }

    @Then("the username field is ready")
    public void the_username_field_is_ready() {
        assertTrue("Username field is not visible", mockPage.username().isVisible());
    }

    @When("I enter {string} in the username field")
    public void i_enter_in_the_username_field(String value) {
        mockPage.fillUsername(value);
    }

    @When("I select {string} from the country drop-down")
    public void i_select_from_the_country_drop_down(String value) {
        mockPage.selectCountry(value);
    }

    @When("I submit the form")
    public void i_submit_the_form() {
        mockPage.clickSubmit();
    }

    @Then("the success banner shows {string}")
    public void the_success_banner_shows(String expected) {
        assertTrue("Missing success banner", mockPage.successBanner().isVisible());
        assertTrue("Unexpected banner text", expected.equals(mockPage.successBanner().textContent()));
    }

    @Then("the modal opens")
    public void the_modal_opens() {
        mockPage.clickOpenModal();
        assertTrue("Modal did not open", mockPage.modalDialog().isVisible());
    }
}
