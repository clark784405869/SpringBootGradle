package org.gradle.controller;

import javax.annotation.Resource;

import org.gradle.service.RabbitMqService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 *测试Controller
 *@RestController 实现Rest服务的常用注解，相当于在@Controller的基础上，自动为将所有的请求方法追加@ResponseBody
 *实现以
 */
@RestController
@RequestMapping("/hello/")
public class HelloController {
	
	@Resource RabbitMqService rabbitMqService;
	/**
	 * 该请求默认以rest方式返回hello gradle
	 * @return
	 */
	@RequestMapping("hellogradle")
      public String testHello() {
		
		return "hello gradle";
	}
	
	@RequestMapping("helloRabbitMQ")
    public String testRabbitMQ(String message) {
		for(int i=0;i<20;i++){
			rabbitMqService.sendMessage(message+i);
		}
		return "hello gradle";
	}
	
}
