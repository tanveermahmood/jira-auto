package com.jira.databeans;

import com.jira.components.CalendarComp;
import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;


public class WorkLogDataBean extends BaseFormDataBean {

	@UiElement(fieldLoc="timeSpent.input.worklog.issue",order=1)
	public String timeSpent;
	
	@UiElement(fieldLoc="calendar.btn.worklog.issue",order=3)
	public String dateAndTime;
	
	@UiElement(fieldLoc="workdescription.btn.worklog.issue",order=2)
	public String workDescription;
	
	public void fillDateAndTime() {
		QAFExtendedWebElement cal=new QAFExtendedWebElement("calendar.btn.worklog.issue");
		cal.click();
		CalendarComp calendar=new CalendarComp("calendar.comp.worklog.issue");
		calendar.selectDateTime(dateAndTime);
	}
}
