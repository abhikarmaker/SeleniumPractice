import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartAddingItems {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// Expected Array, declare an array with list of products what you want to
		// select and pass that to for loop block and if it mentioned select the product

		int j = 0;
		String[] expectedProductName = { "Brocolli", "Cucumber", "Cauliflower", "Mango" };
		// Then build sudo pseudo code
		Thread.sleep(3000);
		List<WebElement> productVeggies = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < productVeggies.size(); i++) {
			String[] actualProductName = productVeggies.get(i).getText().split("-");
			// check whether name you extracted is present in this whole array or not
			// Convert the array into array list for easy search
			// name[0]- Brocolli & name[1] - 1 Kg

			String formattedActualProductName = actualProductName[0].trim();
			// System.out.println(formattedActualProductName);
			List<String> productList = Arrays.asList(expectedProductName);
			// System.out.println(productList);

			if (productList.contains(formattedActualProductName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// Code came here 3 times and all the items are matched the condition
				if (j == expectedProductName.length)
					// System.out.println("true");
					break;
			}
		}
		driver.quit();
	}

}
