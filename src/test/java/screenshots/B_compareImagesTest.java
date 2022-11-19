package screenshots;

import screenshotTypes.CompareImages;
import java.util.function.Consumer;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;



public class B_compareImagesTest{
    
    @Test
    public void testAgainstBaseline() throws Exception {
        //create a full-page image of the URLs in the list, but this time in the "observed" folder
        Setup.initialize();  
        Consumer<RemoteWebDriver> comparisonMethod = CompareImages::compare;
        Library.UrlLoop(URLs.list,comparisonMethod);
        Library.UrlLoopTwiceLoaded(URLs.listTwiceLoaded,comparisonMethod);


    }

}
