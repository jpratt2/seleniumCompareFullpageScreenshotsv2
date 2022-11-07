import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
    public static WebDriver driver;
    

    @BeforeClass
    public static void browserSetup(){

       // Choose a browser by uncommenting a section below.

       /*
         



     

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
   */
        //Configuration.browser = "firefox";
        Configuration.browser = "edge";
        //Default value is Chrome 
       }

    
    
}
