package com.jira.testsuite;

import java.util.Map;
import org.testng.annotations.Test;
import com.jira.testpages.DashboardPage;
import com.jira.testpages.IssuePage;
import com.jira.testpages.LoginPage;
import com.jira.utils.Commons;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;

public class JIRAAutomation extends WebDriverTestCase {

	LoginPage loginPage = new LoginPage();
	DashboardPage dashboardPage = new DashboardPage();
	IssuePage issuePage = new IssuePage();
	
	String username;
	String password;
	String displayName;
	
	@Test(enabled = true)
	public void start() {
		
		String fileName=System.getProperty("user.dir")+"\\resources\\WorkLogReport.xlsx";
		Map<String, Map<String,String>> credentials=Commons.getExcelLogData(fileName, "Credentials");
		for(String key:credentials.keySet()) {
			username=credentials.get(key).get("username");
			password=credentials.get(key).get("password");
			displayName=credentials.get(key).get("displayName");
		}
		loginPage.launchPage(null);
		loginPage.doLogin(username, password);
		Reporter.log("User logged in successfully : "
				+ dashboardPage.getUserVerifyDashboard(displayName).verifyPresent());
		/*dashboardPage.openJiraIssue("BENC-2429");
		issuePage.verifyAssinee(displayName);*/
	}

	//@QAFDataProvider(dataFile="resources/WorkLogReport1.xls",sheetName="Sheet1")
	@Test(enabled = true, dependsOnMethods = { "start" })
	public void process() {
		String fileName=System.getProperty("user.dir")+"\\resources\\WorkLogReport.xlsx";
		Map<String, Map<String,String>> logs=Commons.getExcelLogData(fileName, "WorkLog");
		for(String key:logs.keySet()) {
			Reporter.log("Key : "+key);
			Reporter.log("Data Received : "+logs.get(key));
			dashboardPage.openJiraIssue(logs.get(key).get("issueId"));
			issuePage.verifyAssinee(displayName);
			/*issuePage.logWork();
			issuePage.fillWorkLog(logs.get(key));
			issuePage.submitLogWork();
			issuePage.clickOnWorkLogActivity();
			issuePage.getLastWorkLoggedDetails();*/
		}
	}

	@Test(dependsOnMethods = "process", enabled = true)
	public void end() {
		dashboardPage.doLogout(displayName);
	}

}
