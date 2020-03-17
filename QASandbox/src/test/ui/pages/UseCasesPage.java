package test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UseCasesPage extends BasePage{

	private String textUseCaseLocatorXpath = "//b[contains(.,'Use Cases')]";
	@FindBy(linkText="CREATE USE CASE")
	private WebElement btnCreateUseCase;
	private String btnLatestCreatedUSeCaseLocatorCss = ".list-group-item:nth-child(1)";
	@FindBy(css = ".list-group-item:nth-child(1)")
	private WebElement btnLatestCreatedUseCase;
	
	public UseCasesPage(WebDriver driver) {
		super(driver);
	}

	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textUseCaseLocatorXpath)));
	}
	
	public void waitForLatestCreatedUseCaseBtn() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnLatestCreatedUSeCaseLocatorCss)));
	}
	
	public void clickOnCreateUseCaseBtn() {
		btnCreateUseCase.click();
	}
	
	public void clickOnLatestCreated() {
		btnLatestCreatedUseCase.click();
	}
	
	public void clickOnUseCase(int number) {
		driver.findElement(By.cssSelector(".list-group-item:nth-child("+number+")")).click();
	}
}
