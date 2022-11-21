package screenshotTypes;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import screenshots.Setup;
import javax.imageio.ImageIO;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareImages {
     /*
        compareImage
        use AShot's diff feature to compare the current web page image against the baseline
        https://github.com/pazone/ashot

     */
    public static void compare(RemoteWebDriver driver, int pixelThreshold){
        String pathExpected = "expected";
        String pathObserved = "observed";
        String pathDiff = "diffs";


        //read data from the "expected" folder for the baseline image 
        String URL = driver.getCurrentUrl();
        String filename = Utilities.convertUrlToFileName(URL);
        String pathToExpected = System.getProperty("user.dir") + File.separator + pathExpected + File.separator + filename + ".png";
        BufferedImage imgExpected = null;
        try {
            imgExpected = ImageIO.read(new File(pathToExpected));
        } catch (IOException e) {
            //read image resource https://docs.oracle.com/javase/tutorial/2d/images/loadimage.html
        }

        //read data for the observed image ("observed" folder)
        String pathToObserved = System.getProperty("user.dir") + File.separator + pathObserved + File.separator + filename + ".png";
        BufferedImage imgObserved = null;
        try {
            imgObserved = ImageIO.read(new File(pathToObserved));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //generate a diff of these 2 images if any difference exists
        ImageDiff diff = new ImageDiffer().makeDiff(imgExpected, imgObserved).withDiffSizeTrigger(pixelThreshold);
        if (diff.hasDiff()) {
            BufferedImage diffImage = diff.getMarkedImage();
            //save the diff image in the diffs folder
            String diffPath = System.getProperty("user.dir") + File.separator + pathDiff + File.separator + filename + ".png";
            try {
                File outputfile = new File(diffPath);
                ImageIO.write(diffImage, "png", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void compare(RemoteWebDriver driver){
        compare(driver, 0);
    }


}



