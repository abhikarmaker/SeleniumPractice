import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//div[@class='SDkEP']/div[2]/input")).sendKeys("facebook");//ParentChile xpath concept
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();//Customized xpath concept
		driver.findElement(By.xpath("//div[@id='gbw']/div/div/div/div[2]/a")).click();
	}

}
