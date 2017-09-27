package com.jira.testpages;

import org.openqa.selenium.Keys;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class DashboardPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "user.verify.dashboard")
	private QAFWebElement userVerifyDashboard;
	
	@FindBy(locator = "search.bar.input.dashboard")
	private QAFWebElement searchBarInputDashboard;
	
	@FindBy(locator = "logout.btn.dashboard")
	private QAFWebElement logoutBtnDashboard;
	
	@FindBy(locator = "user.options.btn.dashboard")
	private QAFWebElement userOptions;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

	public QAFWebElement getUserVerifyDashboard(String userDisplayName) {
		QAFWebElement userVerifyDashboard=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("user.verify.dashboard"), userDisplayName));
		return userVerifyDashboard;
	}

	public QAFWebElement getSearchBarInputDashboard() {
		return searchBarInputDashboard;
	}

	public QAFWebElement getLogoutBtnDashboard() {
		return logoutBtnDashboard;
	}
	
	public QAFWebElement getUserOptions() {
		return userOptions;
	}
	
	public void doLogout(String userDisplayName) {
			getUserVerifyDashboard(userDisplayName).waitForVisible();
			getUserVerifyDashboard(userDisplayName).verifyVisible();
			getUserVerifyDashboard(userDisplayName).click();
			getLogoutBtnDashboard().click();
	}
	
	public void openJiraIssue(String issueId) {
		waitForPageToLoad();
		getSearchBarInputDashboard().waitForVisible(60000);
		getSearchBarInputDashboard().sendKeys(issueId,Keys.ENTER);
		Reporter.log("I am in the page : "+driver.getTitle().toString());
	}

}
