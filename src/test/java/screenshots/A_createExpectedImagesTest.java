package screenshots;
import org.junit.Test;




public class A_createExpectedImagesTest extends Setup{

    @Test
    public void createExpectedImages()  {
        //create a full-page image of the URLs in the "expected" folder
        
        Library.UrlLoop(URLs.list,Setup.screenshotMethod);
        Library.UrlLoopTwiceLoaded(URLs.listTwiceLoaded,Setup.screenshotMethod);

    }

}