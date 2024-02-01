package PWSessions;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsExample {

	public static void main(String[] args) {
		
		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext bc1 = b.newContext();
		Page p1= bc1.newPage();
		p1.navigate("https://www.orangehrm.com/30-day-free-trial");
		
		Locator countries = p1.locator("select#Form_getForm_Country option");
		System.out.println("total countries are:"+countries.count());
		
//		for (int i = 0; i <countries.count(); i++) {
//			String text = countries.nth(i).textContent();
//			System.out.println(text);
//		}
		
		List<String> countriesList = countries.allTextContents();
//		for (String c : countriesList) {
//			System.out.println(c);
//		}
		
		countriesList.forEach(e-> System.out.println(e));
		//p1.locator("text=Login").click();
	//	p1.locator("'Login'").click();
		//String pageText= p1.frame("main").locator("h2").textContent();
		//String pageText= p1.frameLocator("//frame[@name='main']").locator("h2").textContent();
		
		

	}

}
