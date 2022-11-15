package screenshots;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class C_retestTest {
    @Test
    public void _01_testAgainstBaseline() throws InterruptedException {
		//Same as A_ except it is using the "retest" list from the URLs file

		Library.UrlLoop(URLs.retest,Setup.screenshotMethod);
        Library.UrlLoopTwiceLoaded(URLs.retestTwiceLoaded,Setup.screenshotMethod);

    }

}
