package test.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	protected WebDriver driver;
	@FindBy(linkText = "Logout")
	protected WebElement tabLogout;
	@FindBy(css = ".fa")
	protected WebElement btnBack;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBackBtn() {
		btnBack.click();
	}
}
