package org.cloudfoundry.runtime.service.bigdata;

import org.apache.hadoop.fs.http.client.WebHDFSConnectionFactory;
import org.cloudfoundry.runtime.env.WebHDFSServiceInfo;
import org.cloudfoundry.runtime.service.AbstractServiceCreator;

/**
 * Simplified access to creating WebHDFS service objects.
 * 
 * @author zixian.shen
 * 
 */
public class WebHDFSServiceCreator extends
		AbstractServiceCreator<WebHDFSConnectionFactory, WebHDFSServiceInfo> {

	private CloudWebHDFSConfiguration cloudWebHDFSConfiguration;

	public void setCloudWebHDFSConfiguration(
			CloudWebHDFSConfiguration cloudWebHDFSConfiguration) {
		this.cloudWebHDFSConfiguration = cloudWebHDFSConfiguration;
	}

	public WebHDFSConnectionFactory createService(WebHDFSServiceInfo serviceInfo) {
		WebHDFSConnectionFactory connectionFactory = new WebHDFSConnectionFactory();
		connectionFactory.setHost(serviceInfo.getHost());
		connectionFactory.setPort(serviceInfo.getPort());
		connectionFactory.setUsername(serviceInfo.getUserName());
		connectionFactory.setPassword(serviceInfo.getPassword());
		if (cloudWebHDFSConfiguration != null) {
			connectionFactory.setAuthenticationType(cloudWebHDFSConfiguration.getAuthenticationType());
		}
		return connectionFactory;
	}
}
