package screenshotTypes;
import org.openqa.selenium.remote.RemoteWebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotAshot {

    public static void fullpage(RemoteWebDriver driver, String folder) {
        String URL = driver.getCurrentUrl();
        String filename = Utilities.convertUrlToFileName(URL);

        Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(100))
            .takeScreenshot(driver);

        Utilities.saveImage(filename, folder, screenshot);

    }
    
    //use the default folder name "expected":
    public static void fullpage(RemoteWebDriver driver){
        fullpage(driver, "expected");
    }
}

