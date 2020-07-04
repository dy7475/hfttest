package com.myfun.framework.config;

import com.mongodb.MongoClientURI;
import com.myfun.repository.mongodb.support.converter.BigDecimalToDoubleConverter;
import com.myfun.repository.mongodb.support.converter.DoubleToBigDecimalConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * mongodb配置
 * 
 * @ClassName: MongoConfig
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年8月25日 下午3:59:52
 *
 */
@Configuration
public class MongoConfig {
	
	@Value("${common.mongodb.spring.data.log.uri}")
	private String mongodbSpringDataLogUri;
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(new MongoClientURI(mongodbSpringDataLogUri));
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		List<Object> convers = new ArrayList<Object>();
		convers.add(new BigDecimalToDoubleConverter());
		convers.add(new DoubleToBigDecimalConverter());

		MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
		converter.setCustomConversions(new CustomConversions(convers));
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
		return mongoTemplate;
	}
}
