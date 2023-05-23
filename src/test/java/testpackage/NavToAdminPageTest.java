package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import resources.DP;
import resources.PageElements;

public class NavToAdminPageTest extends BaseTest {
	PageElements pageElements;
	
	@Test(dataProvider = "testData", dataProviderClass = DP.class)
	public void navToAdmin(String username, String password) {
		pageElements = new PageElements(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
        pageElements.enterUsername(username);
        pageElements.enterPassword(password);
        pageElements.clickLoginButton();
        pageElements.navToAdminButton();
        Assert.assertEquals(pageElements.verifyAdminPage(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
	}
}
