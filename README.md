# Selenium Compare Fullpage Screenshots v2
*for Java and Maven*


This project is useful for website monitoring for any visual change.  

It offers the ability to use Chrome, Firefox, or Edge. There are 4 different full-page screenshot options: Selenide (CDP), Shutterbug, AShot, and Firefox/Selenium.

---


It comes with 2 tests ready for Maven:

### Create baseline images and put them in the "expected" folder at the root of the project  
`mvn "-Dtest=A*" test`  

---
### Create current images in the "observed" folder and diffs (if any) in the "diffs" folder.  
`mvn "-Dtest=B*" test`  

---
URLs for your test should be put in the [URLs.java](https://github.com/jpratt2/seleniumCompareFullpageScreenshotsv2/blob/master/src/test/java/screenshots/URLs.java) file.  

To get started, navigate to the Setup file in the "screenshots" package and select the browser and screenshot tool.

          // 1. Choose a browser by uncommenting a line below.
                      browser = "chrome";
                   // browser = "firefox";
                   // browser = "edge";      

          // 2. Enter the desired browser width and height in pixels
                    browserWidth = 1440;
                    browserHeight = 900;

          // 3. Select the screenshot tool by uncommenting one of the following lines.
                    // screenshotTool = "ashot";
                    // screenshotTool = "selenide"; 
                       screenshotTool = "shutterbug";
                    // screenshotTool = "firefox-selenium";



**The file name will be the URL (with forbidden characters replaced by a dash).**


---
See also version 1 of this tool for an easy way to configure Firefox's screenshot tool in Selenium. 
[https://github.com/jpratt2/seleniumCompareFullpageScreenshots](https://github.com/jpratt2/seleniumCompareFullpageScreenshots) 

---

[AShot](https://github.com/pazone/ashot) is used for the file comparison.  

It is necessary to check the diffs folder visually to see if there are any test failures.  

This project can be run in a virtual machine.

