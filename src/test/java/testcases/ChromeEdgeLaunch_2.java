package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.FillOptions;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Playwright;

public class ChromeEdgeLaunch_2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		//System.out.println(width+"---"+height);
		
		ArrayList<String> options = new ArrayList<String>();
		options.add("--start-maximized");
		
		Playwright playwright = Playwright.create();
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		
		Browser browser = playwright
						.chromium()
						.launch(new BrowserType.LaunchOptions()
												.setHeadless(false)
												.setExecutablePath(Paths.get("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
		
		//BrowserContext browserContext = playwright.chromium()
				//.launchPersistentContext(Paths.get(""),
				//new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setViewportSize((int)width, (int)height));
		
		Page page = browserContext.newPage();
		page.navigate("http://gmail.com");
		System.out.println(page.title());
		Thread.sleep(2000);
		page.type("#identifierId", "hello@gmail.com", new TypeOptions().setDelay(100));
		page.click("button:has-text('Next')");
		String errMsg= page.locator("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div").innerText();
		System.out.println(errMsg);
		Thread.sleep(2000);
		page.close();
		playwright.close();
	}

}
