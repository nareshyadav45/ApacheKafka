package com.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	@KafkaListener(topics = KafkaConstants.TOPIC,groupId = KafkaConstants.GROUP_ID)
//	public Customer listner(Customer customer) {
//		log.info("Messagae received from kafka "+ customer);
//		return customer;
//	}

}
