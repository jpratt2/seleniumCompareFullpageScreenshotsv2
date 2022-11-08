import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;




public class ScreenshotFF {
    /*
        fullpage
        use Selenium 4 and Firefox to take a full page screenshot
     */
    public static void fullpage(RemoteWebDriver driver, String folder) {
        driver =(FirefoxDriver)driver;
        String URL = driver.getCurrentUrl();
        String filename = Utilities.convertUrlToFileName(URL);

        byte[] imageBytes = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.BYTES); //source: https://stackoverflow.com/a/66859108/1691651
        Utilities.saveImage(filename,folder,imageBytes);

    }
    public static void fullpage(RemoteWebDriver driver){
        fullpage(driver, "expected");
    }
}

   