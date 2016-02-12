package Testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Simple_Login {
	private WebDriver driver;
	//private WebDriver wait;
	
	@BeforeClass(description="Launching Firefox Driver")
	public void setup()
	{
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTraining\\SeleniumSoftwares\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver", "D:\\SeleniumTraining\\SeleniumSoftwares\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		
	//	wait = new WebDriverWait(driver,30);
		System.out.println("Webdriver has started");
	}
	
	@Test(description="Launch The-Internet site",priority=1)
		public void simple_login()
	{
	driver.get("http://the-internet.herokuapp.com/login");
	driver.manage().window().maximize();
	System.out.println("Maximizing Browser");
	}
	
	@Test(description="Navigating to Simple Login Page",priority=2)
	public void simple_loginCheck()
	{	
		System.out.println("Login Page Loaded");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='flash']")));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed(),"success message not present");
		System.out.println("login Successfully");
	}
	@Test(description="logoff functionality check",priority=3)
	public void simple_logoutcheck()
	{
		driver.findElement(By.xpath(".//a[@href='/logout']")).click();
		System.out.println("Logged out successfully");
	}
	
	@AfterClass(description="closing browser instance")
	public void Tear_down()
	{
		System.out.println("Quitting WebDriver");
		driver.quit();
		
	}

}
