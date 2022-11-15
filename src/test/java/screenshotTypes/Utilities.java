package screenshotTypes;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.Screenshot;

public class Utilities {
    static String path = System.getProperty("user.dir");
    static String separator = File.separator;

    static String convertUrlToFileName(String url){
        url = url.replaceFirst("https?://","");
        url = url.replaceAll("[?|*:<>\"/\\\\]","-");
        url = truncate(url,159);//Windows file name limit
        return url;
    }

    static void saveImage(String filename, String folder, byte[] imageBytes){
        String filenameWithPath = path + separator + folder + separator + filename + ".png";
        try {
            Files.write(Paths.get(filenameWithPath), imageBytes);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void saveImage(String filename, String folder, Screenshot screenshot){
        String filenameWithPath = path + separator + folder + separator + filename + ".png";
        try {
        ImageIO.write(screenshot.getImage(),"PNG",new File(filenameWithPath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static String truncate(String value, int length) {
        // Ensure String length is shorter than size limit.
        if (value.length() > length) {
            return value.substring(0, length);
        } else {
            return value;
        }
        //resource: https://www.dotnetperls.com/truncate-java
    }

    public static void echo(Object object){
        //used for debugging, logs a value to the console
        System.out.println("*********begin echo**********");
        System.out.println(object);
        System.out.println("*********end echo**********");
    }


}
