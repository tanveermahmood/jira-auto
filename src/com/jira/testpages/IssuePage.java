package com.jira.testpages;

import java.util.List;
import java.util.Map;

import com.jira.components.LoggedWorkDetailsComp;
import com.jira.databeans.WorkLogDataBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class IssuePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "assignee.lbl.issue")
	private QAFWebElement assigneeLblIssue;

	@FindBy(locator = "more.options.btn.issue")
	private QAFWebElement moreOptionsBtnIssue;

	@FindBy(locator = "logWork.btn.issue")
	private QAFWebElement logWorkBtnIssue;

	@FindBy(locator = "log.submit.btn.worklog.issue")
	private QAFWebElement logSubmitBtnIssue;

	@FindBy(locator = "log.cancel.btn.worklog.issue")
	private QAFWebElement logCancelBtnIssue;

	@FindBy(locator = "worklog.activity.btn.issue")
	private QAFWebElement workLogActivityBtnIssue;

	@FindBy(locator = "loggedWork.comp.lst.issue")
	private List<LoggedWorkDetailsComp> loggedWorkCompLstIssue;

	@FindBy(locator = "timeSpent.input.worklog.issue")
	private QAFWebElement timeSpent;

	@FindBy(locator = "calendar.btn.worklog.issue")
	private QAFWebElement calendarBtn;

	@FindBy(locator = "calendar.comp.worklog.issue")
	private QAFWebElement calendarComp;

	@FindBy(locator = "workdescription.btn.worklog.issue")
	private QAFWebElement workdescription;

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	public QAFWebElement getAssigneeLblIssue(String userDisplayName) {
		QAFWebElement assigneeLblIssue = new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("assignee.lbl.issue"), userDisplayName));
		return assigneeLblIssue;
	}

	public QAFWebElement getMoreOptionsBtnIssue() {
		return moreOptionsBtnIssue;
	}

	public QAFWebElement getLogWorkBtnIssue() {
		return logWorkBtnIssue;
	}

	public QAFWebElement getLogSubmitBtnIssue() {
		return logSubmitBtnIssue;
	}

	public QAFWebElement getLogCancelBtnIssue() {
		return logCancelBtnIssue;
	}

	public QAFWebElement getWorkLogActivityBtnIssue() {
		return workLogActivityBtnIssue;
	}

	public List<LoggedWorkDetailsComp> getLoggedWorkCompLstIssue() {
		return loggedWorkCompLstIssue;
	}

	public void verifyAssinee(String userDisplayName) {
		waitForPageToLoad();
		getAssigneeLblIssue(userDisplayName).verifyPresent();
	}

	public void logWork() {
		getMoreOptionsBtnIssue().waitForPresent();
		getMoreOptionsBtnIssue().click();
		getLogWorkBtnIssue().click();
	}

	@QAFDataProvider(key = "worklog.work")
	// String timeSpent, String dateAndTime, String workDescription
	public void fillWorkLog(Map<String, String> data) {
		// public void fillWorkLog(String key) {
		WorkLogDataBean worklog = new WorkLogDataBean();
		worklog.fillData(data);
		// worklog.fillFromConfig(key);
		worklog.fillUiElements();
	}

	public void cancelLogWork() {
		getLogCancelBtnIssue().click();
	}
	
	public void submitLogWork() {
		getLogSubmitBtnIssue().click();
	}

	public void getLastWorkLoggedDetails() {
		getLoggedWorkCompLstIssue().get(0).getActionBodyCompLoggedworkIssue().getWorkDescription().waitForVisible();
		System.out.println(getLoggedWorkCompLstIssue().size());
		
		/*
		 * for(LoggedWorkDetailsComp work:getLoggedWorkCompLstIssue()) {
		 * System.out.println(); System.out.println("User display name : "
		 * +work.getActionDetailsCompLoggedworkIssue().getUserDisplayName().
		 * getText()); System.out.println("Date and Time : "
		 * +work.getActionDetailsCompLoggedworkIssue().getDateAndTime().getText(
		 * )); System.out.println("Work description : "
		 * +work.getActionBodyCompLoggedworkIssue().getWorkDescription().getText
		 * ()); System.out.println(); no=no+1; if(no==5) break; }
		 */
		LoggedWorkDetailsComp work = getLoggedWorkCompLstIssue().get((getLoggedWorkCompLstIssue().size() - 1));
		Reporter.log("");
		Reporter.log(
				"User display name : " + work.getActionDetailsCompLoggedworkIssue().getUserDisplayName().getText());
		Reporter.log("Date and Time : " + work.getActionDetailsCompLoggedworkIssue().getDateAndTime().getText());
		Reporter.log("Work description : " + work.getActionBodyCompLoggedworkIssue().getWorkDescription().getText());
		Reporter.log("");
	}

	public void clickOnWorkLogActivity() {
		getWorkLogActivityBtnIssue().waitForVisible();
		getWorkLogActivityBtnIssue().verifyVisible();
		getWorkLogActivityBtnIssue().click();
		
	}

}
