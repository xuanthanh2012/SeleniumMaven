package testpackage;

import org.junit.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import resources.DP;
import resources.PageElements;

public class GetAccountNameTest extends BaseTest {
	PageElements pageElements;
	
	@Test(dataProvider = "testData", dataProviderClass = DP.class)
	public void getAccountName(String username, String password) {
		pageElements = new PageElements(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/");
        pageElements.enterUsername(username);
        pageElements.enterPassword(password);
        pageElements.clickLoginButton();
        Assert.assertNotEquals(pageElements.getAccountName(), "");
	}
}
