package com.TecIT.LMS.pages;

import com.TecIT.LMS.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class LoginPage extends PageBase {

    public SoftAssert softAssert;

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    private static By headerLogin = By.xpath("/html/body/app-root/app-login/div/div/div/div/div[1]/h4");
    private static By txtUserName = By.id("userName");
    private static By txtPassword = By.id("password");
    private static By btnLogin = By.id("btnLogin");
   // private static By alert = By.id("spanMessage");
   public static By dashHeader = By.xpath("/html/body/app-root/div/div/app-top-nav/nav/div/div[1]/span");
   public static By clickLogout = By.xpath("//*[@id=\"navbarDropdownMenuLink1\"]/i");
   public static By logOut = By.xpath("/html/body/app-root/div/div/app-top-nav/nav/div/div[2]/ul/li[2]/div/a");
   public static By alert =By.id("alert-danger");

    public static boolean isLoginPageDisplay() {

        return getDriver().findElement(headerLogin).isDisplayed();
    }

    public static void setUserName(String userName) {

        getDriver().findElement(txtUserName).sendKeys(userName);
    }

    public static void setPassword(String password) {
        getDriver().findElement(txtPassword).sendKeys(password);
    }

    public static void clickLogin() {
        getDriver().findElement(btnLogin).click();
    }

    public static boolean isDashboadDisplay() { return getDriver().findElement(dashHeader).isDisplayed(); }


    public static void clickLogout(){getDriver().findElement(clickLogout).click();}

    public static void Logout(){getDriver().findElement(logOut).click();}


    public static boolean isLoginAlertDisplay() {
        return getDriver().findElement(alert).isDisplayed();
    }

    public static String getLoginAlert() {
        return  getDriver().findElement(alert).getText();
    }


    public static void login(String userName, String password,String status,String alertMSg) {
        if(status=="valid") {
            implicitWait(5);
            LoginPage.setUserName(userName);
            LoginPage.setPassword(password);
            LoginPage.clickLogin();
            LOGGER.info("DashBoardPage is displayed");

            LoginPage.
            LOGGER.info("logout success");


        }
        else {
            LoginPage.setUserName(userName);
            LoginPage.setPassword(password);
            LoginPage.clickLogin();
            LOGGER.info(alertMSg);

        }

    }
    public static void login(String userName, String password) {

        LoginPage.setUserName(userName);
        LoginPage.setPassword(password);
        LoginPage.clickLogin();

    }

}
