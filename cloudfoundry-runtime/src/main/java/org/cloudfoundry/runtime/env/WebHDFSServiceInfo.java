package org.cloudfoundry.runtime.env;

import java.util.Map;


/**
 * Service info for WebHDFS.
 * 
 * @author zixian.shen
 * 
 */
public class WebHDFSServiceInfo extends BaseServiceInfo {
	protected String homeDirectory;
	protected String userName;

	public WebHDFSServiceInfo(Map<String, Object> serviceInfo) {
		super(serviceInfo);
		@SuppressWarnings("unchecked")
		Map<String, Object> credentials =
			(Map<String, Object>) serviceInfo.get("credentials");
		userName = (String) credentials.get("username");
		homeDirectory = (String) credentials.get("homedirectory");
	}
	
	public String getUserName() {
		return userName;
	}

	public String getHomeDirectory() {
		return homeDirectory;
	}
}
