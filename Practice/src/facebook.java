import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Abhijeet Karmaker
 *
 */
public class facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		//Customized css from html attributes
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Abhijeet");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Abhijeet");
		driver.findElement(By.cssSelector("[value='1']")).click();
	}

}
