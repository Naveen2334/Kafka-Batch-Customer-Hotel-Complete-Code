package com.batchnaveen.customerApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.batchnaveen.customerApp.constants.AppConstants;
import com.batchnaveen.customerApp.entity.Order;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	//url of kafka jsonserilizer ,String serializer
	public String addMsg(Order order) {
		
		//send message to kafka topic
		kafkaTemplate.send(AppConstants.TOPIC,order.getId(), order);
		return "Msg Published to kafka topic";
	}

}
