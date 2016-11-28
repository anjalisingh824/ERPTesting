package ERPTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Log;

public class AddUser {

	private WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ExcelUtils.getTableArray(Constant.FILE_FULL_PATH, Constant.SHEET_NAME);

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
		int row1 = 12;

		// click on the add user button
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div[1]/div/div[2]/a/i")).click();
		Thread.sleep(2000);

		// first name
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 1, Constant.SHEET_NAME));

		// last name
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[3]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 2, Constant.SHEET_NAME));

		// for selecting the role
		driver.findElement(By.id("select2-chosen-1")).click();
		Thread.sleep(5000);
		// WebElement select =
		// driver.findElement(By.className("select2-input"));
		// select.sendKeys("Si");
		String getFromExcel = ExcelUtils.getCellData(row1, 3, Constant.SHEET_NAME);
		boolean check = false;
		List<WebElement> element = driver.findElements(By.tagName("div"));
		System.out.println(element.size());
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(getFromExcel)) {

				WebElement elementClick = element.get(i);
				System.out.println(elementClick);
				Thread.sleep(2000);
				elementClick.click();
				check = true;
				break;

			}

		}
		if (!check) {
			element.get(1).click();
		}

		Thread.sleep(2000);

		// email
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 4, Constant.SHEET_NAME));

		// password
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[9]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 5, Constant.SHEET_NAME));

		// national id
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 6, Constant.SHEET_NAME));

		// pin number
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 7, Constant.SHEET_NAME));

		// contact number
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(ExcelUtils.getCellData(row1, 8, Constant.SHEET_NAME));
		Thread.sleep(5000);

		// click on the add user button
		driver.findElement(By.xpath("//*[@id='userModal']/div/div/form/div[3]/div/input")).click();
		Thread.sleep(1000);
		if (driver.getPageSource().contains(Constant.USER_ADDED_SCSMSG)) {
			Log.info("USER IS ADDED SUCCESSFULLY MESSAGE IS PRESENT");
			ExcelUtils.setCellData("PASS", row1, 10, Constant.SHEET_NAME);
		} else

		{
			Log.error("USER IS NOT ADDED SUCCESSFULLY");
			ExcelUtils.setCellData("FAIL", row1, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
