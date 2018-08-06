package org.gradle.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

/**
 * 手动应答的RabbitMQ
 * @author zhangpeng
 *
 */
@Service
@RabbitListener(queues="hello")
public class RabbitMqListener2  implements ChannelAwareMessageListener{

	public void onMessage(Message message, Channel channel) throws Exception {
		try{
            byte[] msg = message.getBody();
            String json = new String(msg);
            System.out.println(json);
        }catch(Exception e){
        	channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            e.printStackTrace();
        }
		
	}
         
}
