package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		double width = d.getWidth();
		double height = d.getHeight();

		Playwright pw = Playwright.create();
		
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = b.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
		Page p = context.newPage();
		p.navigate("http://way2automation.com");
		System.out.println(p.title());
		Thread.sleep(3000);
		p.close();
		b.close();
		
		
		
		System.out.println("**********chrome******");Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser1= playwright.chromium().launch(new BrowserType.LaunchOptions()
							.setChannel("chrome")
							.setHeadless(false)
							.setArgs(arguments));
		BrowserContext context1 = browser1.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context1.newPage();
 
		page.navigate("http://way2automation.com");
		System.out.println(page.title());
		page.close();
		pw.close();
	}

}
