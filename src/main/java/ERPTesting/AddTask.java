package ERPTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import Utils.Function;
import Utils.Log;

public class AddTask {

	private WebDriver driver;

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
		Function.Login(driver, 1, Constant.SHEET_NAME);

		// click on the menu button for clicking on the project menu
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/div[1]/img")).click();
		Thread.sleep(2000);

		// clicking on the project module in the left side corner
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/ul/li[2]/a/span")).click();
		Thread.sleep(2000);

		// click on the project that i added
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div[10]/div/div[1]/div/a/div/img")).click();
		Thread.sleep(5000);

		// click on add task button in the right side corner

		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div[1]/div/div[2]/a/i")).click();
		Thread.sleep(2000);

		// passing validation value 1

		int row = 28;
		// ACTIVITY
		driver.findElement(By.id("activityId_value")).sendKeys("Ac");
		List<WebElement> search = driver.findElements(By.tagName("div"));
		System.out.println(search.size());
		String store = ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME);
		for (int i = 0; i < search.size(); i++) {
			if (search.get(i).getText().contains(store)) {

				driver.findElement(By.xpath("//div[@id='activityId_dropdown']/div[4]/div")).click();
				Thread.sleep(2000);
				break;
			}
		}

		// sub activity

		driver.findElement(By.id("subActivityId_value")).sendKeys("ne");
		List<WebElement> search1 = driver.findElements(By.tagName("div"));
		System.out.println(search1.size());
		String store1 = ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME);
		for (int i = 0; i < search1.size(); i++) {
			if (search1.get(i).getText().contains(store1)) {

				driver.findElement(By.xpath("//div[@id='subActivityId_dropdown']/div[3]/div")).click();
				Thread.sleep(2000);
				break;
			}
		}

		// task
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[4]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME));

		// assign contractor
		driver.findElement(By.id("contractorId_value")).sendKeys("ne");
		List<WebElement> search2 = driver.findElements(By.tagName("div"));
		System.out.println(search2.size());
		String store2 = ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME);
		for (int i = 0; i < search2.size(); i++) {
			if (search2.get(i).getText().contains(store2)) {

				driver.findElement(By.xpath("//div[@id='contractorId_dropdown']/div[3]/div")).click();
				Thread.sleep(2000);
				break;
			}

		}

		// START DATE
		driver.findElement(By.id("startDate")).click();
		Thread.sleep(2000);
		List<WebElement> element = driver.findElements(By.tagName("td"));

		String store3 = ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME);
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().contains(store3)) {
				WebElement elementClick = element.get(i);
				Thread.sleep(5000);
				elementClick.click();
				Thread.sleep(2000);
				break;
			}
		}

		Thread.sleep(5000);

		// END DATE
		driver.findElement(By.id("endDate")).click();
		Thread.sleep(2000);
		List<WebElement> element1 = driver.findElements(By.tagName("td"));

		String store4 = ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME);
		for (int i = 0; i < element1.size(); i++) {
			if (element1.get(i).getText().contains(store4)) {
				WebElement elementClick = element1.get(i);
				Thread.sleep(5000);
				elementClick.click();
				Thread.sleep(2000);
				break;
			}
		}

		// total work
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[13]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME));

		// unit error
		driver.findElement(By.id("unitId_value")).sendKeys("To");

		List<WebElement> search6 = driver.findElements(By.tagName("div"));
		System.out.println(search6.size());
		String store6 = ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME);
		for (int i = 0; i < search6.size(); i++) {
			if (search6.get(i).getText().contains(store6)) {

				driver.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[14]/span/angucomplete-alt/div/div/div[3]/div")).click();
				Thread.sleep(2000);
				break;
			}

		}

		// RateUnit
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 9, Constant.SHEET_NAME));

		// bugdet
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[17]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 10, Constant.SHEET_NAME));

		// item
		driver.findElement(By.id("itemId0_value")).sendKeys("Bl");
		List<WebElement> search5 = driver.findElements(By.tagName("div"));
		System.out.println(search5.size());
		String store5 = ExcelUtils.getCellData(row, 11, Constant.SHEET_NAME);
		for (int i = 0; i < search5.size(); i++) {
			if (search5.get(i).getText().contains(store5)) {

				driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[1]/span/angucomplete-alt/div/div/div[3]/div")).click();
				Thread.sleep(2000);
				break;
			}

		}

		// quantity
		driver.findElement(By
				.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[2]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 12, Constant.SHEET_NAME));

	
	
	   //click on add task
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[4]/div/input")).click();
		
		Thread.sleep(5000);
	
	
	
	}

	 @AfterTest
	 public void closeBrowser() {
	 driver.quit();
	 }

}
