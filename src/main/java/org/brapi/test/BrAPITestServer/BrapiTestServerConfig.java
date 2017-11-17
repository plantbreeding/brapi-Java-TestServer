package org.brapi.test.BrAPITestServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("org.brapi.test.BrAPITestServer.repository")
@PropertySource(value = "classpath:application.properties")
public class BrapiTestServerConfig {
	

}
