package org.gradle.listener;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;



//@Service
//@RabbitListener(queues="hello")
public class RabbitMqListener {
	@Resource RabbitTemplate rabbitTemplate;
	//@Async
	@RabbitHandler
	public void receiver(String message) {
		try {
			System.out.println("Received: ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
