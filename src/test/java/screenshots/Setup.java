package screenshots;


public class Setup {
     public static String browser, screenshotTool;
     static int browserWidth, browserHeight, pause;
 
{
//////////////////////////////////  PLEASE MAKE SELECTIONS BELOW  ////////////////////////////////////////////////////////////////////   
     
          // 1. Choose a browser by uncommenting a line below.
                     browser = "chrome";
                    // browser = "firefox";
                    // browser = "edge";        

          // 2. Enter the desired browser width and height in pixels
                    browserWidth = 1366;
                    browserHeight = 768;

          // 3. Select the screenshot tool by uncommenting one of the following lines.
                   //  screenshotTool = "ashot";
                    screenshotTool = "selenide"; 
                   // screenshotTool = "shutterbug";
                    // screenshotTool = "firefox-selenium";

          // 4. Delay in milliseconds for the page to finish loading prior to the screenshot. 
                    pause = 5000; 
                    
          //Please note: the most reliable screenshot tool is probably firefox-selenium.
          //For Chrome, selenide is the next best option.
                    

////////////////////////////////////////////////////////////////////////////////////////////////////        
}      


 

           
        
     
}

     



