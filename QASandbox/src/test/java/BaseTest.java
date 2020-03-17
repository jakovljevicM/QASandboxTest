package test.java;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import test.ui.pages.DashboardPage;
import test.ui.pages.LoginPage;
import util.PropertiesUtil;

public class BaseTest {
	public static WebDriver driver;
	
	@Before
	public void beforeMethod() throws Exception{
		System.setProperty("webdriver.gecko.driver", "./bin/main/resources/libs/geckodriver.exe");
		driver = new FirefoxDriver();
		String url = new PropertiesUtil("project.properties").getValue("URL");
		driver.get(url);
		driver.manage().window().maximize();
		
		//login to the page
		LoginPage loginPage = new LoginPage(driver);
		String email = new PropertiesUtil("project.properties").getValue("email");
		String password = new PropertiesUtil("project.properties").getValue("password");
		loginPage.login(email, password);
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.waitForPage();
	}
	
	@After
	public void afterMethod() {
		driver.quit();
	}

	
}
