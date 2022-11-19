package screenshots;
import org.junit.Test;




public class A_createExpectedImagesTest{

    @Test
    public void createExpectedImages() throws Exception {
        //create a full-page image of the URLs in the "expected" folder
        Setup.initialize();        
        Library.UrlLoop(URLs.list,Library.getScreenshotMethod());
        Library.UrlLoopTwiceLoaded(URLs.listTwiceLoaded,Library.getScreenshotMethod());

    }

}