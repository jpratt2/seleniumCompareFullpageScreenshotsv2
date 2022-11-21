package screenshots;
import org.junit.Test;




public class B_compareImagesTest{
    
    @Test
    public void testAgainstBaseline() throws Exception {
        //create a full-page image of the URLs in the list, but this time in the "observed" folder
        Setup.initialize();  

        Library.UrlsObserved(URLs.list,  0);
        Library.UrlsObservedTwiceLoaded(URLs.listTwiceLoaded, 0);


    }

}
