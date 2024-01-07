package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Helpers.Helpers;

public class PageHome {
	private WebDriver driver;
	private By registerButton;
	private By signUpButton;

	public PageHome(WebDriver driver) {
		this.driver = driver;
		registerButton = By.id("optionRegister-login-menu");
		signUpButton = By.id("singUp-button");
		}
	
	public void register() {
		driver.findElement(registerButton).click();
		Helpers.sleepSeconds(1);
		driver.findElement(signUpButton).click();
		}
	}
