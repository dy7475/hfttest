package com.myfun.repository.mongodb.support.converter;

import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;

public class CustMappingMongoConverter extends MappingMongoConverter {

	public CustMappingMongoConverter(MongoDbFactory mongoDbFactory,
			MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext) {
		super(mongoDbFactory, mappingContext);
		conversionService.addConverter(new BigDecimalToDoubleConverter());
		conversionService.addConverter(new DoubleToBigDecimalConverter());
	}

}
