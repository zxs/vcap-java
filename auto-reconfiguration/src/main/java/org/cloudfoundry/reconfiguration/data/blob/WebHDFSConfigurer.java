package org.cloudfoundry.reconfiguration.data.blob;

import org.apache.hadoop.fs.http.client.WebHDFSConnectionFactory;
import org.cloudfoundry.reconfiguration.AbstractServiceConfigurer;
import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.env.WebHDFSServiceInfo;
import org.cloudfoundry.runtime.service.AbstractServiceCreator;
import org.cloudfoundry.runtime.service.bigdata.WebHDFSServiceCreator;

/**
 * Implementation of {@link AbstractServiceConfigurer} that replaces a single
 * {@link WebHDFSConnectionFactory} with one connecting to a webhdfs cloud service
 * bound to the current application.
 *
 * @author zixian.shen
 *
 */
public class WebHDFSConfigurer extends AbstractServiceConfigurer<WebHDFSServiceInfo> {

	private static final String CF_WEBHDFS_CONN_FACTORY_NAME = "__cloudFoundryWebHDFSConnectionFactory";

	private static final String WEBHDFS_CONN_FACTORY_CLASS_NAME = "org.apache.hadoop.fs.http.client.WebHDFSConnectionFactory";

	public WebHDFSConfigurer(CloudEnvironment cloudEnvironment) {
		super(cloudEnvironment, WebHDFSServiceInfo.class);
	}

	@Override
	public String getBeanClass() {
		return WEBHDFS_CONN_FACTORY_CLASS_NAME;
	}

	@Override
	public String getServiceBeanName() {
		return CF_WEBHDFS_CONN_FACTORY_NAME;
	}

	@Override
	public AbstractServiceCreator<?, WebHDFSServiceInfo> getServiceCreator() {
		return new WebHDFSServiceCreator();
	}
}
