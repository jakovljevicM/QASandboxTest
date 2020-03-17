package test.java;

import java.util.Arrays;

import org.junit.Test;

import test.ui.pages.CreateUseCasePage;
import test.ui.pages.DashboardPage;
import test.ui.pages.UseCasesPage;
import test.ui.pages.objects.UseCase;

public class UseCaseTest extends BaseTest {

	@Test
	public void createUseCasesWithBoundaryValue() {
		
		System.out.println("TEST createUseCasesWithBoundaryValue STARTED");

		UseCase useCases[] = new UseCase[2];

		// values have 5 characters
		UseCase useCase = new UseCase();
		useCase.setTitle("12345");
		useCase.setDescription("Description for automated test case.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("12345");
		useCase.setSteps(Arrays.asList(new String[] { "1" }));
		useCases[0] = useCase;

		// values have 255 characters
		useCase = new UseCase();
		useCase.setTitle(
				"testetstttdettstdtsdtstdstdtstdtsdtstdtsdtsta dastdsa dt asdt asd ast das dastd sta ta dta dtastdtasatsdtaa st da sdtas dtatsda  dtatdatsd a sdta sdtatsd ats dta dta dta dtatsdatsd tastda tsdtasdta dtatsdtatadstastdatsd tatd ast tadaj dgajsdgjashgdjashgdd");
		useCase.setDescription("Description for automated test case.");
		useCase.setAutomated(true);
		useCase.setExpectedResult(
				"testetstttdettstdtsdtstdstdtstdtsdtstdtsdtsta dastdsa dt asdt asd ast das dastd sta ta dta dtastdtasatsdtaa st da sdtas dtatsda  dtatdatsd a sdta sdtatsd ats dta dta dta dtatsdatsd tastda tsdtasdta dtatsdtatadstastdatsd tatd ast tadaj dgajsdgjashgdjashgdd");
		useCase.setSteps(Arrays.asList(new String[] {
				"testetstttdettstdtsdtstdstdtstdtsdtstdtsdtsta dastdsa dt asdt asd ast das dastd sta ta dta dtastdtasatsdtaa st da sdtas dtatsda  dtatdatsd a sdta sdtatsd ats dta dta dta dtatsdatsd tastda tsdtasdta dtatsdtatadstastdatsd tatd ast tadaj dgajsdgjashgdjashgdd" }));
		useCases[1] = useCase;

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.goToUseCasesPage();
		UseCasesPage useCasesPage = new UseCasesPage(driver);
		useCasesPage.waitForPage();
		CreateUseCasePage createUseCasePage = new CreateUseCasePage(driver);

		for (int i = 0; i < useCases.length; i++) {
			System.out.println("Create use case");
			useCasesPage.clickOnCreateUseCaseBtn();
			createUseCasePage.waitForPage();
			createUseCasePage.createUseCase(useCases[i]);
			useCasesPage.waitForLatestCreatedUseCaseBtn();

			System.out.println("Validate creation");
			useCasesPage.clickOnLatestCreated();
			createUseCasePage.checkUseCaseCreation(useCases[i]);
			System.out.println("Delete use case");
			createUseCasePage.clickOnDeleteBtn();
			useCasesPage.waitForPage();
		}

		System.out.println("TEST createUseCasesWithBoundaryValue FINISHED");
	}

	@Test
	public void createUseCasesWithInvalidFields() {

		System.out.println("TEST createUseCasesWithInvalidFields STARTED");
		UseCase useCases[] = new UseCase[3];

		// values under 5 characters
		UseCase useCase = new UseCase();
		useCase.setTitle("Auto");
		useCase.setDescription("Description for automated test case.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("EXP.");
		useCase.setSteps(Arrays.asList(new String[] { "" }));
		useCases[0] = useCase;

		// values without characters
		useCase = new UseCase();
		useCase.setTitle("");
		useCase.setDescription("Description for automated test case.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("");
		useCase.setSteps(Arrays.asList(new String[] { "", "" }));
		useCases[1] = useCase;

		// values above 255 characters
		useCase = new UseCase();
		useCase.setTitle(
				"hiji ajsi ais ajsiajsiajs iajs ijaisjiaj siajsia sjia siajs iajs iajsiajs iajsiajs ia siasajs iajs iajs iajsiaj i js iajs aijsais aijsaisja sja isjaahsajhsjasgdjhaskajhhasgfjsdhascdasbdvjsadhkasjdjhsdjashgdkjshdjasgdhsg d asdasghdgasjdgaasgdasjgdashgdsjgjsahgdjshag");
		useCase.setDescription("Description for automated test case.");
		useCase.setAutomated(true);
		useCase.setExpectedResult(
				"hiji ajsi ais ajsiajsiajs iajs ijaisjiaj siajsia sjia siajs iajs iajsiajs iajsiajs ia siasajs iajs iajs iajsiaj i js iajs aijsais aijsaisja sja isjaahsajhsjasgdjhaskajhhasgfjsdhascdasbdvjsadhkasjdjhsdjashgdkjshdjasgdhsg d asdasghdgasjdgaasgdasjgdashgdsjgjsahgdjshag");
		useCase.setSteps(Arrays.asList(new String[] {
				"hiji ajsi ais ajsiajsiajs iajs ijaisjiaj siajsia sjia siajs iajs iajsiajs iajsiajs ia siasajs iajs iajs iajsiaj i js iajs aijsais aijsaisja sja isjaahsajhsjasgdjhaskajhhasgfjsdhascdasbdvjsadhkasjdjhsdjashgdkjshdjasgdhsg d asdasghdgasjdgaasgdasjgdashgdsjgjsahgdjshag" }));
		useCases[2] = useCase;

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.goToUseCasesPage();
		UseCasesPage useCasesPage = new UseCasesPage(driver);
		useCasesPage.waitForPage();
		CreateUseCasePage createUseCasePage = new CreateUseCasePage(driver);

		for (int i = 0; i < useCases.length; i++) {
			System.out.println("Create invalid use case");
			useCasesPage.clickOnCreateUseCaseBtn();
			createUseCasePage.waitForPage();
			createUseCasePage.createUseCase(useCases[i]);
			System.out.println("Validate feedback messages");
			createUseCasePage.checkInvalidMessagesExist();
			createUseCasePage.clickOnBackBtn();
			useCasesPage.waitForPage();
		}

		System.out.println("TEST createUseCasesWithInvalidFields FINISHED");
	}

	@Test
	public void createAndEdit4UseCases() {
		
		System.out.println("TEST createAndEdit4UseCases STARTED");

		UseCase useCases[] = new UseCase[4];

		UseCase useCase = new UseCase();
		useCase.setTitle("Automated test case - create Use Case");
		useCase.setDescription("Create Use case with valid data.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("Expected result: Should be created.");
		useCase.setSteps(Arrays.asList(new String[] { "Login to app", "Open Use Case page", "Go on Create Use Case",
				"Fill in all field with valid data", "Submit", "Validate creation" }));
		useCases[0] = useCase;

		useCase = new UseCase();
		useCase.setTitle("Automated test case - create Use Case with invalid data");
		useCase.setDescription("Negative test case: Create Use case with invalid data.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("Use case should not be created. Feedback message should be shown.");
		useCase.setSteps(Arrays.asList(new String[] { "Login to app", "Open Use Case page", "Go on Create Use Case",
				"Fill in all field with invalid data", "Submit" }));
		useCases[1] = useCase;

		useCase = new UseCase();
		useCase.setTitle("Automated test case - update Use Case");
		useCase.setDescription("Create new use case and update it.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("Use Case should be updated.");
		useCase.setSteps(Arrays.asList(new String[] { "Login to app", "Open Use Case page", "Go on Create Use Case",
				"Fill in all field with valid data", "Submit", "Open created use case", "Edit use case", "Submit" }));
		useCases[2] = useCase;

		useCase = new UseCase();
		useCase.setTitle("Automated test case - update Use Case with invalid data");
		useCase.setDescription("Negative test case: Create Use case and update with invalid data.");
		useCase.setAutomated(true);
		useCase.setExpectedResult("Use case should not be updated.");
		useCase.setSteps(Arrays.asList(new String[] { "Login to app", "Open Use Case page", "Go on Create Use Case",
				"Fill in all field with valid data", "Submit", "Open created use case",
				"Edit use case with invalid data", "Submit" }));
		useCases[3] = useCase;

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.goToUseCasesPage();
		UseCasesPage useCasesPage = new UseCasesPage(driver);
		useCasesPage.waitForPage();
		CreateUseCasePage createUseCasePage = new CreateUseCasePage(driver);

		for (int i = 0; i < useCases.length; i++) {
			System.out.println("Create use case");
			useCasesPage.clickOnCreateUseCaseBtn();
			createUseCasePage.waitForPage();
			createUseCasePage.createUseCase(useCases[i]);
			useCasesPage.waitForLatestCreatedUseCaseBtn();

			System.out.println("Validate creation");
			useCasesPage.clickOnLatestCreated();
			createUseCasePage.checkUseCaseCreation(useCases[i]);
			createUseCasePage.clickOnBackBtn();
			useCasesPage.waitForLatestCreatedUseCaseBtn();
		}

		for (int i = 0; i < useCases.length; i++) {
			System.out.println("Update use case");
			useCasesPage.clickOnUseCase(i + 1);
			createUseCasePage.waitForPage();
			UseCase updatedUseCase = createUseCasePage.updateUseCase();
			useCasesPage.waitForLatestCreatedUseCaseBtn();
			useCasesPage.clickOnUseCase(i + 1);
			System.out.println("Validate update");
			createUseCasePage.checkUseCaseCreation(updatedUseCase);
			createUseCasePage.clickOnBackBtn();
			useCasesPage.waitForLatestCreatedUseCaseBtn();
		}

		for (int i = 0; i < useCases.length; i++) {
			System.out.println("Delete use case");
			useCasesPage.clickOnLatestCreated();
			createUseCasePage.waitForPage();
			createUseCasePage.clickOnDeleteBtn();
			useCasesPage.waitForPage();
		}
		
		System.out.println("TEST createAndEdit4UseCases FINISHED");
	}

}
