package org.brapi.test.BrAPITestServer;

import org.brapi.test.BrAPITestServer.serializer.CustomDateSerializer;
import org.brapi.test.BrAPITestServer.serializer.CustomObservationUnitPhenotypeSerializer;
import org.brapi.test.BrAPITestServer.serializer.CustomObservationUnitPositionSerializer;
import org.brapi.test.BrAPITestServer.serializer.CustomObservationUnitSerializer;
import org.brapi.test.BrAPITestServer.serializer.CustomSerializationModule;
import org.brapi.test.BrAPITestServer.serializer.CustomTimeStampSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import io.swagger.model.ObservationUnit;
import io.swagger.model.ObservationUnitPhenotype;
import io.swagger.model.ObservationUnitPosition;

@Configuration
@EnableJpaRepositories("org.brapi.test.BrAPITestServer.repository")
@PropertySource(value = "classpath:properties/application.properties")
public class BrapiTestServerConfig {

	@Bean
	@ConditionalOnMissingBean(CustomSerializationModule.class)
	CustomSerializationModule serializationModule() {
		CustomSerializationModule module = new CustomSerializationModule();
		module.addSerializer(OffsetDateTime.class, new CustomTimeStampSerializer());
		module.addSerializer(LocalDate.class, new CustomDateSerializer());
		module.addSerializer(ObservationUnitPosition.class, new CustomObservationUnitPositionSerializer());
		module.addSerializer(ObservationUnit.class, new CustomObservationUnitSerializer());
		module.addSerializer(ObservationUnitPhenotype.class, new CustomObservationUnitPhenotypeSerializer());
		return module;
	}

}
