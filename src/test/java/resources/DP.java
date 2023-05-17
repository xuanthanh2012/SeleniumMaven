package resources;

import org.testng.annotations.DataProvider;

public class DP {
	@DataProvider
	Object[][] testData() {
		return new Object[][] { { "Admin", "admin123" } };
	}
}
