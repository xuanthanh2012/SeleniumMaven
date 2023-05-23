package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;


public class NavToOrangeHRM extends BaseTest {
	@Test
    public void testOpenBrowserAndNavigate() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
