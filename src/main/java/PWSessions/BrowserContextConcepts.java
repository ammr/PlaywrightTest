package PWSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcepts {

	public static void main(String[] args) {

		
		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext bc1 = b.newContext();
		Page p1= bc1.newPage();
		p1.navigate("https://bbc.com");
		String title = p1.title();
		System.out.println("P1 title is: "+title);
		//p1.pause();
		//p1.fill("#APjFqb", "playwright");
		//p1.click(".gNO89b");
		
		//System.out.println("clicked search on p1");
		
		BrowserContext bc2 = b.newContext();
		Page p2= bc2.newPage();
		p2.navigate("https://amazon.com");
		String title2 = p2.title();
		System.out.println("P2 title is: "+title2);
		
	}

}
