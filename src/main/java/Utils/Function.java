package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Function {

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

		// // upload a file
		// WebElement
		// upload=driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div/div/div/div/form/div[2]/div[17]/div/div/label/span"));
		//

		// Thread.sleep(5000);

	}

}
