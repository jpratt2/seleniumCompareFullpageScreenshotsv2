import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;



public class A_createExpectedImagesTest {

    @Test
    public void createBaselineImages()  {
        //create a full-page image of the URLs in the "expected" folder

        Library.UrlLoop(URLs.list,Setup.screenshotMethod);
        Library.UrlLoopTwiceLoaded(URLs.listTwiceLoaded,Setup.screenshotMethod);

    }

}