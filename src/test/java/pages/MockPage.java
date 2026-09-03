package pages;

import com.microsoft.playwright.Locator;

public class MockPage extends BasePage {
    public Locator username() { return locator("#username"); }
    public Locator password() { return locator("#password"); }
    public Locator country() { return locator("#country"); }
    public Locator submitButton() { return locator("#submit-btn"); }
    public Locator successBanner() { return locator("#success-banner"); }
    public Locator openModalButton() { return byTestId("open-modal"); }
    public Locator modalDialog() { return byTestId("modal-dialog"); }

    public void open() {
        getPage().navigate("file:///" + System.getProperty("user.dir") + "/src/test/resources/pages/dummy-browser.html");
    }

    public void fillUsername(String value) { username().fill(value); pauseAfterAction(); }
    public void clickSubmit() { submitButton().click(); pauseAfterAction(); }
    public void clickOpenModal() { openModalButton().click(); pauseAfterAction(); }
    public void selectCountry(String value) { country().selectOption(value); pauseAfterAction(); }
}
