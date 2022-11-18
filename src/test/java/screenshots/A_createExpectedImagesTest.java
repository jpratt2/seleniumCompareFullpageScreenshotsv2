package screenshots;
import org.junit.Test;




public class A_createExpectedImagesTest extends Setup{

    @Test
    public void createExpectedImages() throws Exception {
        //create a full-page image of the URLs in the "expected" folder
        
        Library.UrlLoop(URLs.list,Library.getScreenshotMethod());
        Library.UrlLoopTwiceLoaded(URLs.listTwiceLoaded,Library.getScreenshotMethod());

    }

}