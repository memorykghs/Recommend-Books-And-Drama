package com.team.rbad.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 設定ObjectMapper
 * @author memorykghs
 */
@Configuration
public class ObjectMapperConfig {

	@Bean
	public ObjectMapper configObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
		.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
		.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return mapper;
	}
}
