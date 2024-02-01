package PWSessions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class PWBasics {

	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser b = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc1 = b.newContext();
		Page p2 = bc1.newPage();
		
		

		// 23. alerts
		p2.onDialog(dialog -> {
			String alertMsg = dialog.message();
			System.out.println(alertMsg);
			dialog.accept();
			dialog.dismiss();
			dialog.accept("entering some text in the prompt");

		});

		// 24. file upload works when <input type="file" only
		p2.setInputFiles("input#filesToUpload", Paths.get("some file.png")); // upload
		p2.setInputFiles("input#filesToUpload", new Path[0]); // detatch file
		p2.setInputFiles("input#filesToUpload",
				new Path[] { Paths.get("file1.txt"), Paths.get("file2.png"), Paths.get("files3.json") }); // no file

		// create a file on the fly and upload
		p2.setInputFiles("input#filesToUpload", new FilePayload("file4.txt", "text/plain",
				"this is a test to check file upload".getBytes(StandardCharsets.UTF_8)));

		// 25 download the file
		Download download = p2.waitForDownload(() -> {
			p2.click("a:text('abc.zip')");

		});
		System.out.println(download.url());
		System.out.println(download.page().title());
		String path = download.path().toString();
		System.out.println("downloaded to:" + path);
		download.saveAs(Paths.get("abc.zip"));
		download.cancel(); // cancel the download
		String failure = download.failure();
		System.out.println("failure of download" + failure);
		String downloadedFileName = download.suggestedFilename();
		System.out.println("Downloaded file name" + downloadedFileName);

		// 26. maximize the screen
		BrowserContext bc3 = b.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
		Page page3 = bc3.newPage();
		page3.navigate("https://amazon.com");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		BrowserContext bc4 = b.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page4 = bc4.newPage();
		page4.navigate("https://amazon.com");

		// 28. record a video file during test execution
		BrowserContext bc5 = b.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myVideos/")));
		bc5.close(); // this is must after execution for video recording

		// Window pop-ups and tabs
		Page popup = p2.waitForPopup(() -> p2.click("img[alt='my twitter']"));
		popup.waitForLoadState();
		popup.navigate("https://amazon.com");
		System.out.println(popup.title());
		popup.close();
		System.out.println(p2.title());

		Page emptyPopup = p2.waitForPopup(() -> p2.click("a[target='_blank']")); // open a new empty popup
		emptyPopup.waitForLoadState();
		emptyPopup.navigate("https://amazon.com");
		System.out.println(emptyPopup.title());
		emptyPopup.close();
	}

}
