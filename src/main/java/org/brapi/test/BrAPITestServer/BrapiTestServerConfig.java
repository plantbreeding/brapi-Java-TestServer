package org.brapi.test.BrAPITestServer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZonedDateTime;

import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;

import io.swagger.model.ObservationUnitPosition;

@Configuration
@EnableJpaRepositories("org.brapi.test.BrAPITestServer.repository")
@PropertySource(value = "classpath:application.properties")
public class BrapiTestServerConfig {
	@Bean
	@ConditionalOnMissingBean(ThreeTenModule.class)
	ThreeTenModule threeTenModule() {
		ThreeTenModule module = new ThreeTenModule();
		module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
		module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
		module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);

		module.addSerializer(OffsetDateTime.class, new CustomTimeStampSerializer());
		module.addSerializer(LocalDate.class, new CustomDateSerializer());
		module.addSerializer(ObservationUnitPosition.class, new CustomObservationUnitPositionSerializer());
		return module;
	}

}
