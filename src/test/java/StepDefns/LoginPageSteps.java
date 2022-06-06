package StepDefns;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());


	@Given("the user launches the application")
	public void the_user_launches_the_application() {
		loginpage.launchURL(ApplnHooks.prop.getProperty("url"));

	}
	@When("the user is on login page")
	public void the_user_is_on_login_page() {
		String Title = loginpage.getLoginPageTitle();
		Assert.assertTrue(Title.contains("Swag Labs"));


	}
	@Then("the user enters {string} in username field")
	public void the_user_enters_in_username_field(String string) {
		if(string.contains("blank")) {
			loginpage.enterUsername("");
		}else {
			loginpage.enterUsername(string);	
		}
		
	}
	@Then("the user enters {string} in password field")
	public void the_user_enters_in_password_field(String string) {
		if(string.contains("blank")) {
			loginpage.enterPassword("");
		}else {
			loginpage.enterPassword(string);	
		}
		
	}
	@Then("the user clicks on submit button")
	public void the_user_clicks_on_submit_button() {

		loginpage.clickSubmit();
	}

	@Then("the user in on home page")
	public void the_user_in_on_home_page() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains("inventory"));
		String Title = loginpage.getCurrentURL();
		Assert.assertTrue(Title.contains("inventory"));
	}


	@Then("the user verifies {string} is displayed")
	public void the_user_verifies_is_displayed(String string) {

		Assert.assertTrue(loginpage.verifyErrorMsg().contains(string));
	}




}
