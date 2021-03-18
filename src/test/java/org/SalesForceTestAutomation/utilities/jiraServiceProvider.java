package org.SalesForceTestAutomation.utilities;

/*import java.io.IOException;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.remote.http.HttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
//import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import Decoder.BASE64Encoder;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.IssueLink;
import net.rcarz.jiraclient.LinkType;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;*/

import java.io.IOException;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import Decoder.BASE64Encoder;
import net.rcarz.jiraclient.JiraClient;

public class jiraServiceProvider {
	
	JiraClient restClient;
	public JiraClient jira;
	public String project;
	org.apache.http.client.methods.HttpPost postRequest;
	String url=null;
	String email=null;
	String token=null;
	String projectKey=null;

	//Login for Jira - input credentials
	public void JiraServiceProvider(String jiraUrl, String username, String password, String project) {
		
		this.url="https://plancanada.atlassian.net/rest/api/3/issue";
		this.email="dsathavara@plancanada.ca";
		this.token="Z30xv1F2pllHFwdlT9BuAA25";
		this.projectKey="IWD";
		}
	
	//Json string for creating bug - nothing to input
	public String setParams(String projectKey,String issueType,String summary,String description,String issueToLinkwith,String issue_name,String inward)
	{
		String str="{\r\n"
				+ "   \"fields\":{\r\n"
				+ "      \"project\":{\r\n"
				+ "         \"key\":\""+projectKey+"\"\r\n"
				+ "      },\r\n"
				+ "      \"summary\":\""+summary+"\",\r\n"
				+ "      \"description\": {\r\n"
				+ "          \"type\": \"doc\",\r\n"
				+ "          \"version\": 1,\r\n"
				+ "          \"content\": [\r\n"
				+ "            {\r\n"
				+ "              \"type\": \"paragraph\",\r\n"
				+ "              \"content\": [\r\n"
				+ "                {\r\n"
				+ "                  \"type\": \"text\",\r\n"
				+ "                  \"text\": \""+description+"\"\r\n"
				+ "                }\r\n"
				+ "              ]\r\n"
				+ "            }\r\n"
				+ "          ]\r\n"
				+ "        },\r\n"
				+ "      \"issuetype\":{\r\n"
				+ "         \"name\":\""+issueType+"\"\r\n"
				+ "      }\r\n"
				+ "   },\r\n"
				+ "   \"update\":{\r\n"
				+ "      \"issuelinks\":[\r\n"
				+ "         {\r\n"
				+ "            \"add\":{\r\n"
				+ "               \"type\":{\r\n"
				+ "                  \"name\":\""+issue_name+"\",\r\n"
				+ "                  \"inward\":\""+inward+"\"\r\n"
				+ "               },\r\n"
				+ "               \"outwardIssue\":{\r\n"
				+ "                  \"key\":\""+issueToLinkwith+"\"\r\n"
				+ "               }\r\n"
				+ "            }\r\n"
				+ "         }\r\n"
				+ "      ]\r\n"
				+ "   }\r\n"
				+ "}";
				return str;
	}
	
	//Create bug method - nothing to input
	public void createJiraTicket(String issueType, String summary, String description,String createdBy,String issueToLinkKey,String link_name,String link_type) throws ClientProtocolException, IOException {
		try {
			org.apache.hc.client5.http.impl.classic.CloseableHttpClient httpclient = HttpClients.createDefault();
			String url=this.url;
			Thread.sleep(2000);
			
			HttpPost postRequest=new HttpPost(url);
			postRequest.addHeader("content-type","application/json");
			BASE64Encoder base=new BASE64Encoder();
			String encoding=base.encode((this.email+":"+this.token).getBytes());			
			postRequest.setHeader("Authorization","Basic "+encoding);
			
			//Set
			StringEntity params=new StringEntity(setParams(this.projectKey,issueType,summary,description,issueToLinkKey,link_name,link_type));
			
			postRequest.setEntity(params);
			//Create
			httpclient.execute(postRequest);
			Thread.sleep(1000);
			
			System.out.println("Sent request for Jira bug");
			
			/*
			 *
			 *link_type variable can be replaced with name of inward/outward...
			 * :param inwardIssue: the issue to link from
    		   :param outwardIssue: the issue to link to
			 * 		
			 */		


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
















