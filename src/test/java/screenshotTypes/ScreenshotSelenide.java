package screenshotTypes;
import static com.codeborne.selenide.Selenide.*;
import java.io.File;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.codeborne.selenide.WebDriverRunner;

public class ScreenshotSelenide {

    
    public static void fullpage(RemoteWebDriver driver, String foldername){
        WebDriverRunner.setWebDriver(driver);//Selenide uses its own driver by default. This allows us to use the existing driver.
        String separator = File.separator;
        String url = driver.getCurrentUrl();
        String fileName = Utilities.convertUrlToFileName(url);
        screenshot(".." + separator + ".." + separator + ".." + separator + foldername + separator + fileName);
    
    }

    public static void fullpage(RemoteWebDriver driver){
        fullpage(driver, "expected");
    }
}


