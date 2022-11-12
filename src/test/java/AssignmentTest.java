import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;

public class AssignmentTest {

	@Test

	public void test() {
		// initialize sheet for parameterization
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath + "/excel/data.xlsx", "Sheet1");

		// get username & password from sheet
		String username = excel.getData(1, 0);
		String password = excel.getData(1, 1);

		// initialize chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		By[] buttonsBy = { 
				By.id("add-to-cart-sauce-labs-backpack"), 
				By.id("add-to-cart-sauce-labs-bike-light"),
				By.id("add-to-cart-sauce-labs-bolt-t-shirt"), 
				By.id("add-to-cart-sauce-labs-fleece-jacket"),
				By.id("add-to-cart-sauce-labs-onesie"), 
				By.id("add-to-cart-test.allthethings()-t-shirt-(red)") };

		int index1 = (int) (Math.random() * 6);
		int index2 = (int) (Math.random() * 6);
		int index3 = (int) (Math.random() * 6);

		while (index1 == index2 || index1 == index3 || index2 == index3) {
			
			index1 = (int) (Math.random() * 6);
			index2 = (int) (Math.random() * 6);
			index3 = (int) (Math.random() * 6);
			
		}
		 if (!(index1 == index2 || index1 == index3 || index2 == index3)) {
			WebElement button1 = driver.findElement(buttonsBy[index1]);
			button1.click();

			WebElement button2 = driver.findElement(buttonsBy[index2]);
			button2.click();

			WebElement button3 = driver.findElement(buttonsBy[index3]);
			button3.click();
		};

	}

}
