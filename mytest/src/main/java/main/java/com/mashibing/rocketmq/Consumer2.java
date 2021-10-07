package main.java.com.mashibing.rocketmq;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

public class Consumer2 {

	public static void main(String[] args)throws Exception {
		
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xxoo0TAG-B");
		
		consumer.setNamesrvAddr("192.168.150.113:9876");
		
		
		/**
		 * a()
		 * c()
		 * d()
		 * b -> �� rocketmq д��һ����Ϣ()
		 * rollback()
		 * 
		 * 
		 * 
		 */
		
		// ÿ��consumer ��עһ��topic
		
		// topic ��ע����Ϣ�ĵ�ַ
		// ������ * ��ʾ������
		// tag selector ��һ��group�е������ߣ����������䣬Ҫ����ͳһ
		consumer.subscribe("myTopic003", "TAG-B");
		
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

				for (MessageExt msg : msgs) {
					
					System.out.println(new String(msg.getBody()));;
				}
				// Ĭ������� ������Ϣֻ�ᱻ һ��consumer ���ѵ� ��Ե�
				// message ״̬�޸�
				// ack
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		
		
		// ������ ��ͻ�����ȣ�����ô��
		consumer.setMessageModel(MessageModel.CLUSTERING);
		consumer.start();
		
		// ��Ⱥ -> һ��consumer
		// �㲥
		
		System.out.println("Consumer TAG-B start...");
	}
}
