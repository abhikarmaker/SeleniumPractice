import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NeweggAddingToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\abhij\\Downloads\\Softwares\\Chrome WebDriver\\chromedriver_win3265\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.newegg.ca/");
		driver.findElement(By.cssSelector("div[class='nav-complex-title']")).click();
		driver.findElement(By.name("signEmail")).sendKeys("Abhijeet.karmaker@yahoo.com");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Jagabandhu@1953");
		driver.findElement(By.name("signIn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("SearchBox2020")).sendKeys("Computer");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='header2020-search-button']")).click();

		String[] expectedProductNames = {
				"ABS Master Gaming PC - Intel i5 10400F - GeForce RTX 2060 - 16GB DDR4 - 512GB SSD",
				"Skytech - Gaming Desktop PC - AMD Ryzen 5 2600 (6-Core, 3.40 GHz), AMD Radeon RX 580 4 GB, 8 GB DDR4, 500 GB SSD, Wi-Fi, VR Ready, Windows 10 Home 64-bit, Archangel",
				"ABS Challenger Gaming PC - Intel i3 10100 - GeForce GTX 1650 Super - 8GB DDR4 3000MHz - 512GB SSD" };
		List<WebElement> actualListofProducts = driver.findElements(By.cssSelector("a[class='item-title']"));
		int j = 0;
		for (int i = 0; i < actualListofProducts.size(); i++) {
			String productName = actualListofProducts.get(i).getText();
			// System.out.println(productName);
			List<String> expectedProductNameList = Arrays.asList(expectedProductNames);

			if (expectedProductNameList.contains(productName)) {
				j++;
				driver.findElements(By.cssSelector("div[class='item-button-area']")).get(i).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("button[class='close']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Actual Product Name =" + productName);

				if (j == expectedProductNames.length) {
					break;
				}
			}
		}
		Thread.sleep(10000);
		// driver.quit();
	}

}
