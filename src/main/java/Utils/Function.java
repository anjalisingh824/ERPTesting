package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Function {

	public static void Login(WebDriver driver, int row, String sheetName) throws Exception {
		// entering email id
		driver.findElement(By.xpath("//html/body/div/div[2]/div[1]/div/div[2]/form/div[1]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 1, sheetName));

		// entering password
		driver.findElement(By.xpath("//html/body/div/div[2]/div[1]/div/div[2]/form/div[3]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 2, sheetName));

		Thread.sleep(2000);

		// click on sign in
		driver.findElement(By.xpath("//html/body/div/div[2]/div[1]/div/div[2]/form/div[6]")).click();
		Thread.sleep(5000);

		Log.info("LOGIN SUCCESSFULLY DONE");
	}

	public static void addUser(WebDriver driver, int row) throws Exception {

		// first name
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[1]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));

		// last name
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div/div/div/div/form/div[2]/div[3]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME));

		// for selecting the role
		driver.findElement(By.id("select2-chosen-1")).click();
		Thread.sleep(5000);
		// WebElement select =
		// driver.findElement(By.className("select2-input"));
		// select.sendKeys("Si");
		String getFromExcel = ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME);
		boolean check = false;
		List<WebElement> element = driver.findElements(By.tagName("div"));
		System.out.println(element.size());
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(getFromExcel)) {

				WebElement elementClick = element.get(i);
				Thread.sleep(2000);
				elementClick.click();
				check = true;
				break;

			}

		}
		if (!check) {
			Thread.sleep(2000);
			element.get(1).click();
		}

		Thread.sleep(2000);

		// email
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[7]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME));

		// password
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[9]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME));

		// national id
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[11]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME));

		// pin number
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[13]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME));

		// contact number
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME));
		Thread.sleep(5000);

		// contact number(using key.Tab so that we can get the error for contact
		// number field
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(Keys.TAB);

		// upload a file

		driver.findElement(By.cssSelector("input[type=\"file\"]"))
				.sendKeys(ExcelUtils.getCellData(row, 9, Constant.SHEET_NAME));
		Thread.sleep(2000);
	}

	public static void addProject(WebDriver driver, int row) throws Exception {

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

	}

	public static void addTask(WebDriver driver, int row) throws Exception {
		// ACTIVITY
		driver.findElement(By.id("activityId_value")).sendKeys(ExcelUtils.getCellData(row, 1, Constant.SHEET_NAME));

		// sub activity
		driver.findElement(By.id("subActivityId_value")).sendKeys(ExcelUtils.getCellData(row, 2, Constant.SHEET_NAME));

		// task
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[4]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constant.SHEET_NAME));

		// assign contractor
		driver.findElement(By.id("contractorId_value")).sendKeys(ExcelUtils.getCellData(row, 4, Constant.SHEET_NAME));

		// start date
		driver.findElement(By.id("startDate")).sendKeys(ExcelUtils.getCellData(row, 5, Constant.SHEET_NAME));

		// end date
		driver.findElement(By.id("endDate")).sendKeys(ExcelUtils.getCellData(row, 6, Constant.SHEET_NAME));

		// total work
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[13]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 7, Constant.SHEET_NAME));

		// unit error
		driver.findElement(By.id("unitId_value")).sendKeys(ExcelUtils.getCellData(row, 8, Constant.SHEET_NAME));

		// RateUnit
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[15]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 9, Constant.SHEET_NAME));

		// bugdet
		driver.findElement(By.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[17]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 10, Constant.SHEET_NAME));

		// item
		driver.findElement(By.id("itemId0_value")).sendKeys(ExcelUtils.getCellData(row, 11, Constant.SHEET_NAME));

		// quantity
		driver.findElement(By
				.xpath("//html/body/div/div[3]/div/div[2]/div/div/div/form/div[2]/div[19]/table/tbody/tr/td[2]/input"))
				.sendKeys(ExcelUtils.getCellData(row, 12, Constant.SHEET_NAME));

		Thread.sleep(5000);
	}

}
