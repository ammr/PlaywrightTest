package PWSessions;


import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class TraceViewer {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
    		  .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://www.amazon.co.uk/");
      page.getByLabel("Accept Cookies").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Best Sellers")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gift Ideas")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Returns & Orders")).click();
      page.getByLabel("Email or mobile phone number").click();
      
      context.tracing().stop(new Tracing.StopOptions()
    		  .setPath(Paths.get("trace.zip")));
    }
  }
}