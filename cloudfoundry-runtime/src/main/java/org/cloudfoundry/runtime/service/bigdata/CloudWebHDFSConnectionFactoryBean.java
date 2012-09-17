package org.cloudfoundry.runtime.service.bigdata;

import org.apache.hadoop.fs.http.client.WebHDFSConnectionFactory;
import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.env.WebHDFSServiceInfo;
import org.cloudfoundry.runtime.service.AbstractCloudServiceFactory;
import org.cloudfoundry.runtime.service.AbstractServiceCreator;

/**
 * Spring factory bean for WebHDFS service.
 *
 * @author zixian.shen
 *
 */
public class CloudWebHDFSConnectionFactoryBean extends AbstractCloudServiceFactory<WebHDFSConnectionFactory, WebHDFSServiceInfo> {

	private WebHDFSServiceCreator webHDFSServiceCreator;

	public CloudWebHDFSConnectionFactoryBean(CloudEnvironment cloudEnvironment) {
		super(WebHDFSServiceInfo.class,cloudEnvironment);
		this.webHDFSServiceCreator = new WebHDFSServiceCreator();
	}

	public CloudWebHDFSConnectionFactoryBean() {
		this(new CloudEnvironment());
	}

	public void setCloudWebHDFSConfiguration(CloudWebHDFSConfiguration cloudWebHDFSConfiguration) {
		this.webHDFSServiceCreator.setCloudWebHDFSConfiguration(cloudWebHDFSConfiguration);
	}

	@Override
	public Class<?> getObjectType() {
		return WebHDFSConnectionFactory.class;
	}

	@Override
	protected AbstractServiceCreator<WebHDFSConnectionFactory, WebHDFSServiceInfo> getServiceCreator() {
		return this.webHDFSServiceCreator;
	}
}
