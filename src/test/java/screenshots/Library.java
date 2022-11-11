package screenshots;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.function.Consumer;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	static void UrlLoop(String[] urlList, Consumer<RemoteWebDriver> method) {
		for (int i = 0; i < urlList.length; i++) {
			int x=123;
			RemoteWebDriver driver = getRemoteWebDriver();//start a new, fresh browser for each web page
			String URL = urlList[i];
			driver.get(URL);
			try {
				Thread.sleep(1);//wait for the page to fully load
			} catch (Exception e) {}
			method.accept(driver);
			driver.quit();
		}
	}

	static void UrlLoopTwiceLoaded(String[] urlList, Consumer<RemoteWebDriver> method){
		for (int i = 0; i < urlList.length; i++) {

			RemoteWebDriver driver = getRemoteWebDriver();//start a new, fresh browser for each web page
			String URL = urlList[i];

			//load the page twice
			for(int x=0;x<2;x++) {
				driver.get(URL);
				try {
					Thread.sleep(10000);//wait for the page to fully load
				} catch (Exception e) {}
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
		
	
}
