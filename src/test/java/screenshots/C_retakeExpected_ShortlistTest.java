package screenshots;
import org.junit.Test;




public class C_retakeExpected_ShortlistTest{

    @Test
    public void createExpectedImages() throws Exception {
		//Same as A_ but for the smaller list "shortlist" in the URLs file
        Setup.initialize();  

        Library.UrlsExpected(URLs.shortlist);
        Library.UrlsExpectedTwiceLoaded(URLs.shortlistTwiceLoaded);

    }

}