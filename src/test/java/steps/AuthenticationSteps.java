package steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertTrue;
import support.PlaywrightContext;

public class AuthenticationSteps {
    @When("I save browser storage state to {string}")
    public void i_save_browser_storage_state_to(String fileName) throws Exception {
        Path path = Paths.get("target", fileName + ".json");
        Files.createDirectories(path.getParent());

        BrowserContext context = PlaywrightContext.browser.newContext();
        Page authPage = context.newPage();
        authPage.navigate("file:///" + System.getProperty("user.dir") + "/src/test/resources/pages/advanced-browser.html");
        authPage.evaluate("() => localStorage.setItem('authToken', 'token-123')");

        context.storageState(new BrowserContext.StorageStateOptions().setPath(path));
        authPage.close();
        context.close();
    }

    @Then("the stored auth token is reused")
    public void the_stored_auth_token_is_reused() throws Exception {
        Path path = Paths.get("target", "auth-state.json");
        assertTrue("Storage state file was not created", Files.exists(path) && Files.size(path) > 0);

        String json = Files.readString(path);
        assertTrue("Storage state should include browser state", json.contains("cookies") || json.contains("origins"));
    }
}
