package com.kafka.consumer.Entity;

import lombok.Data;

@Data
public class Customer {
	private String id;
	private String customerName;
    private String email;
}
