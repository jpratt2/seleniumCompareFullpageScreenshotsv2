import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.remote.RemoteWebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotAshot {

    public static void fullpage(RemoteWebDriver driver) throws Exception{
    Screenshot screenshot = new AShot()
        .shootingStrategy(ShootingStrategies.viewportPasting(100))
        .takeScreenshot(driver);

    ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\screenshots\\filename1.png"));
    
    }
}