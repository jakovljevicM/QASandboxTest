package test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.ui.pages.objects.UseCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class CreateUseCasePage extends BasePage {

	@FindBy(name = "title")
	private WebElement fldTitle;
	private  String fldTitleLocatorName = "title";
	@FindBy(name = "description")
	private WebElement fldDescription;
	@FindBy(name = "expected_result")
	private WebElement fldExpectedResults;
	@FindBy(xpath = "//span[contains(.,'ADD STEP')]")
	private WebElement btnAddStep;
	@FindBy(css = ".pt-1:nth-child(2)")
	private WebElement btnAutomated;
	@FindBy(xpath = "//*[@id=\"switch\"]")
	private WebElement btnAutomatedCheck;
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement btnSubmit;
	@FindBy(css = ".form-group:nth-child(3) > .invalid-feedback")
	private WebElement textInvalidTitle;
	@FindBy(css = ".form-group:nth-child(5) > .invalid-feedback")
	private WebElement textInvalidExpectedResults;
	@FindBy(css = ".input-delete > .invalid-feedback")
	private WebElement textInvalidStep;
	@FindBy(css= ".btn-dark") 
	private WebElement btnDelete;
	@FindBy(css= ".btn-danger") 
	private WebElement btnDeleteConfirm;

	
	public CreateUseCasePage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(fldTitleLocatorName)));
	}
	
	public void createUseCase(UseCase useCase) {
		fldTitle.clear();
		fldTitle.sendKeys(useCase.getTitle());
		
		fldDescription.clear();
		fldDescription.sendKeys(useCase.getDescription());
		
		fldExpectedResults.clear();
		fldExpectedResults.sendKeys(useCase.getExpectedResult());
		
		for(int i = 0; i<useCase.getSteps().size(); i++) {
			WebElement step = driver.findElement(By.name("testStepId-"+i));
			step.clear();
			step.sendKeys(useCase.getSteps().get(i));
			btnAddStep.click();
		}
		
		if(useCase.isAutomated()) {
			btnAutomated.click();
		}
		
		btnSubmit.click();
		
	}
	
	public void checkUseCaseCreation(UseCase useCase) {
		Assert.assertEquals("Title is not as expected!", useCase.getTitle(), fldTitle.getAttribute("value"));
		Assert.assertEquals("Description is not as expected!", useCase.getDescription(), fldDescription.getAttribute("value"));
		Assert.assertEquals("Expected result is not as expected!", useCase.getExpectedResult(), fldExpectedResults.getAttribute("value"));

		for(int i = 0; i<useCase.getSteps().size(); i++) {
			WebElement step = driver.findElement(By.name("testStepId-"+i));
			Assert.assertEquals("Step "+ i+1 + " is not as expected!", useCase.getSteps().get(i), step.getAttribute("value"));
		}
		
		Assert.assertEquals("Is automated buton is not as expected!",  String.valueOf(useCase.isAutomated()), btnAutomatedCheck.getAttribute("value"));

		
	}

	public UseCase updateUseCase() {
		UseCase useCaseUpdated = new UseCase();
		int sizeText = fldTitle.getAttribute("value").length();
		String text = "This field previously had " + sizeText + " characters";
		useCaseUpdated.setTitle(text);
		fldTitle.clear();
		fldTitle.sendKeys(text);
		
		sizeText = fldDescription.getAttribute("value").length();
		text = "This field previously had " + sizeText + " characters";
		useCaseUpdated.setDescription(text);
		fldDescription.clear();
		fldDescription.sendKeys(text);
		
		sizeText = fldExpectedResults.getAttribute("value").length();
		text = "This field previously had " + sizeText + " characters";
		useCaseUpdated.setExpectedResult(text);
		fldExpectedResults.clear();
		fldExpectedResults.sendKeys(text);
		
		boolean hasSteps = true;
		for(int i = 0; hasSteps; i++) {
			List<String> steps = new ArrayList<String>();
			if (driver.findElements(By.name("testStepId-"+i)).size() == 0 ) {
				hasSteps = false;
				useCaseUpdated.setSteps(steps);
			} else {
				WebElement step = driver.findElement(By.name("testStepId-"+i));
			
				sizeText = step.getAttribute("value").length();
				text = "This field previously had " + sizeText + " characters";
				steps.add(text);
				
				
				step.clear();
				step.sendKeys(text);
			}
		}
		

		if( btnAutomatedCheck.getAttribute("value").equals("true")) {
			useCaseUpdated.setAutomated(true);
		}
		else {useCaseUpdated.setAutomated(false);}
		
		btnSubmit.click();
		
		return useCaseUpdated;
	}
	
	public void clickOnDeleteBtn() {
		btnDelete.click();
		btnDeleteConfirm.click();
	}
	
	public void checkInvalidMessagesExist() {
		 Assert.assertEquals("Invalid feedback message for field Title should be shown.", true, textInvalidTitle.isDisplayed()); 
		 Assert.assertEquals("Invalid feedback message for field Expected results should be shown.", true, textInvalidExpectedResults.isDisplayed()); 
		 Assert.assertEquals("Invalid feedback message for field Use Case step should be shown.", true, textInvalidStep.isDisplayed()); 
	}
}
