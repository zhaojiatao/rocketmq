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
public class Producer4 {

	public static void main(String[] args)throws Exception {
		
		DefaultMQProducer producer = new DefaultMQProducer("xoxogp");
		
		// ����nameserver��ַ
		producer.setNamesrvAddr("192.168.150.113:9876");
		producer.start();

		// tag ������������Ϣ����Ϣ����
		
		Message message = new Message("myTopic003", "TAG-B","KEY-xx","xxooxx".getBytes());
	
		// ������Ϣ
		// p ���粻ȷ��
		producer.send(message);
		
		producer.shutdown();
		System.out.println("�Ѿ�ͣ��");
		
	}
}
