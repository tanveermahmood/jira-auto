package com.jira.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ActionLinksComp extends QAFWebComponent {
	
	@FindBy(locator = "permalink.lnk.loggedwork.issue")
	private QAFWebElement permaLink;
	
	@FindBy(locator = "edit.lnk.loggedwork.issue")
	private QAFWebElement editLink;
	
	@FindBy(locator = "delete.lnk.loggedwork.issue")
	private QAFWebElement deleteLink;

	public ActionLinksComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public QAFWebElement getPermaLink() {
		return permaLink;
	}

	public QAFWebElement getEditLink() {
		return editLink;
	}

	public QAFWebElement getDeleteLink() {
		return deleteLink;
	}

}
