package org.cloudfoundry.runtime.service.config.xml;

import org.cloudfoundry.runtime.env.AbstractServiceInfo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Parser for the <cloud:webhdfs-connection-factory> namespace element
 *
 * @author zixian.shen
 */
public class CloudWebHDFSConnectionFactoryParser extends AbstractNestedElementCloudServiceFactoryParser {

	private static final String ELEMENT_WEBHDFS_OPTIONS = "webhdfs-options";

	public CloudWebHDFSConnectionFactoryParser(Class<?> beanClass, Class<? extends AbstractServiceInfo> serviceInfoClass) {
		super(beanClass, serviceInfoClass);
	}

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		BeanDefinition cloudWebHDFSConfiguration = null;
		NodeList childNodes = element.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node child = childNodes.item(i);
			if (isElement(child, parserContext, ELEMENT_WEBHDFS_OPTIONS)) {
				cloudWebHDFSConfiguration = parseWebHDFSOptionsElement((Element) child);
			}
		}
		if (cloudWebHDFSConfiguration != null) {
			builder.addPropertyValue("cloudWebHDFSConfiguration", cloudWebHDFSConfiguration);
		}
	}

	private BeanDefinition parseWebHDFSOptionsElement(Element element) {
		BeanDefinitionBuilder cloudWebHDFSConfigurationBeanBuilder =
				BeanDefinitionBuilder.genericBeanDefinition("org.cloudfoundry.runtime.service.bigdata.CloudWebHDFSConfiguration");
		
		String authenticationType = element.getAttribute("authentication-type");
		if (StringUtils.hasText(authenticationType)) {
			cloudWebHDFSConfigurationBeanBuilder.addPropertyValue("authenticationType", authenticationType);
		}
		return cloudWebHDFSConfigurationBeanBuilder.getBeanDefinition();
	}
}
