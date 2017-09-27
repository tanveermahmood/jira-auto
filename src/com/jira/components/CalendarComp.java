package com.jira.components;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CalendarComp extends QAFWebComponent {

	@FindBy(locator = "month.year.lbl.worklog.issue")
	private QAFWebElement monthAndYear;

	@FindBy(locator = "leftArrow.btn.worklog.issue")
	private QAFWebElement leftArrow;

	@FindBy(locator = "rightArrow.btn.worklog.issue")
	private QAFWebElement rightArrow;

	@FindBy(locator = "date.lst.worklog.issue")
	private List<QAFWebElement> date;

	@FindBy(locator = "hour.btn.worklog.issue")
	private QAFWebElement hours;

	@FindBy(locator = "minute.btn.worklog.issue")
	private QAFWebElement minutes;

	@FindBy(locator = "ampm.btn.worklog.issue")
	private QAFWebElement ampm;

	public CalendarComp(String locator) {
		super(locator);
	}

	public QAFWebElement getMonthAndYear() {
		return monthAndYear;
	}

	public QAFWebElement getLeftArrow() {
		return leftArrow;
	}

	public QAFWebElement getRightArrow() {
		return rightArrow;
	}

	public List<QAFWebElement> getDate() {
		return date;
	}

	public QAFWebElement getHours() {
		return hours;
	}

	public QAFWebElement getMinutes() {
		return minutes;
	}

	public QAFWebElement getAmpm() {
		return ampm;
	}

	public void selectDateTime(String strDateTime) {
		String strMonthYear = getMonthAndYear().getText();
		Map<String, String> splittedInfo = seperateTokens(strDateTime);
		if (strMonthYear.contains(splittedInfo.get("month"))) {
			
			setTime(splittedInfo.get("hours"), splittedInfo.get("minutes"), splittedInfo.get("ampm"));
			clickOnDate(splittedInfo.get("date"));
		} else {
			goToMonth(splittedInfo.get("mon"));
			
			setTime(splittedInfo.get("hours"), splittedInfo.get("minutes"), splittedInfo.get("ampm"));
			clickOnDate(splittedInfo.get("date"));
		}
	}

	// -- navigate to given month
	private void goToMonth(String mon) {
		while (!getMonthAndYear().getText().toLowerCase().contains(mon.toLowerCase())) {
			getLeftArrow().click();
		}
	}

	// -- set time
	public void setTime(String hours, String minutes, String ampm) {
		setHours(hours);
		setMinutes(minutes);
		setAmPm(ampm);
	}

	// -- select given date
	private void clickOnDate(String date) {
		for (QAFWebElement ele : getDate()) {
			if (ele.getText().contentEquals(date)) {
				ele.click();
				break;
			}
		}
	}

	// -- set hours
	private void setHours(String hours) {
		while (!getHours().getText().contentEquals(hours)) {
			getHours().click();
		}
	}

	// -- set minutes
	private void setMinutes(String minutes) {
		while (!getMinutes().getText().contentEquals(minutes)) {
			getMinutes().click();
		}
	}

	// -- set ampm
	private void setAmPm(String ampm) {
		while (!getAmpm().getText().contentEquals(ampm)) {
			getAmpm().click();
		}
	}

	private static Map<String, String> seperateTokens(String strDateTime) {
		String dat = strDateTime.split(" ")[0];
		String time = strDateTime.split(" ")[1];
		String ampm = strDateTime.split(" ")[2];
		Map<String, String> tokens = new TreeMap<String, String>();
		tokens.put("date", dat.split("/")[0]);
		tokens.put("month", dat.split("/")[1]);
		tokens.put("year", dat.split("/")[2]);
		tokens.put("hours", time.split(":")[0]);
		tokens.put("minutes", time.split(":")[1]);
		tokens.put("ampm", ampm);
		return tokens;
	}
}
