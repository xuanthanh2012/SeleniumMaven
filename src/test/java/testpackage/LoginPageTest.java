package testpackage;

import org.testng.Assert;
import org.testng.annotations.*;

import basetest.BaseTest;
import resources.DP;
import resources.PageElements;

public class LoginPageTest extends BaseTest {
    PageElements pageElements;

    @Test(dataProvider = "testData", dataProviderClass = DP.class)
    public void testLoginWithAccount(String username, String password) {
    	pageElements = new PageElements(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        pageElements.enterUsername(username);
        pageElements.enterPassword(password);
        pageElements.clickLoginButton();
        Assert.assertEquals(pageElements.getTitleHRM(),"OrangeHRM");
    }
}


