package com.TecIT.LMS.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.TecIT.LMS.utils.PageBase.driver;

public class ExtentReportFunctions {

    private static String screenShotFolderPath = System.getProperty("user.dir") + "/src/test/resources/screenshots/";

    public static String getTimeStamp(String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public static String getFilePath() {

        String filename = getTimeStamp("yyyy-mm-dd_hh-mm-ss")+".jpg";
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File file = new File(screenShotFolderPath + filename);
        try {
            FileUtils.copyFile(screenshotFile, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }

}
