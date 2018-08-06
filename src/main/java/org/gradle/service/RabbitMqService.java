package org.gradle.service;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {
    
	@Resource RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message) {
		rabbitTemplate.convertAndSend("hello", "测试消息:"+message);
	}
	
}
