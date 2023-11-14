package com.kafka.producer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.model.Customer;
import com.kafka.producer.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/addCustomer"
//			,consumes = {
//					MediaType.APPLICATION_JSON,
//					MediaType.APPLICATION_XML
//			})
			)
	public ResponseEntity<String> addCustomers(@RequestBody List<Customer> listCustomers){
		String addCustomersToKafka = customerService.addCustomersToKafka(listCustomers);
		return new ResponseEntity<>(addCustomersToKafka,HttpStatus.CREATED);
		
	}
	
}
