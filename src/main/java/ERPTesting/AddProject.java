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
import Utils.Function;
import Utils.Log;

public class AddProject {
	private WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/smart/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ExcelUtils.getTableArray(Constant.FILE_FULL_PATH,
		// Constant.SHEET_NAME);

	}

	@Test()
	public void testERP() throws Exception {

		// check for the title of the login page
		Assert.assertTrue(Constant.LOGIN_TITLE_CHECK.contains(driver.getTitle()));
		Log.info("TITLE IS MATCHED");
		Thread.sleep(5000);

		// login
		Function.Login(driver, 1, Constant.SHEET_NAME);

		// click on the menu button for clicking on the project menu
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/div[1]/img")).click();
		Thread.sleep(2000);

		// clicking on the project module in the left side corner
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/ul/li[2]/a/span")).click();
		Thread.sleep(2000);

		// click on the add project for adding the project
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div[1]/div/a/div/div/div")).click();
		Thread.sleep(2000);

		int row = 22;
		// PROJECT NAME ERROR
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));

		// SHORTNAME FOR PROJECT
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME));

		// EMPLOYER NAME
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME));

		Thread.sleep(5000);

		// START DATE
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[6]/input")).click();
		Thread.sleep(2000);
		List<WebElement> element = driver.findElements(By.tagName("td"));

		String store = ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME);
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(store)) {
				WebElement elementClick = element.get(i);
				Thread.sleep(5000);
				elementClick.click();
				Thread.sleep(2000);
				break;
			}
		}

		Thread.sleep(5000);

		// END DATE
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[7]/input")).click();
		Thread.sleep(2000);
		List<WebElement> element1 = driver.findElements(By.tagName("td"));

		String store1 = ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME);
		for (int i = 0; i < element1.size(); i++) {
			if (element1.get(i).getText().contains(store1)) {
				WebElement elementClick = element1.get(i);
				Thread.sleep(5000);
				elementClick.click();
				Thread.sleep(2000);
				break;
			}
		}
		// upload file
		driver.findElement(By.cssSelector("input[type=\"file\"]"))
				.sendKeys(ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME));
		Thread.sleep(2000);
		
		
		//click on add project
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[10]/div/input")).click();
		Thread.sleep(5000);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
