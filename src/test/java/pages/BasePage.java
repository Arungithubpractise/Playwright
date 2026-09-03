package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import support.PlaywrightContext;

public class BasePage {
    public Page getPage() {
        return PlaywrightContext.page;
    }

    protected void pauseAfterAction() {
        PlaywrightContext.pauseForAction();
    }

    protected Locator locator(String selector) {
        return getPage().locator(selector);
    }

    protected Locator byTestId(String testId) {
        return getPage().getByTestId(testId);
    }
}
