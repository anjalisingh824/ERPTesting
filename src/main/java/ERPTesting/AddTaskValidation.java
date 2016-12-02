package ERPTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class AddTaskValidation {

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

		// click on the project that i added
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div[10]/div/div[1]/div/a/div/img")).click();
		Thread.sleep(2000);

		// click on add task button in the right side corner

		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div[1]/div/div[2]/a/i")).click();
		Thread.sleep(2000);

		// start pressing enter so that we can check for the mandatory errors

		// ACTIVITY
		driver.findElement(By.id("activityId_value")).sendKeys(Keys.TAB);

		// sub activity
		driver.findElement(By.id("subActivityId_value")).sendKeys(Keys.TAB);

		// task
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[4]/input"))
				.sendKeys(Keys.TAB);

		// assign contractor
		driver.findElement(By.id("contractorId_value")).sendKeys(Keys.TAB);

		// default rate
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[6]/input"))
				.sendKeys(Keys.TAB);

		// start date
		driver.findElement(By.id("startDate")).sendKeys(Keys.TAB);

		// end date
		driver.findElement(By.id("endDate")).sendKeys(Keys.TAB);

		// total work
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[13]/input"))
				.sendKeys(Keys.TAB);

		// unit error
		driver.findElement(By.id("unitId_value")).sendKeys(Keys.TAB);

		// RateUnit
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(Keys.TAB);

		// bugdet
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[17]/input"))
				.sendKeys(Keys.TAB);

		// item
		driver.findElement(By.id("itemId0_value")).sendKeys(Keys.TAB);

		// quantity
		driver.findElement(By
				.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[2]/input"))
				.sendKeys(Keys.TAB);

		// now check for the errors
		// activity
		String errorCheck = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div/span[1]"))
				.getText();
		if (errorCheck.contains(Constant.ACTIVITY_ERROR)) {
			Log.info("ACTIVITY IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("ACTIVITY IS REQUIRED ERROR IS NOT PRESENT");
		}
		// sub activity
		String errorcheck1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[2]/div/span[1]"))
				.getText();
		if (errorcheck1.contains(Constant.SUB_ACTIVITY_ERROR)) {
			Log.info("SUB ACTIVITY IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("SUB ACTIVITY IS REQUIRED ERROR IS NOT PRESENT");
		}

		// task
		String errorcheck2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[4]/div[1]"))
				.getText();
		if (errorcheck2.contains(Constant.TASK_ERROR)) {
			Log.info("TASK IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("TASK IS REQUIRED ERROR IS NOT PRESENT");
		}

		// assign contractor
		String errorCheck3 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[5]/div/span[1]"))
				.getText();
		if (errorCheck3.contains(Constant.ASSIGN_C_ERROR)) {
			Log.info("ASSIGN CONTRACTOR IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("ASSIGN CONTRACTOR IS REQUIRED ERROR IS NOT PRESENT");
		}

		// default rate
		String errorCheck4 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[6]/div[1]"))
				.getText();
		if (errorCheck4.contains(Constant.DEFAULT_R_ERROR)) {
			Log.info("DEFAULT RATE  IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("DEFAULT RATE IS REQUIRED ERROR IS NOT PRESENT");
		}

		// start date
		String errorCheck5 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[8]/div[2]"))
				.getText();
		if (errorCheck5.contains(Constant.START_DATE_ERROR)) {
			Log.info("START DATE IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("START DATE IS REQUIRED ERROR IS NOT PRESENT");
		}

		// end date
		String errorCheck6 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[9]/div[2]"))
				.getText();
		if (errorCheck6.contains(Constant.END_DATE_ERROR)) {
			Log.info("END DATE IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("END DATE IS REQUIRED ERROR IS NOT PRESENT");
		}

		// total work
		String errorCheck7 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[13]/div[1]"))
				.getText();
		if (errorCheck7.contains(Constant.TOTAL_WORK_ERROR)) {
			Log.info("TOTAL WORK IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("TOTAL WORK IS REQUIRED ERROR IS NOT PRESENT");
		}

		// unit
		String errorCheck8 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[14]/div/span[1]"))
				.getText();
		if (errorCheck8.contains(Constant.UNIT_ERROR)) {
			Log.info("UNIT IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("UNIT IS REQUIRED ERROR IS NOT PRESENT");
		}

		// rate/unit
		String errorCheck9 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[15]/input"))
				.getText();
		if (errorCheck9.contains(Constant.RUNIT_ERROR)) {
			Log.info("RATE UNIT IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("RATE UNIT IS REQUIRED ERROR IS NOT PRESENT");
		}

		// bugdet
		String errorCheck10 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[17]/div[1]"))
				.getText();
		if (errorCheck10.contains(Constant.BUGDET_ERROR)) {
			Log.info("BUGDET IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("BUGDET IS REQUIRED ERROR IS NOT PRESENT");
		}

		// item
		String errorCheck11 = driver
				.findElement(By
						.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[1]/div/span[1]"))
				.getText();
		if (errorCheck11.contains(Constant.ITEM_ERROR)) {
			Log.info("ITEM IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("ITEM IS REQUIRED ERROR IS NOT PRESENT");
		}

		// quantity
		String errorCheck12 = driver
				.findElement(By
						.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[2]/div[1]"))
				.getText();
		if (errorCheck12.contains(Constant.QUANTITY_ERROR)) {
			Log.info("QUANTITY IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("QUANTITY IS REQUIRED ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);
		Log.info("------------------------------------------------------");

		// passing validation value 1

		Function.addTask(driver, 24);
		Thread.sleep(2000);

		// getting errors

		// activity error
		String getError = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div/span[2]"))
				.getText();
		if (getError.contains(Constant.VALID_ACTIVITY_E)) {
			Log.info("ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 24, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 24, 13, Constant.SHEET_NAME);
		}

		// sub activity error
		String getError1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[2]/div/span[1]"))
				.getText();
		if (getError1.contains(Constant.VALID_SUBAC_E)) {
			Log.info("SUB ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 24, 13, Constant.SHEET_NAME);
		} else {
			Log.error("SUB ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 24, 13, Constant.SHEET_NAME);
		}

		// assign contractor error
		String getError2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[5]/div/span[2]"))
				.getText();
		if (getError2.contains(Constant.VALID_ASSIGNC_E)) {
			Log.info("ASSIGN CONTRACTOR NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 24, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ASSIGN CONTRACTOR NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 24, 13, Constant.SHEET_NAME);
		}

		// unit error
		String getError3 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[14]/div/span[2]"))
				.getText();
		if (getError3.contains(Constant.VALID_UNITE)) {
			Log.info("UNIT NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 24, 13, Constant.SHEET_NAME);
		} else {
			Log.error("UNIT NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 24, 13, Constant.SHEET_NAME);
		}

		// item details error
		String getError4 = driver
				.findElement(By
						.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[1]/div/span[2]"))
				.getText();
		if (getError4.contains(Constant.VALID_ITEMD_E)) {
			Log.info("ITEM DETAILS NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 24, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ITEM DETAILS NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 24, 13, Constant.SHEET_NAME);
		}
		Thread.sleep(5000);

		// clearing the field
		driver.navigate().refresh();
		Thread.sleep(2000);
		Log.info("----------------------------------------------------");

		// passing validation value 2
		Function.addTask(driver, 25);
		Thread.sleep(2000);

		// getting errors

		// activity error
		String getError5 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div/span[2]"))
				.getText();
		if (getError5.contains(Constant.VALID_ACTIVITY_E)) {
			Log.info("ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 25, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 25, 13, Constant.SHEET_NAME);
		}

		// sub activity error
		String getError6 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[2]/div/span[1]"))
				.getText();
		if (getError6.contains(Constant.VALID_SUBAC_E)) {
			Log.info("SUB ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 25, 13, Constant.SHEET_NAME);
		} else {
			Log.error("SUB ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 25, 13, Constant.SHEET_NAME);
		}

		// assign contractor error
		String getError7 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[5]/div/span[2]"))
				.getText();
		if (getError7.contains(Constant.VALID_ASSIGNC_E)) {
			Log.info("ASSIGN CONTRACTOR NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 25, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ASSIGN CONTRACTOR NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 25, 13, Constant.SHEET_NAME);
		}

		// unit error
		String getError8 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[14]/div/span[2]"))
				.getText();
		if (getError8.contains(Constant.VALID_UNITE)) {
			Log.info("UNIT NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 25, 13, Constant.SHEET_NAME);
		} else {
			Log.error("UNIT NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 25, 13, Constant.SHEET_NAME);
		}

		// item details error
		String getError10 = driver
				.findElement(By
						.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[1]/div/span[2]"))
				.getText();
		if (getError10.contains(Constant.VALID_ITEMD_E)) {
			Log.info("ITEM DETAILS NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 25, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ITEM DETAILS NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 25, 13, Constant.SHEET_NAME);
		}
		Thread.sleep(5000);

		// clearing the fields
		driver.navigate().refresh();
		Thread.sleep(2000);
		Log.info("-----------------------------------------------------");

		// passing validation value 3
		Function.addTask(driver, 26);

		// getting errors

		// activity error
		String getErr = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div/span[2]"))
				.getText();
		if (getErr.contains(Constant.VALID_ACTIVITY_E)) {
			Log.info("ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 26, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 26, 13, Constant.SHEET_NAME);
		}

		// sub activity error
		String getErr1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[2]/div/span[1]"))
				.getText();
		if (getErr1.contains(Constant.VALID_SUBAC_E)) {
			Log.info("SUB ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 26, 13, Constant.SHEET_NAME);
		} else {
			Log.error("SUB ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 26, 13, Constant.SHEET_NAME);
		}

		// assign contractor error
		String getErr2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[5]/div/span[2]"))
				.getText();
		if (getErr2.contains(Constant.VALID_ASSIGNC_E)) {
			Log.info("ASSIGN CONTRACTOR NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 26, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ASSIGN CONTRACTOR NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 26, 13, Constant.SHEET_NAME);
		}

		// unit error
		String getErr3 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[14]/div/span[2]"))
				.getText();
		if (getErr3.contains(Constant.VALID_UNITE)) {
			Log.info("UNIT NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 26, 13, Constant.SHEET_NAME);
		} else {
			Log.error("UNIT NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 26, 13, Constant.SHEET_NAME);
		}

		// item details error
		String getErr4 = driver
				.findElement(By
						.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[1]/div/span[2]"))
				.getText();
		if (getErr4.contains(Constant.VALID_ITEMD_E)) {
			Log.info("ITEM DETAILS NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 26, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ITEM DETAILS NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 26, 13, Constant.SHEET_NAME);
		}
		Thread.sleep(5000);

		// clearing fields
		driver.navigate().refresh();
		Thread.sleep(2000);
		Log.info("----------------------------------------------------");

		// passing validation value 4
		Function.addTask(driver, 27);

		// activity error
		String getErr5 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[1]/div/span[2]"))
				.getText();
		if (getErr5.contains(Constant.VALID_ACTIVITY_E)) {
			Log.info("ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 27, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 27, 13, Constant.SHEET_NAME);
		}

		// sub activity error
		String getErr6 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[2]/div/span[1]"))
				.getText();
		if (getErr6.contains(Constant.VALID_SUBAC_E)) {
			Log.info("SUB ACTIVITY NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 27, 13, Constant.SHEET_NAME);
		} else {
			Log.error("SUB ACTIVITY NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 27, 13, Constant.SHEET_NAME);
		}

		// assign contractor error
		String getErr7 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[5]/div/span[2]"))
				.getText();
		if (getErr7.contains(Constant.VALID_ASSIGNC_E)) {
			Log.info("ASSIGN CONTRACTOR NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 27, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ASSIGN CONTRACTOR NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 27, 13, Constant.SHEET_NAME);
		}

		// unit error
		String getErr8 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[14]/div/span[2]"))
				.getText();
		if (getErr8.contains(Constant.VALID_UNITE)) {
			Log.info("UNIT NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 27, 13, Constant.SHEET_NAME);
		} else {
			Log.error("UNIT NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 27, 13, Constant.SHEET_NAME);
		}

		// item details error
		String getErr9 = driver
				.findElement(By
						.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[1]/div/span[2]"))
				.getText();
		if (getErr9.contains(Constant.VALID_ITEMD_E)) {
			Log.info("ITEM DETAILS NOT FOUND ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 27, 13, Constant.SHEET_NAME);
		} else {
			Log.error("ITEM DETAILS NOT FOUND ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 27, 13, Constant.SHEET_NAME);
		}
		Thread.sleep(5000);
		Log.info("----------------------------------------------------");

	}

	 @AfterTest
	 public void closeBrowser() {
	 driver.quit();
	 }
}