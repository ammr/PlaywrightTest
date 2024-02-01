package PWSessions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserContext.StorageStateOptions;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class StoreSessionAfterSignIn {

	public static void main(String[] args) {

		
		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		BrowserContext bc1 = b.newContext();
		Page p1= bc1.newPage();
		p1.navigate("https://www.abc.com");
		p1.click("a:text('Sign In')");
		p1.fill("#email", "qa.murali@hotmail.com");
		p1.fill("#passwd", "Pwd@123%");
		p1.click("#SubmitLogIn");
		
		StorageStateOptions storageStateOptions = new BrowserContext.StorageStateOptions().setPath(Paths.get("appl_login.json")); 
		bc1.storageState(storageStateOptions);
		
		//in the new file you have to give this
		NewContextOptions newContextOptions = new Browser.NewContextOptions().setStorageStatePath(Paths.get("app_login.jscon"));
		BrowserContext bc2 = b.newContext(newContextOptions);
		Page p2 = bc2.newPage();
		p2.navigate("https://www.abc.com");
		
		
		
		
	}

}
