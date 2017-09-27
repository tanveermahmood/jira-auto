package com.jira.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ActionBodyComp extends QAFWebComponent {

	@FindBy(locator = "workDescription.lbl.loggedwork.issue")
	private QAFWebElement workDescription;
	
	public ActionBodyComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public QAFWebElement getWorkDescription() {
		return workDescription;
	}

}
