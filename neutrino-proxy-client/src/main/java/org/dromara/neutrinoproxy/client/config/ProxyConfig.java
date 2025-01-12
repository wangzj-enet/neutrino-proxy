package org.dromara.neutrinoproxy.client.config;

import lombok.Data;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;

/**
 *
 * @author: aoshiguchen
 * @date: 2022/6/16
 */
@Data
@Component
public class ProxyConfig {
	@Inject("${neutrino.proxy.protocol}")
	private Protocol protocol;
	@Inject("${neutrino.proxy.client}")
	private Client client;

	@Data
	public static class Protocol {
		private Integer maxFrameLength;
		private Integer lengthFieldOffset;
		private Integer lengthFieldLength;
		private Integer initialBytesToStrip;
		private Integer lengthAdjustment;
		private Integer readIdleTime;
		private Integer writeIdleTime;
		private Integer allIdleTimeSeconds;
	}

	@Data
	public static class Client {
		private String keyStorePassword;
		private String jksPath;
		private String serverIp;
		private Integer serverPort;
		private Boolean sslEnable;
		private Integer obtainLicenseInterval;
		private String licenseKey;
		private Integer threadCount;
	}
}
