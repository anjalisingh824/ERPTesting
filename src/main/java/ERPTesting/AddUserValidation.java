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

public class AddUserValidation {

	private WebDriver driver;
	boolean check = false;

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
		Function.Login(driver, 1, Constant.SHEET_NAME);

		// click on the user icon in the left corner for adding the user
		driver.findElement(By.xpath("//html/body/div/div[2]/div[2]/ul/li[5]/a/img")).click();

		Thread.sleep(5000);

		// click on the add user button
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div[1]/div/div[2]/a/i")).click();
		Thread.sleep(2000);

		// check for the mandatory fields as the add user button is disabled.

		// first name
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/input"))
				.sendKeys(Keys.TAB);

		// last name
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[3]/input"))
				.sendKeys(Keys.TAB);

		// email
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/input"))
				.sendKeys(Keys.TAB);

		// password
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[9]/input"))
				.sendKeys(Keys.TAB);

		// national id
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/input"))
				.sendKeys(Keys.TAB);

		// pin number
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/input"))
				.sendKeys(Keys.TAB);

		// contact number
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(Keys.TAB);

		// check for the errors

		// first name error after tab
		String fnameError = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[1]"))
				.getText();
		if (fnameError.contains(Constant.FIRSTNAME_ERROR)) {
			Log.info("FIRSTNAME IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("FIRSTNAME IS REQUIRED ERROR IS NOT REQUIRED");
		}

		Thread.sleep(2000);

		// lastname error after tab
		String lnameError = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[3]/div[1]"))
				.getText();
		if (lnameError.contains(Constant.LASTNAME_ERROR)) {
			Log.info("LASTNAME IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("LASTNAME IS REQUIRED ERROR IS NOT REQUIRED");
		}

		Thread.sleep(2000);

		// email id error after tab

		String emailIdError = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/div[1]"))
				.getText();
		if (emailIdError.contains(Constant.EMAIL_ERROR)) {
			Log.info("EMAIL ID IS REQUIRED ERROR IS PRESENT");
		}

		else {
			Log.error("EMAIL ID ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);

		// password error
		String passwordError = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[9]/div[1]"))
				.getText();
		if (passwordError.contains(Constant.PASSWORD_ERROR)) {
			Log.info("PASSWORD IS REQUIRED ERROR IS PRESENT");
		}

		else {
			Log.error("PASSWORD IS REQUIRED ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);

		// national id error
		String nationalIdError = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/div[1]"))
				.getText();
		if (nationalIdError.contains(Constant.NATIONALID_ERROR)) {
			Log.info("NATIONAL ID IS REQUIRED ERROR IS PRESENT");
		}

		else {
			Log.error("NATIONAL ID IS REQUIRED ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);

		// mobile number error
		String mobileNoError = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/div[1]"))
				.getText();
		if (mobileNoError.contains(Constant.MOBILENO_ERROR)) {
			Log.info("MOBILE NUMBER IS REQUIRED ERROR IS PRESENT");
		} else {
			Log.error("MOBILE NUMBER IS REQUIRED ERROR IS NOT PRESENT");
		}

		Thread.sleep(2000);

		// passing validation value from row 3 calling function
		Function.addUser(driver, 3);
		Thread.sleep(5000);

		// check for the errors

		// first name error
		String Error = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (Error.contains(Constant.VALID_FIRSTNAME_ERROR)) {
			Log.info("First Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);
		} else {
			Log.error("First Name has to be an alphanumeric value (4-50 Digits).IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// last name error check
		String error1 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[3]/div[2]"))
				.getText();
		if (error1.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// email error address check
		String error2 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/div[2]"))
				.getText();
		if (error2.contains(Constant.VALID_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ID ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);
		} else {
			Log.error("ENTER VALID EMAIL ID ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// error check for password
		String error3 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[9]/div[2]"))
				.getText();
		if (error3.contains(Constant.VALID_PASSWORD_ERROR)) {
			Log.info("Password has to be an alphanumeric and special char.(6 to 12 char.) ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Password has to be an alphanumeric and special char.(6 to 12 char.)ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for national id
		String error4 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/div[2]"))
				.getText();
		if (error4.contains(Constant.VALID_NATIONALID_ERROR)) {
			Log.info("National ID has to be a numeric value (8 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);

		} else {
			Log.error("National ID has to be a numeric value (8 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for pin no
		String error5 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/div"))
				.getText();
		if (error5.contains(Constant.VALID_PINNUMBER_ERROR)) {
			Log.info("PIN No has to be an alphanumeric value (11 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);

		} else {
			Log.error("PIN No has to be an alphanumeric value (11 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);

		}

		Thread.sleep(2000);

		// error check for contact number
		String error6 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/div[2]"))
				.getText();
		if (error6.contains(Constant.VALID_MOBILENO_ERROR)) {
			Log.info("Mobile No. has to be a numeric value (10-14 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 3, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Mobile No. has to be a numeric value (10-14 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 3, 10, Constant.SHEET_NAME);
		}

		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// valiation value 2 from row 4
		Function.addUser(driver, 4);

		// check for the errors

		// first name error
		String err = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (err.contains(Constant.VALID_FIRSTNAME_ERROR)) {
			Log.info("First Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);
		} else {
			Log.error("First Name has to be an alphanumeric value (4-50 Digits).IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// last name error check
		String err1 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[3]/div[2]"))
				.getText();
		if (err1.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// email error address check
		String err2 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/div[2]"))
				.getText();
		if (err2.contains(Constant.VALID_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ID ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);
		} else {
			Log.error("ENTER VALID EMAIL ID ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// error check for password
		String err3 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[9]/div[2]"))
				.getText();
		if (err3.contains(Constant.VALID_PASSWORD_ERROR)) {
			Log.info("Password has to be an alphanumeric and special char.(6 to 12 char.) ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Password has to be an alphanumeric and special char.(6 to 12 char.)ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for national id
		String err4 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/div[2]"))
				.getText();
		if (err4.contains(Constant.VALID_NATIONALID_ERROR)) {
			Log.info("National ID has to be a numeric value (8 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);

		} else {
			Log.error("National ID has to be a numeric value (8 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for pin no
		String err5 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/div"))
				.getText();
		if (err5.contains(Constant.VALID_PINNUMBER_ERROR)) {
			Log.info("PIN No has to be an alphanumeric value (11 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);

		} else {
			Log.error("PIN No has to be an alphanumeric value (11 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);

		}

		Thread.sleep(2000);

		// error check for contact number
		String err6 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/div[2]"))
				.getText();
		if (err6.contains(Constant.VALID_MOBILENO_ERROR)) {
			Log.info("Mobile No. has to be a numeric value (10-14 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 4, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Mobile No. has to be a numeric value (10-14 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 4, 10, Constant.SHEET_NAME);
		}

		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// taking validation values 3
		Function.addUser(driver, 5);

		// error check
		// first name error
		String errorCheck = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (errorCheck.contains(Constant.VALID_FIRSTNAME_ERROR)) {
			Log.info("First Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 5, 10, Constant.SHEET_NAME);
		} else {
			Log.error("First Name has to be an alphanumeric value (4-50 Digits).IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 5, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// last name error check
		String errorCheck1 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[3]/div[2]"))
				.getText();
		if (errorCheck1.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 5, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 5, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// email error address check
		String errorCheck2 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/div[2]"))
				.getText();
		if (errorCheck2.contains(Constant.VALID_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ID ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 5, 10, Constant.SHEET_NAME);
		} else {
			Log.error("ENTER VALID EMAIL ID ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 5, 10, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);
		// error check for national id
		String errorCheck3 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/div[2]"))
				.getText();
		if (errorCheck3.contains(Constant.VALID_NATIONALID_ERROR)) {
			Log.info("National ID has to be a numeric value (8 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 5, 10, Constant.SHEET_NAME);

		} else {
			Log.error("National ID has to be a numeric value (8 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 5, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for pin no
		String errorCheck4 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/div"))
				.getText();
		if (errorCheck4.contains(Constant.VALID_PINNUMBER_ERROR)) {
			Log.info("PIN No has to be an alphanumeric value (11 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 5, 10, Constant.SHEET_NAME);

		} else {
			Log.error("PIN No has to be an alphanumeric value (11 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 5, 10, Constant.SHEET_NAME);

		}

		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// taking validation value 4
		Function.addUser(driver, 6);

		// check for the errors
		// first name error
		String errCheck = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[1]/div[2]"))
				.getText();
		if (errCheck.contains(Constant.VALID_FIRSTNAME_ERROR)) {
			Log.info("First Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 10, Constant.SHEET_NAME);
		} else {
			Log.error("First Name has to be an alphanumeric value (4-50 Digits).IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// last name error check
		String errCheck1 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[3]/div[2]"))
				.getText();
		if (errCheck1.contains(Constant.VALID_LASTNAME_ERROR)) {
			Log.info("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Last Name has to be an alphanumeric value (4-50 Digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// email error address check
		String errCheck2 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/div[2]"))
				.getText();
		if (errCheck2.contains(Constant.VALID_EMAIL_ERROR)) {
			Log.info("ENTER VALID EMAIL ID ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 10, Constant.SHEET_NAME);
		} else {
			Log.error("ENTER VALID EMAIL ID ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 10, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// error check for national id
		String errCheck4 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/div[2]"))
				.getText();
		if (errCheck4.contains(Constant.VALID_NATIONALID_ERROR)) {
			Log.info("National ID has to be a numeric value (8 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 10, Constant.SHEET_NAME);

		} else {
			Log.error("National ID has to be a numeric value (8 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for pin no
		String errCheck3 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/div"))
				.getText();
		if (errCheck3.contains(Constant.VALID_PINNUMBER_ERROR)) {
			Log.info("PIN No has to be an alphanumeric value (11 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 10, Constant.SHEET_NAME);

		} else {
			Log.error("PIN No has to be an alphanumeric value (11 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 10, Constant.SHEET_NAME);

		}

		Thread.sleep(2000);

		// error check for contact number
		String errCheck5 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/div[2]"))
				.getText();
		if (errCheck5.contains(Constant.VALID_MOBILENO_ERROR)) {
			Log.info("Mobile No. has to be a numeric value (10-14 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 6, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Mobile No. has to be a numeric value (10-14 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 6, 10, Constant.SHEET_NAME);
		}

		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// passing validation value 5
		Function.addUser(driver, 7);
		// click on the add user button so that we can get the error for the
		// email already exist.
		driver.findElement(By.xpath("//*[@id='userModal']/div/div/form/div[3]/div/input")).click();
		Thread.sleep(1000);

		// check for the error email already exist
		if (driver.getPageSource().contains(Constant.EMAIL_EXIST_ERROR)) {

			Log.info("EMAIL ALREADY EXISTS, ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 7, 10, Constant.SHEET_NAME);
		} else {
			Log.error("EMAIL ALREADY EXISTS, ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 7, 10, Constant.SHEET_NAME);
		}

		Thread.sleep(2000);

		// clearing the fields
		driver.navigate().refresh();

		// taking validation value 6
		Function.addUser(driver, 8);
		// click on the add user button so that we can get the error for nationa
		// id already exists.
		driver.findElement(By.xpath("//*[@id='userModal']/div/div/form/div[3]/div/input")).click();
		Thread.sleep(1000);

		// catching the errors(national id already exist)

		if (driver.getPageSource().contains(Constant.NATIONALID_EXIST_ERROR)) {

			Log.info("NATIONAL ID ALREADY EXISTS, ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 8, 10, Constant.SHEET_NAME);
		} else {
			Log.error("NATIONAL ID ALREADY EXISTS, ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 8, 10, Constant.SHEET_NAME);
		}

		Thread.sleep(2000);

		// refresh the page for getting new values from excel
		driver.navigate().refresh();

		// taking validation value 7
		Function.addUser(driver, 9);
		// click on the add user button so that we can get the error for pin
		// number already exists.
		driver.findElement(By.xpath("//*[@id='userModal']/div/div/form/div[3]/div/input")).click();
		Thread.sleep(1000);

		if (driver.getPageSource().contains(Constant.PIN_NO_EXIST_ERROR)) {
			Log.info("PIN NUMBER ALREADY EXISTS, ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 9, 10, Constant.SHEET_NAME);
		} else {
			Log.error("PIN NUMBER ALREADY EXISTS ,ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 9, 10, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// refresh the page for getting new values from excel
		driver.navigate().refresh();

		// taking validation value 8
		Function.addUser(driver, 10);

		// click on the add user button so that we can get the error for contact
		// number already exists.
		driver.findElement(By.xpath("//*[@id='userModal']/div/div/form/div[3]/div/input")).click();
		Thread.sleep(1000);
		if (driver.getPageSource().contains(Constant.MOBILENO_ERROR)) {
			Log.info("MOBILE NUMBER ALREADY EXISTS, ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 10, 10, Constant.SHEET_NAME);
		} else {
			Log.error("MOBILE NUMBER ALREADY EXISTS ,ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 10, 10, Constant.SHEET_NAME);
		}
		Thread.sleep(2000);

		// refresh the page for getting new values from excel
		driver.navigate().refresh();

		// taking validation value 8
		Function.addUser(driver, 11);

		// error check for national id
		String errors2 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/div[2]"))
				.getText();
		if (errors2.contains(Constant.VALID_NATIONALID_ERROR)) {
			Log.info("National ID has to be a numeric value (8 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 11, 10, Constant.SHEET_NAME);

		} else {
			Log.error("National ID has to be a numeric value (8 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 11, 10, Constant.SHEET_NAME);

		}
		Thread.sleep(2000);

		// error check for pin no
		String errors = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/div"))
				.getText();
		if (errors.contains(Constant.VALID_PINNUMBER_ERROR)) {
			Log.info("PIN No has to be an alphanumeric value (11 chars).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 11, 10, Constant.SHEET_NAME);

		} else {
			Log.error("PIN No has to be an alphanumeric value (11 chars).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 11, 10, Constant.SHEET_NAME);

		}

		Thread.sleep(2000);

		// error check for contact number
		String errors1 = driver
				.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/div[2]"))
				.getText();
		if (errors1.contains(Constant.VALID_MOBILENO_ERROR)) {
			Log.info("Mobile No. has to be a numeric value (10-14 digits).ERROR IS PRESENT");
			ExcelUtils.setCellData("PASS", 11, 10, Constant.SHEET_NAME);

		} else {
			Log.error("Mobile No. has to be a numeric value (10-14 digits).ERROR IS NOT PRESENT");
			ExcelUtils.setCellData("FAIL", 11, 10, Constant.SHEET_NAME);
		}

		Thread.sleep(2000);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
