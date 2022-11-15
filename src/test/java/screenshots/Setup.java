package screenshots;
import java.util.function.Consumer;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Setup {
     static Consumer<RemoteWebDriver> screenshotMethod;
     public static String browser, screenshotTool;
     static int browserWidth, browserHeight, pause;
 
{
//////////////////////////////////  PLEASE MAKE SELECTIONS BELOW  ////////////////////////////////////////////////////////////////////   
     
          // 1. Choose a browser by uncommenting a line below.
                     browser = "chrome";
                    // browser = "firefox";
                    // browser = "edge";        

          // 2. Enter the desired browser width and height in pixels
                    browserWidth = 1440;
                    browserHeight = 900;

          // 3. Select the screenshot tool by uncommenting one of the following lines.
                    // screenshotTool = "ashot";
                   //  screenshotTool = "selenide"; 
                    screenshotTool = "shutterbug";
                    // screenshotTool = "firefox-selenium";

          // 4. Delay in milliseconds for the page to finish loading prior to the screenshot. 
                    pause = 5000; 
                    
}
                    



///////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////        
          


 

           
        
     
}

     



