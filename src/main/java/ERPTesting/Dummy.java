package ERPTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Log;

public class Dummy {

	private WebDriver driver;
	boolean check = false;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test()
	public void testERP() throws Exception {

		// check for the title of the login page
		Assert.assertTrue(Constant.LOGIN_TITLE_CHECK.contains(driver.getTitle()));
		Log.info("TITLE IS MATCHED");
		Thread.sleep(5000);

		// login
		int row = 1;
		// entering email id
		driver.findElement(By.xpath("//html/body/div/div[2]/div[1]/div/div[2]/form/div[1]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));

		// entering password
		driver.findElement(By.xpath("//html/body/div/div[2]/div[1]/div/div[2]/form/div[3]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME));

		Thread.sleep(2000);

		// click on sign in
		driver.findElement(By.xpath("//html/body/div/div[2]/div[1]/div/div[2]/form/div[6]")).click();
		Thread.sleep(5000);

		Log.info("LOGIN SUCCESSFULLY DONE");

		// click on the user icon in the left corner for adding the user
		driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/ul/li[5]/a/img")).click();

		Thread.sleep(2000);

		// click on the add user button
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div[1]/div/div[2]/a/i")).click();
		Thread.sleep(5000);
		
		// upload a file
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='userModal']/div/div/form/div[2]/div[17]/div/div/label/span")));
		Thread.sleep(2000);
		action.sendKeys("/home/smart/Desktop/cat1.jpg").perform();
		Thread.sleep(5000);
	
		
		
		
		
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
