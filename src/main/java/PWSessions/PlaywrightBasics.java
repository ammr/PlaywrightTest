package PWSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {

		Playwright pw= Playwright.create();
		//Browser browser =  pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);
		Browser browser =  pw.chromium().launch(lp);
		
		Page page = browser.newPage();
		page.navigate("https://www.amazon.co.uk/");
		String title = page.title();
		System.out.println("Page title is:"+title);
		String url = page.url();
		System.out.println("URL is:"+url);
		browser.close();
		pw.close();

	}

}
