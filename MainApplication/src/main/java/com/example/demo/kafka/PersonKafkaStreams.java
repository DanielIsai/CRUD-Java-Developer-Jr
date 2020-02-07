package com.example.demo.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonKafkaStreams {
	
	String OUTPUT = "outcome";
		
	@Output(OUTPUT)
	MessageChannel outboundGreetings();
	
}
