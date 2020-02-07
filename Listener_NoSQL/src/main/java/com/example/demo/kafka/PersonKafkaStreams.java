package com.example.demo.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PersonKafkaStreams {
	
	String INPUT = "income";
	
	@Input(INPUT)
	SubscribableChannel inboundPerson();
}
