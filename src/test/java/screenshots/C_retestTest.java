package screenshots;
import org.junit.Test;


public class C_retestTest {
    @Test
    public void _01_testAgainstBaseline() throws InterruptedException {
		//Same as A_ except it is using the "retest" list from the URLs file

		Library.UrlLoop(URLs.retest,Library.getScreenshotMethod());
        Library.UrlLoopTwiceLoaded(URLs.retestTwiceLoaded,Library.getScreenshotMethod());

    }

}
