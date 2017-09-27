package com.jira.testpages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "username.input.loginPage")
	private QAFWebElement usernameInputLoginPage;

	@FindBy(locator = "password.input.loginPage")
	private QAFWebElement passwordInputLoginPage;

	@FindBy(locator = "login.btn.loginPage")
	private QAFWebElement loginBtnLoginPage;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		driver.get("/");
//		driver.manage().window().maximize();
		waitForPageToLoad();
	}

	public QAFWebElement getUsernameInputLoginPage() {
		return usernameInputLoginPage;
	}

	public QAFWebElement getPasswordInputLoginPage() {
		return passwordInputLoginPage;
	}

	public QAFWebElement getLoginBtnLoginPage() {
		return loginBtnLoginPage;
	}
	
	public void doLogin(String username,String password) {
		getUsernameInputLoginPage().sendKeys(username);
		getPasswordInputLoginPage().sendKeys(password);
		getLoginBtnLoginPage().click();
		waitForPageToLoad();
	}

}
