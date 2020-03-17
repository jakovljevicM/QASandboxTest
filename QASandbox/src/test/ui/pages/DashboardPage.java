package test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage{
	
	private String cardUseCaseLocatorCss =  ".col-sm-3:nth-child(2) .card-title";
	@FindBy(css = ".col-sm-3:nth-child(2) .card-title")
	private WebElement cardUseCases;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cardUseCaseLocatorCss)));
	}
	
	public void goToUseCasesPage() {
		cardUseCases.click();
		
	}

}
