package screenshots;
import org.junit.Test;




public class C_retakeBaseline_ShortlistTest extends Setup{

    @Test
    public void createExpectedImages() throws Exception {
		//Same as A_ --for the smaller list using "shortlist" in the URLs file
        
        Library.UrlLoop(URLs.shortlist,Library.getScreenshotMethod());
        Library.UrlLoopTwiceLoaded(URLs.shortlistTwiceLoaded,Library.getScreenshotMethod());

    }

}