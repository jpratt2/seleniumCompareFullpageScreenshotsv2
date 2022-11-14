import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C_retestTest {
    @Test
    public void _01_testAgainstBaseline() throws InterruptedException {
        //create a full-page image of the URLs in the list, but this time in the "observed" folder

        WebDriverManager.firefoxdriver().setup();

		
		//***this variable can be set with a custom list for "retest", etc.
		String[] urlList = URLs.retest; 
		//**********************************************
        
		for (int i = 0; i < urlList.length; i++) {
            FirefoxDriver driver = new FirefoxDriver();//start a new, fresh browser for each web page
            driver.manage().window().maximize();
            String URL = urlList[i];
            driver.get(URL);
            _AdobeCustom.closeGeoPopup(driver);
            Thread.sleep(15000);//wait for the page to fully load
            Screenshot.compareImage(driver);
			driver.quit();
        }
/* 
				//***this 2nd variable can also be set with a custom list for "re-test", etc.
				String[] urlListB = URLs.loadedTwiceList;
				//**********************************************
				
				for (int i = 0; i < urlListB.length; i++) {
					FirefoxDriver driver = new FirefoxDriver();//start a new, fresh browser for each web page
					driver.manage().window().maximize();
					String URL = urlListB[i];
					driver.get(URL);
					Thread.sleep(10000);//wait for the page to at least mostly load
					driver.get(URL);

					AdobeCustom.closeGeoPopup(driver);
					Thread.sleep(15000);//wait for the page to fully load
					Screenshot.compareImage(driver);
					driver.quit();
				}
 */

    }

}
