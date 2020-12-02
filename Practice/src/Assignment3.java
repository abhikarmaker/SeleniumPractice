import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");	
		
		//Current Date selected
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		Thread.sleep(1000);
		
		//Static Drop Down for no of passenger adults and child
		Select sAdults = new Select(driver.findElement(By.id("Adults")));
		sAdults.selectByValue("2");
		Thread.sleep(1000);
		Select sChildrens = new Select(driver.findElement(By.id("Childrens")));
		sChildrens.selectByValue("2");
		Thread.sleep(1000);
		
		//clicking on link
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		Thread.sleep(1000);
		
		//Entering value to the inout box
		String airline = "Emirates";
		driver.findElement(By.name("airline")).sendKeys(airline);
		
		driver.findElement(By.id("SearchBtn")).click();
		Thread.sleep(1000);
		
		//Getting the error message and printing
		System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());
		
		driver.close();
	}

}
