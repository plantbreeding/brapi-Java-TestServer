package org.brapi.test.BrAPITestServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("org.brapi.test.BrAPITestServer.repository")
public class BrapiTestServerConfig {
	

}
