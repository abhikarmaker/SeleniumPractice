import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "G:\\Work\\Selenium\\Selenium Udemy Learning\\Download\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");	
		
		//Selecting Radio button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//Selection of Dynamic Drop Down From and To
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HBX']")).click();
		
		//Radio Button Check is enabled or not
		
		//driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		
		//DatePicker Current date
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		
		//ReturnDate is disabled
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("This is disabled");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//Selecting PaxAdult and Child
		driver.findElement(By.id("divpaxinfo")).click();
		Select sAdult = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		sAdult.selectByValue("2");
		Select sChild = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		sChild.selectByValue("2");
		
		//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult");
		//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult");
		
		
		//Select Currency
		Select cur = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		cur.selectByValue("INR");
		
		
		//Selection of CheckBox and Validating with Assert
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		
		
		//Number of checkbox present
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//Search Button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.quit();
		
	}

}
