import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://salesforce.com");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.cssSelector("#username")).sendKeys("Abhijeet");
		driver.findElement(By.cssSelector("#username")).sendKeys("Abhijeet");
	}

}
