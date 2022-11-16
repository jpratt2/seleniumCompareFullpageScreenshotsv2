package screenshots;
import org.junit.Test;


public class C_retestTest extends Setup {
    @Test
    public void _01_testAgainstBaseline() {
		//Same as A_ except it is using the "retest" list from the URLs file

		Library.UrlLoop(URLs.retest,Library.getScreenshotMethod());
        	Library.UrlLoopTwiceLoaded(URLs.retestTwiceLoaded,Library.getScreenshotMethod());

    }

}
