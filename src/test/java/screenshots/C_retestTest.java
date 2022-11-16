package screenshots;
import org.junit.Test;


public class C_retestTest extends Setup {
    @Test
    public void _01_testAgainstBaseline() {
		//Same as B_ --for retesting a smaller list-- it is using the "retest" list in the URLs file

        Consumer<RemoteWebDriver> comparisonMethod = CompareImages::compare;
        
        Library.UrlLoop(URLs.retest,comparisonMethod);
        Library.UrlLoopTwiceLoaded(URLs.retestTwiceLoaded,comparisonMethod);

    }

}
