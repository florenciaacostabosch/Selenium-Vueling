package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import Helpers.Helpers;

public class PageRegister {
	private WebDriver driver;
	private By nameField;
	private By lastNameField;
	private By emailField;
	private By passwordField;
	private By passwordConfirmField;
	private By securityQuestion1;
	private By securityQuestion2;
	private By securityAnswerField1;
	private By securityAnswerField2;
	private By acceptTerms;
	private By acceptPromo;
	private By register;
	private By nameFieldComplete;
	private By lastNameFieldComplete;
	private By emailFieldComplete;
	private By passwordFieldComplete;
	private By passwordConfirmFieldComplete;
	private By SecurityAnswer1FieldComplete;
	private By SecurityAnswer2FieldComplete;
	private By invalidEmail;
	private By invalidPassword;
	private By passwordNotMatch;
	
	public PageRegister(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to("https://tickets.vueling.com/Register.aspx?stamp=MV&_gl=1*1okdedx*_ga*MTc4Nzc4ODcwMi4xNzAxNDI2OTAy*_ga_Y2R5C29F9Q*MTcwMTYwNjU5NC4zLjAuMTcwMTYwNjU5NC42MC4wLjA.");
		Helpers.sleepSeconds(1);
		nameField = By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName");
		lastNameField = By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName");
		emailField = By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail");
		passwordField = By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldAgentPassword");
		passwordConfirmField= By.id("CONTROLGROUPREGISTERVIEW_MemberInputRegisterView_PasswordFieldPasswordConfirm");
		securityQuestion1 = By.id("CONTROLGROUPREGISTERVIEW_SecurityQuestionsRegisterView_FirstQuestion");
		securityQuestion2 = By.id("CONTROLGROUPREGISTERVIEW_SecurityQuestionsRegisterView_SecondQuestion");
		securityAnswerField1 = By.id("CONTROLGROUPREGISTERVIEW_SecurityQuestionsRegisterView_FirstAnswer");
		securityAnswerField2 = By.id("CONTROLGROUPREGISTERVIEW_SecurityQuestionsRegisterView_SecondAnswer");
		acceptTerms = By.xpath("//*[@id=\"memberRegister\"]/div/div[8]/div/div");
		acceptPromo = By.xpath("//*[@id=\"memberRegister\"]/div/div[7]/div/div/fieldset/label");
		register = By.xpath("//*[@id=\"CONTROLGROUPREGISTERVIEW_LinkButtonSubmit\"]/span");
		nameFieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[2]/div[1]/div/p");
		lastNameFieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[2]/div[2]/div/p");
		emailFieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[3]/div/div/p");
		passwordFieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[4]/div[1]/div/p");
		passwordConfirmFieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[4]/div[2]/div/p");
		SecurityAnswer1FieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[5]/div[2]/div/p");
		SecurityAnswer2FieldComplete = By.xpath("//*[@id=\"memberRegister\"]/div/div[6]/div[2]/div");
		invalidEmail = By.xpath("//*[@id=\"memberRegister\"]/div/div[3]/div/div/p");
		invalidPassword = By.xpath("//*[@id=\"memberRegister\"]/div/div[4]/div[1]/div/p");
		passwordNotMatch = By.xpath("//*[@id=\"memberRegister\"]/div/div[4]/div[2]/div/p");
	}
	
	public void completeForm (String name, String lastName, String email, String password, String confirmPassword, String answer1, String answer2) {
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(passwordConfirmField).sendKeys(confirmPassword);
		driver.findElement(securityAnswerField1).sendKeys(answer1);
		driver.findElement(securityAnswerField2).sendKeys(answer2);
		}
	
	public void selectSecurityQuestion1(String question1) {
		Select selectTo = new Select(driver.findElement(securityQuestion1));
		selectTo.selectByValue(question1);
		}
	
	public void selectSecurityQuestion2(String question2) {
		Select selectTo = new Select(driver.findElement(securityQuestion2));
		selectTo.selectByValue(question2);
		}
	
	public void acceptPromotions() {
		WebElement checkboxPromo = driver.findElement(acceptPromo);
			if (!checkboxPromo.isSelected()) {
				checkboxPromo.click();
	        	}
			}
	
	public void acceptTerms() {
		WebElement checkboxTerms = driver.findElement(acceptTerms);
		int width = checkboxTerms.getSize().getWidth();
		new Actions(driver).moveToElement(checkboxTerms).moveByOffset((width/2), 0).click().perform();
		Helpers.sleepSeconds(0.5);
		}
	
	public void register() {
		WebElement registerButton = driver.findElement(register);
		registerButton.click();
        }
	
	public boolean isRegisterConfirm() {
		String urlActual = driver.getCurrentUrl();
        return urlActual.equalsIgnoreCase("https://tickets.vueling.com/RegisterConfirm.aspx");
        }
	
	public boolean isNameFieldExists() {
		WebElement nameFieldExists = null;
			try {
				nameFieldExists=driver.findElement(nameFieldComplete);
				if(nameFieldExists != null) {
					if(nameFieldExists.getText().contains("Debes completar este campo")) {
						return true;
					}else {
						return false;
					}	
				}else {
					return false;
					}	
			} catch (NoSuchElementException e) {
				return false; 
				}	
		}
	
	public boolean isLastNameFieldExists() {
		WebElement lastNameFieldExists = null;
			try {
				lastNameFieldExists = driver.findElement(lastNameFieldComplete);
				if(lastNameFieldExists != null) {
					if(lastNameFieldExists.getText().contains("Debes completar este campo")) {
						return true;
					}else {
						return false;
					}	
				}else {
					return false;
			}	
			} catch (NoSuchElementException e) {
				return false; 
				}	
			}
	
	public boolean isEmailFieldExists() {
		WebElement emailFieldExists = null;
			try {
				emailFieldExists = driver.findElement(emailFieldComplete);
				if(emailFieldExists != null) {
					if(emailFieldExists.getText().contains("Debes completar este campo")) {
						return true;
					}else {
						return false;
					}	
				}else {
					return false;
					}	
			} catch (NoSuchElementException e) {
				return false; 
			}	
		}
			 
	public boolean isPasswordFieldExists() {
		WebElement passwordFieldExists = null;
			try {
				passwordFieldExists = driver.findElement(passwordFieldComplete);
				if(passwordFieldExists != null) {
					if(passwordFieldExists.getText().contains("Debes completar este campo")) {
						return true;
					}else {
						return false;
						}	
				}else {
					return false;
					}	
			} catch (NoSuchElementException e) {
				return false; 
			}	
		}
			 
	public boolean isPasswordConfirmFieldExists() {
		WebElement passwordConfirmFieldExists = null;
			try {
				passwordConfirmFieldExists = driver.findElement(passwordConfirmFieldComplete);
				if(passwordConfirmFieldExists != null) {
					if(passwordConfirmFieldExists.getText().contains("Debes completar este campo")) {
						return true;
					}else {
						return false;
					}	
				}else {
					return false;
					}	
			} catch (NoSuchElementException e) {
				return false; 
			}	
		}
			 
	public boolean isSecurityAnswer1FieldExists() {
		WebElement securityAnswer1FieldExists = null;
			try {
				securityAnswer1FieldExists = driver.findElement(SecurityAnswer1FieldComplete);
				if(securityAnswer1FieldExists != null) {
					if(securityAnswer1FieldExists.getText().contains("Debes completar este campo")) {
						return true;
					}else {
						return false;
						}	
				}else {
					return false;
					}	
			} catch (NoSuchElementException e) {
				return false; 
			}	
		}
			 
	public boolean isSecurityAnswer2FieldExists() {
		WebElement securityAnswer2FieldExists = null;
		WebElement elemento = null;
			try {
				elemento = driver.findElement(SecurityAnswer2FieldComplete);
				if(elemento != null) {
					securityAnswer2FieldExists = elemento.findElement(By.className("validationErrorDescription"));
					if(securityAnswer2FieldExists != null) {
						if(securityAnswer2FieldExists.getText().contains("Debes completar este campo")) {
							return true;
						}else {
							return false;
							}	
					}else {
						return false;
						}
					}else {
						return false;
					}
			} catch (NoSuchElementException e) {
				return false; 
			}	
		}
		 
	public boolean isInvalidEmailDetected() {
		WebElement invalidEmailDetected = null;
			try {
				invalidEmailDetected = driver.findElement(invalidEmail);
				if(invalidEmailDetected != null) {
					if(invalidEmailDetected.getText().contains("Los datos introducidos no son correctos")) {
						return true;
					}else {
					return false;
					}	
				}else {
					return false;
				}	
			} catch (NoSuchElementException e) {
				return false; 
			}	
		}
	
	public boolean isInvalidPasswordDetected() {
		WebElement invalidPasswordDetected = null;
			try {
				invalidPasswordDetected = driver.findElement(invalidPassword);
				if(invalidPasswordDetected != null) {
					if(invalidPasswordDetected.getText().contains("La contraseña introducida no es correcta")) {
						return true;
					}else {
						return false;
					}	
				}else {
					return false;
				}	
			} catch (NoSuchElementException e) {
		        return false; 
	        }	
		}
	
	public boolean isPasswordsNotMatchDetected() {
		WebElement passwordsNotMatchDetected = null;
			try {
				passwordsNotMatchDetected = driver.findElement(passwordNotMatch);
				if(passwordsNotMatchDetected != null) {
					if(passwordsNotMatchDetected.getText().contains("Las nuevas contraseñas no coinciden")) {
						return true;
					}else {
						return false;
					}	
				}else {
					return false;
				}	
			} catch (NoSuchElementException e) {
	        return false; 
			}	
		}
	}
	
	
	
	
	
	