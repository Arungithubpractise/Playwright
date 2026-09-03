package steps;

import com.microsoft.playwright.Route;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class NetworkApiSteps {
    @When("I mock the api response with {string}")
    public void i_mock_the_api_response_with(String message) {
        PlaywrightContext.page.route("**/api/user", route -> route.fulfill(
                new Route.FulfillOptions()
                        .setStatus(200)
                        .setContentType("application/json")
                        .setBody("{\"message\":\"" + message + "\"}")));

        PlaywrightContext.page.locator("#trigger-fetch").click();
        PlaywrightContext.pauseForAction();
    }

    @Then("the api result is {string}")
    public void the_api_result_is(String expected) {
        String actual = PlaywrightContext.page.locator("#api-result").innerText();
        assertTrue("Unexpected API result: " + actual,
                actual.toLowerCase().contains(expected.toLowerCase()));
    }
}
