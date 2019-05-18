package com.TecIT.LMS.Tests;

import com.TecIT.LMS.pages.LoginPage;
import com.TecIT.LMS.testData.LoginData;
import com.TecIT.LMS.utils.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static com.TecIT.LMS.pages.LoginPage.clickLogout;

public class LoginTest extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(LoginTest.class);

    @Test(priority = 0, groups = "REGRESSION", dataProviderClass = LoginData.class, dataProvider = "Login", testName = "Login")
    public void Login(String username, String Password, String status, String alertmsg) {
        extentTest=extentReport.startTest(" Login ");
        softAssert.assertTrue(LoginPage.isLoginPageDisplay(), "login page display");
        LoginPage.login(username, Password);

        if(status.equals("valid")) {
            softAssert.assertTrue(LoginPage.isDashboadDisplay());
            LOGGER.info("Login success");
            LoginPage.clickLogout();
            LoginPage.Logout();
        }
        else {

            LoginPage.isLoginAlertDisplay();
            LoginPage.getLoginAlert();
            softAssert.assertEquals(LoginPage.isLoginAlertDisplay(),alertmsg);
            LOGGER.info(alertmsg);
        }


        extentReport.endTest(extentTest);
    }
}