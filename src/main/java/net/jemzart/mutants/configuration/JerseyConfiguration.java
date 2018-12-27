package net.jemzart.mutants.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.jemzart.mutants.controllers.MutantController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration(){
		register(MutantController.class);
//		packages("net.jemzart.mutants.controllers");
	}

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder(){
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);
		return builder;
	}
}
