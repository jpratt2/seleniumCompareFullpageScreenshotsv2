# Selenium Compare Fullpage Screenshots
*for Java and Maven*


This project is useful for website monitoring on production for any visual change.  

It uses Selenium 4 to take full-page screenshots in Firefox. It compares a baseline image against a current image to generate a diff image with differences highlighted in red. If there is no difference, no diff image is made.

---

It comes with 2 tests ready for Maven:

### Create baseline images and put them in the "expected" folder at the root of the project  
`mvn "-Dtest=A*" test`  

---
### Create current images in the "observed" folder and diffs (if any) in the "diffs" folder.  
`mvn "-Dtest=B*" test`  

---
URLs for your test should be put here: [src/test/java/URLs.java](https://github.com/jpratt2/seleniumCompareFullpageScreenshots/blob/master/src/test/java/URLs.java).  

Basic syntax for a full-page screenshot:  
`Screenshot.fullpage(driver);` 

Basic syntax to compare a full-page screenshot against the corresponding image in the "expected" folder:  
`Screenshot.compareImage(driver);`
 
Additionally, the acceptance level can be set with a "pixelThreshold" value which is the amount of pixels that can be different and still be considered acceptable as a match. 
For example:
`Screenshot.compareImage(driver, 100)`

**The file name will be the URL (with forbidden characters replaced by a dash).**

An example of use:
```
            driver.get(URL);
            Thread.sleep(3000);//wait for the page to fully load
            Screenshot.compareImage(driver);
```
I recommend a delay for the page to fully load.  
[AShot](https://github.com/pazone/ashot) is used for the file comparison.  

It is necessary to check the diffs folder visually to see if there are any test failures.  

This project can be run in a virtual machine.

