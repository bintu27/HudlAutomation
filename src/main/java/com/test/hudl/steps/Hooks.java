package com.test.hudl.steps;

import java.io.File;
import java.util.Date;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.test.hudl.utils.DriverUtils.getDriver;
import static com.test.hudl.utils.DriverUtils.tearDown;

public class Hooks {

    @Before("not @Api")
    public void setUp() {
        getDriver();
    }

    @After("not @Api")
    public void teardown() {
        tearDown();
    }

    @BeforeAll
    public static void beforeAll() {
        deleteOldReport();
    }

    @AfterStep("not @Api")
    /**************************************************************************************************
    Function to capture screenshots of each step
    **************************************************************************************************/

    public void afterStep(Scenario scenario) {
        Date currentDate = new Date();
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "image");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**************************************************************************************************
     Function to delete existing test execution report and screenshots
     **************************************************************************************************/
    public static void deleteOldReport() {

        String directory = "./test-output";
        File file = new File(directory);
        String[] currentFiles;
        if (file.isDirectory()) {
            currentFiles = file.list();
            for (int i = 0; i < currentFiles.length; i++) {
                File myFile = new File(file, currentFiles[i]);
                System.out.println("DelFile 12345" + myFile);
                myFile.delete();
            }
        }
    }
}
