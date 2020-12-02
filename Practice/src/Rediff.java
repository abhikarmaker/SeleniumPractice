import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();;
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Abhijeet");
		//driver.findElement(By.cssSelector("input[name='passwd']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("1234");
		driver.findElement(By.cssSelector("input[class='signinbtn']")).click();
	}

}
