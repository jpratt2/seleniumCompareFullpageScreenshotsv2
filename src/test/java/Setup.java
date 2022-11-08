import java.util.function.Consumer;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
    public static RemoteWebDriver driver;
    static String browser, screenshotTool;
    public static Consumer<RemoteWebDriver> screenshotMethod;

/////////////////********//////////////////PLEASE SET UP THIS TOOL BELOW////////////////////*****/////////////////////////////////////////////////   @BeforeClass
    public static void browserSetup(){

          // 1. Choose a browser by uncommenting a line below.
                    browser = "chrome";
                    //browser = "firefox";
                    //browser = "edge";
         

          // 2. Enter the desired browser width and height in pixels
                    int browserWidth = 1440;
                    int browserHeight = 900;

          // 3. Select the screenshot tool by uncommenting one of the following lines.
                    //screenshotTool = "ashot";
                    screenshotTool = "selenide"; 
                    //screenshotTool = "shutterbug";
                    //screenshotTool = "firefox-selenium";


          //Note: Selenide uses dev tools, and Ashot uses scrolling.
          //Shutterbug uses dev tools in Chrome, but it still may have a different output than Selenide.


///////////////////////////////////////////////////////////////////////////////////////////////////
        

          if(screenshotTool.equals("selenide")){
               Configuration.browser = browser;
               Configuration.browserSize = browserWidth + "x" + browserHeight;
               driver = new RemoteWebDriver(null);//not needed for Selenide, it has its own driver. It is added here for convenience to match the signature of the method.
          }else if (browser.equals("chrome")){
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
          }else if (browser.equals("firefox")){
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
          }else if (browser.equals("edge")){
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
          }

          Dimension newDimension = new Dimension(browserWidth, browserHeight);
          driver.manage().window().setSize(newDimension);

          switch(screenshotTool){
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
          }
           
        
     }

   


    
    
}
