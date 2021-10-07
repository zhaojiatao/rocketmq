package main.java.com.mashibing.rocketmq;

import java.util.ArrayList;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * ��Ϣ������
 * @author һ����
 *
 */
public class Producer {

	public static void main(String[] args)throws Exception {
		
		DefaultMQProducer producer = new DefaultMQProducer("xoxogp");
		
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		
		Message msg1 = new Message("myTopic001", "xxxxooo 111".getBytes());
//		Message msg2 = new Message("myTopic001", "xxxxooo 222".getBytes());
//		Message msg3 = new Message("myTopic001", "xxxxooo 333".getBytes());
		
		ArrayList<Message> list = new ArrayList<Message>();
		list.add(msg1);
//		list.add(msg2);
//		list.add(msg3);
		

		SendResult sendResult3 = producer.send(list);
		
		System.out.println(sendResult3);
		producer.shutdown();
		System.out.println("关闭");
		
	}
}
