package ERPTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.Function;
import Utils.Log;

public class AddProjectValidation {
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

		// get all the mandatory fields first

		// PROJECT NAME ERROR (CLICK ENTER SO THAT WE CAN CHECK FOR THE
		// MANDATORY FIELDS).
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/input"))
				.sendKeys(Keys.TAB);

		// SHORTNAME FOR PROJECT
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/input"))
				.sendKeys(Keys.TAB);

		// EMPLOYER NAME
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/input"))
				.sendKeys(Keys.TAB);

		// START DATE
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[6]/input"))
				.sendKeys(Keys.TAB);

		// END DATE
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[7]/input"))
				.sendKeys(Keys.TAB);

		// check for the errors present now

		// PROJECT NAME
		String checkError = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[1]"))
				.getText();
		if (checkError.contains(Constant.PROJECT_NAME_ERROR)) {
			Log.info("PROJECT NAME IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("PROJECT NAME IS REQUIRED ERROR IS NOT PRESENT");
		}

		// SHORT NAME
		String checkError1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/div[1]"))
				.getText();
		if (checkError1.contains(Constant.SHORT_NAME_ERROR)) {
			Log.info("SHORT NAME IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("SHORTNAME IS REQUIRED ERROR IS NOT PRESENT");
		}

		// EMPLOYER NAME
		String checkError2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/div[1]"))
				.getText();
		if (checkError2.contains(Constant.EMPLOYER_NAME_ERROR)) {
			Log.info("EMPLOYER NAME IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("EMPLOYER NAME IS REQUIRED ERROR IS NOT PRESENT");
		}

		// START DATE
		String checkError3 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[6]/div[2]"))
				.getText();
		if (checkError3.contains(Constant.START_DATE_ERROR)) {
			Log.info("START DATE IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("START DATE IS NOT REQUIRED ERROR IS NOT PRESENT");
		}

		// END DATE

		String checkError4 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[7]/div[2]"))
				.getText();
		if (checkError4.contains(Constant.END_DATE_ERROR)) {
			Log.info("END DATE IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("END DATE IS REQUIRED ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);
		Log.info("------------------------------------------------------------");

		// refresh the page
		driver.navigate().refresh();

		// passing validation value 1
		Function.addProject(driver, 14);

		// Error check

		// project name error
		String validationECheck = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (validationECheck.contains(Constant.VALID_PROJECTN_ERROR)) {
			Log.info("Project has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 14, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Project has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 14, 7, Constant.SHEET_NAME);

		}

		// project short name
		String validationECheck1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/div[2]"))
				.getText();
		if (validationECheck1.contains(Constant.VALID_SHORTN_ERROR)) {
			Log.info("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 14, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 14, 7, Constant.SHEET_NAME);

		}

		// employer name
		String validationECheck2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/div[2]"))
				.getText();
		if (validationECheck2.contains(Constant.VALID_EMPN_ERROR)) {
			Log.info("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 14, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 14, 7, Constant.SHEET_NAME);
		}

		// clearing the values for passing the next
		driver.navigate().refresh();
		Log.info("-----------------------------------------------------");
		Thread.sleep(2000);

		// passing validation value 2(NO ERROR WHILE PASSING VALUES FROM ROW 15
		// )
		Function.addProject(driver, 15);
		Log.info("------------------------------------------------------");

		// clearing the values for passing the next
		driver.navigate().refresh();

		// passing validation value 3
		Function.addProject(driver, 16);
		Log.info("--------------------------------------------------------");

		// clearing fields
		driver.navigate().refresh();

		// passing validation value 4
		Function.addProject(driver, 17);

		// error check
		// project name error
		String validationEChec = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (validationEChec.contains(Constant.VALID_PROJECTN_ERROR)) {
			Log.info("Project has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Project has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 7, Constant.SHEET_NAME);

		}

		// project short name
		String validationEChec1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/div[2]"))
				.getText();
		if (validationEChec1.contains(Constant.VALID_SHORTN_ERROR)) {
			Log.info("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 7, Constant.SHEET_NAME);

		}

		// employer name
		String validationEChec2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/div[2]"))
				.getText();
		if (validationEChec2.contains(Constant.VALID_EMPN_ERROR)) {
			Log.info("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 17, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 17, 7, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();
		Log.info("---------------------------------------------------------");

		// passing validation value 5
		Function.addProject(driver, 18);
		// error check
		// project name error
		String validationErrorChec = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (validationErrorChec.contains(Constant.VALID_PROJECTN_ERROR)) {
			Log.info("Project has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 18, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Project has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 18, 7, Constant.SHEET_NAME);

		}

		// project short name
		String validationErrorChec1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/div[2]"))
				.getText();
		if (validationErrorChec1.contains(Constant.VALID_SHORTN_ERROR)) {
			Log.info("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 18, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 18, 7, Constant.SHEET_NAME);

		}

		// employer name
		String validationErrorChec2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/div[2]"))
				.getText();
		if (validationErrorChec2.contains(Constant.VALID_EMPN_ERROR)) {
			Log.info("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 18, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 18, 7, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();
		Log.info("----------------------------------------------------------");

		// passing validation value 6
		Function.addProject(driver, 19);

		// error check
		// project name error
		String validationEC = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (validationEC.contains(Constant.VALID_PROJECTN_ERROR)) {
			Log.info("Project has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Project has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 19, 7, Constant.SHEET_NAME);

		}

		// project short name
		String validationEC1 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[2]/div[2]"))
				.getText();
		if (validationEC1.contains(Constant.VALID_SHORTN_ERROR)) {
			Log.info("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Short Name has to be an alphanumeric value (2-10 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 19, 7, Constant.SHEET_NAME);

		}

		// employer name
		String validationEC2 = driver
				.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[4]/div[2]"))
				.getText();
		if (validationEC2.contains(Constant.VALID_EMPN_ERROR)) {
			Log.info("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 19, 7, Constant.SHEET_NAME);

		} else {
			Log.error("Employee Name has to be an alphanumeric value (4-100 Chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 19, 7, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();
		Log.info("--------------------------------------------------------");

		// passing validation value 7
		Function.addProject(driver, 20);
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[10]/div/input")).click();
		Thread.sleep(1000);
		// error check
		if (driver.getPageSource().contains(Constant.ADDP_NAME_EXISTS)) {
			Log.info("NAME ALREADY EXISTS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 20, 7, Constant.SHEET_NAME);
		} else {
			Log.error("NAME ALREADY EXISTS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 20, 7, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);
		Log.info("---------------------------------------------------------");

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 8
		Function.addProject(driver, 21);
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[10]/div/input")).click();
        Thread.sleep(1000);
		// error check
		if (driver.getPageSource().contains(Constant.ADDP_SHORTN_EXISTS)) {
			Log.info("SHORT NAME ALREADY EXISTS ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 21, 7, Constant.SHEET_NAME);
		} else {
			Log.error("SHORT NAME ALREADY EXISTS ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 21, 7, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);
		Log.info("---------------------------------------------------------");

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
