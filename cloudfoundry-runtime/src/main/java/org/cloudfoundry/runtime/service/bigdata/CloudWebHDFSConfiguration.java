package org.cloudfoundry.runtime.service.bigdata;

/**
 * Class to hold configuration values for WebHDFS
 *
 * @author zixian.shen
 */
public class CloudWebHDFSConfiguration {

	private String authenticationType; // Pseudo, Kerberos
	
	

	public String getAuthenticationType() {
		return authenticationType;
	}

	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}
	
	
	
	
}
