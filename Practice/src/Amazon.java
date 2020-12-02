import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
		driver.findElement(By.cssSelector("div[id='nav-signin-tooltip']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("abhijeet.karmaker@yahoo.com");
		driver.findElement(By.id("continue")).click();
		// System.out.println(driver.findElement(By.cssSelector("span[class='a-list-item']")).getText());
		driver.findElement(By.id("ap_password")).sendKeys("Jagabandhu@1953");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer");
		driver.findElement(By.cssSelector("input[class='nav-input']")).click();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(10000);
		driver.quit();
	}

}
