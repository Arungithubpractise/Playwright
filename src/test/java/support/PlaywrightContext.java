package support;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public final class PlaywrightContext {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    private PlaywrightContext() {
    }

    public static void pauseForAction() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void close() {
        try {
            if (page != null) {
                page.close();
            }
        } catch (Exception ignored) {
        }
        page = null;

        try {
            if (browser != null) {
                browser.close();
            }
        } catch (Exception ignored) {
        }
        browser = null;

        try {
            if (playwright != null) {
                playwright.close();
            }
        } catch (Exception ignored) {
        }
        playwright = null;
    }
}
