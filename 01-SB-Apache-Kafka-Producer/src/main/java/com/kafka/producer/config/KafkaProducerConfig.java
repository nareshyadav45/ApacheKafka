package com.kafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.producer.constants.KafkaConstants;
import com.kafka.producer.model.Customer;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public ProducerFactory<String,Customer> producerFactory(){
		Map<String, Object> configProperties=new HashMap<String, Object>();
		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProperties);
	}
	
	@Bean(name="kafkaTemplate")
	public KafkaTemplate<String, Customer> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}	
		
}
