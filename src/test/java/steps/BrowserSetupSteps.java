package steps;

import com.microsoft.playwright.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import java.nio.file.Paths;
import support.PlaywrightContext;

public class BrowserSetupSteps {
    private String localMockPageUrl() {
        return Paths.get("src", "test", "resources", "pages", "dummy-browser.html")
                .toAbsolutePath()
                .toUri()
                .toString();
    }

    @Given("I open the example page")
    public void i_open_the_example_page() {
        try {
            PlaywrightContext.playwright = com.microsoft.playwright.Playwright.create();
            PlaywrightContext.browser = PlaywrightContext.playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            PlaywrightContext.page = PlaywrightContext.browser.newPage();
            PlaywrightContext.page.navigate(localMockPageUrl());
            PlaywrightContext.pauseForAction();
        } catch (Exception e) {
            throw new RuntimeException("Failed to open local mock Playwright page", e);
        }
    }

    @Given("I open the advanced page")
    public void i_open_the_advanced_page() {
        try {
            PlaywrightContext.playwright = com.microsoft.playwright.Playwright.create();
            PlaywrightContext.browser = PlaywrightContext.playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            PlaywrightContext.page = PlaywrightContext.browser.newPage();
            PlaywrightContext.page.navigate(Paths.get("src", "test", "resources", "pages", "advanced-browser.html")
                    .toAbsolutePath().toUri().toString());
            PlaywrightContext.pauseForAction();
        } catch (Exception e) {
            throw new RuntimeException("Failed to open advanced mock Playwright page", e);
        }
    }

    @Given("I open the Wikipedia page")
    public void i_open_the_wikipedia_page() {
        try {
            PlaywrightContext.playwright = com.microsoft.playwright.Playwright.create();
            PlaywrightContext.browser = PlaywrightContext.playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            PlaywrightContext.page = PlaywrightContext.browser.newPage();
            PlaywrightContext.page.navigate("https://www.wikipedia.org");
            PlaywrightContext.pauseForAction();
        } catch (Exception e) {
            throw new RuntimeException("Failed to open Wikipedia page", e);
        }
    }

    @After
    public void tearDown() {
        PlaywrightContext.close();
    }
}
