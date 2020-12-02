import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Abhijeet Karmaker
 *
 */
public class Basic1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		//Using ID
		/*driver.findElement(By.id("email")).sendKeys("abhijeetmax07@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("reborntobegin");*/
		//driver.findElement(By.name("login")).click();
		
		//Using CssSelectors
		//driver.findElement(By.cssSelector("//*[@id=\'Login\']")).sendKeys("abhijeet");
		//driver.findElement(by.)
		//driver.findElement(By.linkText("Forgot Password?")).click();
		//Thread.sleep(1000); //Its a inbuild function in Java
		//driver.close();
		
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("Abhijeet");
		driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("1234");
		driver.findElement(By.xpath("//button[@value='1']")).click();
	}

}
