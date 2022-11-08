import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.remote.RemoteWebDriver;

public class ScreenshotSelenide {

    
    public static void fullpage(RemoteWebDriver driver){
        //the driver is not needed because Selenide uses its own
        screenshot("..\\..\\..\\my_file_name_edge");
    }
}


