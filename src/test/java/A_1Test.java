import static com.codeborne.selenide.Selenide.*;

import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class A_1Test extends Setup{
    
    @Test
    public void a1()  throws Exception{
        
        //Selenide framework
        open("https://adobe.com/acrobat.html");
        Thread.sleep(1000);
        screenshot("..\\..\\..\\my_file_name_edge");


        /* 
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://adobe.com");
        Shutterbug.shootPage(driver, Capture.FULL).withName("test").save();
        driver.quit();
*/

/*Ashot scrolling screenshot
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.get("https://www.apple.com");

Screenshot screenshot = new AShot()
.shootingStrategy(ShootingStrategies.viewportPasting(100))
.takeScreenshot(driver);

ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\screenshots\\filename1.png"));
driver.quit();
 */

    }

}
