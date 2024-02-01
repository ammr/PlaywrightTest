package PWSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LinksImagesChecker {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext bc1 = b.newContext();
		Page p1 = bc1.newPage();
		p1.navigate("https://www.amazon.com");

		List<String> links = p1.locator("a:visible").allTextContents();
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i));

		}
		
		int imagesCount = p1.locator("xpath=//img >> visible=true").count();
		System.out.println("no of images are:"+imagesCount);
	}
}
