package Test;
import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Conditions {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.vueling.com/es");
		Helpers.sleepSeconds(1);
		WebElement buttonAcceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
			if (buttonAcceptCookies != null){
				buttonAcceptCookies.click();
				}
			}
		}
	
