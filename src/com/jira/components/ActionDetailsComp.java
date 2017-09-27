package com.jira.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ActionDetailsComp extends QAFWebComponent {

	@FindBy(locator = "userDisplayName.lbl.loggedwork.issue")
	private QAFWebElement userDisplayName;
	
	@FindBy(locator = "date.time.lbl.loggedwork.issue")
	private QAFWebElement dateAndTime;
	
	public ActionDetailsComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public QAFWebElement getUserDisplayName() {
		return userDisplayName;
	}

	public QAFWebElement getDateAndTime() {
		return dateAndTime;
	}

}
