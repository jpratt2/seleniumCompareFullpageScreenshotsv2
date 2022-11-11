package screenshotTypes;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ScreenshotSBug {
    //this class uses Shutterbug from https://github.com/assertthat/selenium-shutterbug

    /**
     * creates a full-page screenshot
     *
     * @param   driver      WebDriver instance
     * @param   fileName    String, name of image file to be created
     *                      If the fileName is omitted, the default value of the URL will be used (converted to remove forbidden characters)
     * @param   folderPath  String, path to the folder that will contain the screenshots
     *                      If the folderPath is omitted, the default value of "screenshots" will be used.
     */
    public static void fullpage(RemoteWebDriver driver, String folderPath, String fileName){
        Shutterbug.shootPage(driver, Capture.FULL).withName(fileName).save(folderPath);
    }
    public static void fullpage(RemoteWebDriver driver, String folderPath){
        String url = driver.getCurrentUrl();
        String fileName = Utilities.convertUrlToFileName(url);
        fullpage(driver, folderPath, fileName);
    }
    public static void fullpage(RemoteWebDriver driver){
        String folderPath = "expected";
        fullpage(driver, folderPath);
    }


}
