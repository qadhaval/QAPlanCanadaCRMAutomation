package org.SalesForceTestAutomation.utilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface jiraUtils {

	boolean createJiraBug();
}
