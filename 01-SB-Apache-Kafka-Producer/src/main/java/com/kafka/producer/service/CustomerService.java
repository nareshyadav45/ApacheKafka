package com.kafka.producer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.constants.KafkaConstants;
import com.kafka.producer.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	
	public String addCustomersToKafka(List<Customer> listOfCustomers) {
		if(!listOfCustomers.isEmpty()) {
			for(Customer cusromer:listOfCustomers ) {
				kafkaTemplate.send(KafkaConstants.TOPIC, cusromer);
				log.info("++++++++++++++++++  Message Published to kafka +++++++++++++++");
				
			}
		}
		return "Customer Message or Data Successfully Added to Kafka";
		
	}
	
}
