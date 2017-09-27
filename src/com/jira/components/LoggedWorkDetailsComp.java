package com.jira.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;

public class LoggedWorkDetailsComp extends QAFWebComponent {
	
	@FindBy(locator = "actionLinks.comp.loggedwork.issue")
	private ActionLinksComp actionLinksCompLoggedworkIssue;
	
	@FindBy(locator = "actionDetails.comp.loggedwork.issue")
	private ActionDetailsComp actionDetailsCompLoggedworkIssue;
	
	@FindBy(locator = "actionBody.comp.loggedwork.issue")
	private ActionBodyComp actionBodyCompLoggedworkIssue;

	public LoggedWorkDetailsComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public ActionLinksComp getActionLinksCompLoggedworkIssue() {
		return actionLinksCompLoggedworkIssue;
	}

	public ActionDetailsComp getActionDetailsCompLoggedworkIssue() {
		return actionDetailsCompLoggedworkIssue;
	}

	public ActionBodyComp getActionBodyCompLoggedworkIssue() {
		return actionBodyCompLoggedworkIssue;
	}

}
