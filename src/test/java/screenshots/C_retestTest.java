package screenshots;
import screenshotTypes.CompareImages;
import java.util.function.Consumer;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;


public class C_retestTest extends Setup {
    @Test
    public void _01_testAgainstBaseline() {
		//Same as B_ --for retesting a smaller list-- it is using the "retest" list in the URLs file

        Consumer<RemoteWebDriver> comparisonMethod = CompareImages::compare;
        
        Library.UrlLoop(URLs.retest,comparisonMethod);
        Library.UrlLoopTwiceLoaded(URLs.retestTwiceLoaded,comparisonMethod);

    }

}
