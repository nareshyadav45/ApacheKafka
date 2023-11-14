package com.kafka.producer.model;

import lombok.Data;

/*
 * @author naresh chinthala
 */



@Data
public class Customer {

	private String id;
	private String customerName;
    private String email;
}
