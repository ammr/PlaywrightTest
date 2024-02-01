package testcases;

import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NonIncognitoModeExample {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		
		Playwright pw = Playwright.create();
		BrowserContext context = pw.chromium()
					.launchPersistentContext(Paths.get("C:\\Users\\udaya\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2"), 
												new BrowserType.LaunchPersistentContextOptions().setHeadless(false)
													.setChannel("chrome")
													.setExecutablePath(Paths.get("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"))
														.setArgs(arguments));
		Page p = context.newPage();
		p.navigate("http://gmail.com");
		Thread.sleep(3000);
		System.out.println(p.title());
		//p.navigate("http://google.com");
		//System.out.println(p.title());
		//Thread.sleep(3000);
		//p.goBack();
		//Thread.sleep(3000);
		//p.goForward();
		
			
				
		
		
	}
	
	
}
