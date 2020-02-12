package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TheInternetHerokuappComPageObjects;

public class TheInternetHerokuappComPageTest {
	static WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		String projectpath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectpath +"/drivers/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();

	}

	@Test
	public void theinternetherokuapppage() {

		TheInternetHerokuappComPageObjects   internetherokuapppageobj = new TheInternetHerokuappComPageObjects(driver);

		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		internetherokuapppageobj.javascriptalertslinkclick();

		internetherokuapppageobj.buttonclick();

		driver.switchTo().alert().accept(); //clicking on OK button or accepting the alert

		WebElement result = internetherokuapppageobj.resultconfirm(); 
		String result1 = result.getText().toString();
		try {
			Assert.assertEquals(result1, "You clicked: Ok");//verifying the Result
		} catch (AssertionError e) {
			System.out.println("Not equal");
			throw e;
		}
		System.out.println("Equal");

	}

	@AfterTest
	public void teardownTest() {

		driver.close();//close the browser
		driver.quit();
		System.out.println("Test Completed Successfully");//success message
	}

}





