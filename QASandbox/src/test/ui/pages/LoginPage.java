package test.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(name = "email")
	private WebElement fldEmail;
	@FindBy(name = "password")
	private WebElement fldPassword;
	@FindBy(css = ".btn")
	private WebElement btnSubmit;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String email, String password) {
		fldEmail.clear();
		fldEmail.sendKeys(email);
		
		fldPassword.clear();
		fldPassword.sendKeys(password);
		
		btnSubmit.click();	
		
	}


}
