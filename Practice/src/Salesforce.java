import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Abhijeet Karmaker
 *
 */
public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://salesforce.com");
		driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.id("username")).sendKeys("abhijeetmax07@gmail.com");
		driver.findElement(By.cssSelector("#username")).sendKeys("Abhijeet");
		driver.findElement(By.id("password")).sendKeys("reborntobegin");
		driver.findElement(By.name("Login")).click();
		//driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();//Using XPath
		//driver.findElement(By.xpath("//*[@id=\'forgot_password_link\']")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
		
		
		//Thread.sleep(1000); //Its a inbuild function in Java
		//driver.close();
	}

}
