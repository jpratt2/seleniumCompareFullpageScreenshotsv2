package screenshots;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.function.Consumer;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import screenshotTypes.*;

public class Library {
	static void UrlLoop(String[] urlList, Consumer<RemoteWebDriver> method) throws InterruptedException {
		for (int i = 0; i < urlList.length; i++) {
			RemoteWebDriver driver = getRemoteWebDriver();//start a new, fresh browser for each web page
			String URL = urlList[i];
			driver.get(URL);
			Thread.sleep(Setup.pause);//wait for the page to fully load
			method.accept(driver);
			driver.quit();
		}
	}

	static void UrlLoopTwiceLoaded(String[] urlList, Consumer<RemoteWebDriver> method) throws InterruptedException{
		for (int i = 0; i < urlList.length; i++) {

			RemoteWebDriver driver = getRemoteWebDriver();//start a new, fresh browser for each web page
			String URL = urlList[i];

			//load the page twice
			for(int x=0;x<2;x++) {
				driver.get(URL);
				Thread.sleep(Setup.pause);//wait for the page to fully load
			}
			method.accept(driver);
			driver.quit();
		}
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
		
	public static Consumer<RemoteWebDriver> getScreenshotMethod(){  
        Consumer<RemoteWebDriver> screenshotMethod; 
        switch(Setup.screenshotTool){
            case "selenide":
                screenshotMethod = ScreenshotSelenide::fullpage;
                break;
            case "ashot":
                screenshotMethod = ScreenshotAshot::fullpage;
                break;
            case "shutterbug":
                screenshotMethod = ScreenshotSBug::fullpage;
                break;
            case "firefox-selenium":
                screenshotMethod = ScreenshotFF::fullpage;
                break;
            default:
                screenshotMethod = ScreenshotSBug::fullpage;
        }
        return screenshotMethod;
    }
}
