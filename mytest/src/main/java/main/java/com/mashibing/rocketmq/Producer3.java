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
public class Producer3 {

	public static void main(String[] args)throws Exception {
		
		DefaultMQProducer producer = new DefaultMQProducer("xoxogp");
		
		// ����nameserver��ַ
		producer.setNamesrvAddr("192.168.150.113:9876");
		producer.start();

		Message message = new Message("myTopic001", "xxooxx".getBytes());
	
		// ������Ϣ
		// p ���粻ȷ��
		producer.sendOneway(message);
		
	//	producer.shutdown();
		System.out.println("�Ѿ�ͣ��");
		
	}
}
