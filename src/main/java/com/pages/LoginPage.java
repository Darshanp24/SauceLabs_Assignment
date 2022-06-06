package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	
	private By username = By.xpath("//input[@name='user-name']");
	private By password = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//input[@name='login-button']");
	private By errorMessage = By.xpath("//h3[@data-test='error']");
	
	
    public void launchURL(String url){
        driver.get(url);
    }



	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public void enterUsername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	
	public void clickSubmit() {
		driver.findElement(loginButton).click();
	}
	
	public String getCurrentURL() {
		
		return driver.getCurrentUrl();
	}
	
	public String verifyErrorMsg() {
		return driver.findElement(errorMessage).getText();
	}
	

}
