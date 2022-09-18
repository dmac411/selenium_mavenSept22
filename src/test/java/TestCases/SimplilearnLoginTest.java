package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;

public class SimplilearnLoginTest extends BaseClass {

	@Test
	public void Test1() {

		// log test info in test.log
		test.log(LogStatus.INFO, "test1 started");
		LoginPage lp = new LoginPage(driver);
		lp.Login("abc@xyz.com", "Abc@1234");

		// Step6: Validate the error message on screen
		WebElement Error = driver.findElement(By.id("msg_box"));

		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";

		Assert.assertTrue(Error.isDisplayed());
		Assert.assertEquals(ActError, ExpError);

	}

	@Test
	@Parameters({ "uname", "pwd" })
	public void Test2(String UserName, String Password) {

		test.log(LogStatus.INFO, "test2 started");
		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName, Password);
	}

	@Test
	public void Test3() {

		test.log(LogStatus.INFO, "test3 started");
		String UserName = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();

		LoginPage lp = new LoginPage(driver);
		lp.Login(UserName, Password);
	}

}
