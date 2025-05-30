package com.batchnaveen.HotelApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.batchnaveen.customerApp.constants.AppConstants;

@SpringBootApplication
public class HotelAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelAppApplication.class, args);
	}
	@KafkaListener(topics = AppConstants.TOPIC, groupId="group_customer_order")
	public void kafakSubscriberContent(String order) {
		System.out.print("_____________ Msg fecthed From Kafka_________________");
		System.out.println(order);
		
	}

}
