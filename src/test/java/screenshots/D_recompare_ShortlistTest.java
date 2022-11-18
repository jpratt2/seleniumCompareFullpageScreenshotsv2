package screenshots;
import screenshotTypes.CompareImages;
import java.util.function.Consumer;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;


public class D_recompare_ShortlistTest extends Setup {
    @Test
    public void _01_testAgainstBaseline() throws Exception {
		//Same as B_ --for retesting a smaller list using the "shortlist" in the URLs file

        Consumer<RemoteWebDriver> comparisonMethod = CompareImages::compare;
        
        Library.UrlLoop(URLs.shortlist,comparisonMethod);
        Library.UrlLoopTwiceLoaded(URLs.shortlistTwiceLoaded,comparisonMethod);

    }

}
