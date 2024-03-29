package org.brapi.test.BrAPITestServer;

import org.brapi.test.BrAPITestServer.repository.BrAPIRepositoryImpl;
import org.brapi.test.BrAPITestServer.serializer.CustomDateSerializer;
import org.brapi.test.BrAPITestServer.serializer.CustomGeoJSONDeserializer;
import org.brapi.test.BrAPITestServer.serializer.CustomGermplasmStorageTypesDeserializer;
import org.brapi.test.BrAPITestServer.serializer.CustomSerializationModule;
import org.brapi.test.BrAPITestServer.serializer.CustomStringToEnumConverter;
import org.brapi.test.BrAPITestServer.serializer.CustomTimeStampSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.model.GeoJSONGeometry;
import io.swagger.model.germ.GermplasmStorageTypes;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Configuration
@EnableJpaRepositories(basePackages = "org.brapi.test.BrAPITestServer.repository", repositoryBaseClass = BrAPIRepositoryImpl.class)
@PropertySource(value = "classpath:properties/application.properties")
public class BrapiTestServerConfig {
	@Bean
	@ConditionalOnMissingBean(CustomSerializationModule.class)
	CustomSerializationModule serializationModule() {
		CustomSerializationModule module = new CustomSerializationModule();
		module.addSerializer(OffsetDateTime.class, new CustomTimeStampSerializer());
		module.addSerializer(LocalDate.class, new CustomDateSerializer());
		module.addDeserializer(GeoJSONGeometry.class, new CustomGeoJSONDeserializer());
		module.addDeserializer(GermplasmStorageTypes.class, new CustomGermplasmStorageTypesDeserializer());
		// module.addSerializer(ObservationUnitPosition.class, new
		// CustomObservationUnitPositionSerializer());
		// module.addSerializer(ObservationUnit.class, new
		// CustomObservationUnitSerializer());
		return module;
	}

	@Bean
	public WebMvcConfigurer loadWebConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		    @Override
		    public void addFormatters(FormatterRegistry registry) {
		        registry.addConverter(new CustomStringToEnumConverter());
		    }
		};
	}
}
