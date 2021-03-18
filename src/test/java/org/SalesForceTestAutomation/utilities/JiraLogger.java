package org.SalesForceTestAutomation.utilities;

import org.SalesForceTestAutomation.baseClass.TestBase;

public class JiraLogger extends TestBase {

	public void addJiraLog(String logText)
	{
		JiraLogString.JiraLogString+=" \\r\\n\\r\\n\\t\\t" + logText;
		logger.info(logText);
	}
}
