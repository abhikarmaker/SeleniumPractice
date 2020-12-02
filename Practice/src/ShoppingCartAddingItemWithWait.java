import java.util.Arrays;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartAddingItemWithWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Implicit wait time globally initialized
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		//Explicit WebDriver initialization
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// Expected Array, declare an array with list of products what you want to
		// select and pass that to for loop block and if it mentioned select the product

		String[] expectedProductName = { "Brocolli", "Cucumber", "Cauliflower", "Mango" };
		// Then build sudo pseudo code
		Thread.sleep(3000);

		// Concept 1
		// Using static in method, we can directly call the function in the main method
		addItems(driver, expectedProductName, w);
		
		// Concept 2
		// For calling the function without static, we need to call the base class by
		// using object eg below, here in the method addItems does not need to use
		// static
		// ShoppingCartAddingItemWithWait s = new ShoppingCartAddingItemWithWait();
		// ShoppingCartAddingItemWithWait.addItems(driver, expectedProductName);
		Thread.sleep(3000);
		driver.quit();
	}

	//
	public static void addItems(WebDriver driver, String[] expectedProductName, WebDriverWait w) {
		int j = 0;
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
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");//At this point it will not enter the input into the textbox and will throw an error no such element found, We need to use wait concept
		
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		//Explicit WebDriverWait Concept, step 1 comment the implicit wait time in global
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());//Worked with Implicit wait, now comment out the implicit wait time in base main class, the test will fail
	}
}
