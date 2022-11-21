package screenshots;
import org.junit.Test;




public class D_recompare_ShortlistTest {
    
    @Test
    public void testAgainstBaseline() throws Exception {
		//Same as B_, but for retesting a smaller list "shortlist" in the URLs file
        Setup.initialize();  
 
        Library.UrlsObserved(URLs.shortlist,0);
        Library.UrlsObservedTwiceLoaded(URLs.shortlistTwiceLoaded,0);

    }

}
