package PWSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
      page.pause();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("murali");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").press("Tab");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("murali@gmail.com");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").press("Tab");
      page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("dfdfddfdf");
      page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn path").click();
    }
  }
}


