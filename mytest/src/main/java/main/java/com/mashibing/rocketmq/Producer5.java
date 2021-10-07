package main.java.com.mashibing.rocketmq;

import java.util.ArrayList;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * ��Ϣ������
 * @author һ����
 *
 */
public class Producer5 {

	public static void main(String[] args)throws Exception {
		
		DefaultMQProducer producer = new DefaultMQProducer("xoxogp");
		
		// ����nameserver��ַ
		producer.setNamesrvAddr("192.168.150.113:9876");
		producer.start();

		// tag ������������Ϣ����Ϣ����
		
		
		for (int i = 1; i <= 100; i++) {
			
			Message message = new Message("myTopic003", "TAG-B","KEY-xx",("xxooxx:" + i ).getBytes());
			message.putUserProperty("age", String.valueOf(i));
			producer.send(message);
		}
		
		
		
		// ������Ϣ
		// p ���粻ȷ��
		
		producer.shutdown();
		System.out.println("�Ѿ�ͣ��");
		
	}
}
