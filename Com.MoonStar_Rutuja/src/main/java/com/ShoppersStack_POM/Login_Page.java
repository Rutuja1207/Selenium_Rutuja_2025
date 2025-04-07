package com.ShoppersStack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Email")
	private WebElement EmailTextField;
	
	@FindBy(id="Password")
	private WebElement PasswordTextField;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginBtn;

	public WebElement getEmailTextField() {
		return EmailTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
}
