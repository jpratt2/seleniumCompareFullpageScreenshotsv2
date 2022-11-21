package screenshots;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import screenshotTypes.*;

public class Library {

	static void UrlsExpected(String[] urlList, int timesLoaded) throws InterruptedException{
		for (int i = 0; i < urlList.length; i++) {

			RemoteWebDriver driver = getRemoteWebDriver();//start a new, fresh browser for each web page
			String URL = urlList[i];

			//load the page potentially multiple times
			for(int x=0; x<timesLoaded; x++) {
				driver.get(URL);
				Thread.sleep(Setup.pause);//wait for the page to load
			}

			takeScreenshot(driver, "expected");
			driver.quit();
		}
	}
	static void UrlsExpected(String[] urlList) throws InterruptedException{
		UrlsExpected(urlList, 1);
	}
	static void UrlsExpectedTwiceLoaded(String[] urlList) throws InterruptedException{
		UrlsExpected(urlList, 2);
	}

	static void UrlsObserved(String[] urlList, int timesLoaded, int pixelThreshold) throws InterruptedException{
		for (int i = 0; i < urlList.length; i++) {

			RemoteWebDriver driver = getRemoteWebDriver();//start a new, fresh browser for each web page
			String URL = urlList[i];

			//load the page perhaps multiple times
			for(int x=0; x<timesLoaded; x++) {
				driver.get(URL);
				Thread.sleep(Setup.pause);//wait for the page to load
			}

			takeScreenshot(driver, "observed");
			CompareImages.compare(driver, pixelThreshold);
			driver.quit();
		}
	}
	static void UrlsObserved(String[] urlList, int pixelThreshold) throws InterruptedException{
		UrlsObserved(urlList, 1, pixelThreshold);
	}
	static void UrlsObservedTwiceLoaded(String[] urlList, int pixelThreshold) throws InterruptedException{
		UrlsObserved(urlList, 2, pixelThreshold);
	}


	static RemoteWebDriver getRemoteWebDriver(){
		RemoteWebDriver driver;
		switch(Setup.browser){
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
		}
		Dimension size = new Dimension(Setup.browserWidth, Setup.browserHeight);
		driver.manage().window().setSize(size);
		return driver;
	}
		
	public static void takeScreenshot(RemoteWebDriver driver, String folder){
		switch(Setup.screenshotTool){
			case "selenide":
				ScreenshotSelenide.fullpage(driver, folder);
			break;
		case "ashot":
				ScreenshotAshot.fullpage(driver, folder);
			break;
		case "shutterbug":
				ScreenshotSBug.fullpage(driver, folder);
			break;
		case "firefox-selenium":
				ScreenshotFF.fullpage(driver, folder);
			break;
		default:
			ScreenshotSelenide.fullpage(driver, folder);
		}
	}

}
