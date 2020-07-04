package com.myfun.framework.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka配置
 * 
 * @author jsg
 *
 */
@Configuration
public class KafkaConfig {
	
	@Value("${common.spring.cloud.stream.kafka.binder.brokers}")
	private String kafkaBootstrapServers;
	
	@Bean
	public ProducerFactory<String, String> kafkaProducerFactory() {
		Map<String, Object> producerProperties = new HashMap<String, Object>();
		producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);
		producerProperties.put(ProducerConfig.RETRIES_CONFIG, 0);
		producerProperties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		producerProperties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		producerProperties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<String, String>(producerProperties);
	}

	@Bean
	public ConsumerFactory<String, String> kafkaConsumerFactory() {
		Map<String, Object> consumerProperties = new HashMap<String, Object>();
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootstrapServers);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "defaultGroup");
		consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		consumerProperties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		consumerProperties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(consumerProperties);
	}

	@Bean
	public KafkaTemplate<String, String> createTemplate() {
		KafkaTemplate<String, String> template = new KafkaTemplate<String, String>(kafkaProducerFactory());
		return template;
	}

}
