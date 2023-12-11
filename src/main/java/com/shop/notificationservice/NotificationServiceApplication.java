package com.shop.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.shop.notificationservice.event.OrderPlacedEvent;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notificationTopic")
	public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
		log.info("Notification is sent to the user for the order number {}", orderPlacedEvent.getOrderNumber());
	}

}
