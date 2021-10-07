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
public class Producer2 {

	public static void main(String[] args)throws Exception {
		
		DefaultMQProducer producer = new DefaultMQProducer("xoxogp");
		
		// ����nameserver��ַ
		producer.setNamesrvAddr("192.168.150.113:9876");
		producer.start();

		// �첽�ɿ���Ϣ
		// �����������ȴ�broker��ȷ��
		//�����¼�������ʽ����broker���ص�ȷ��
		Message message = new Message("myTopic001", "xxoo".getBytes());
	
		
	//	producer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendAsyncFailed);
		producer.send(message,new SendCallback() {
			
			public void onSuccess(SendResult sendResult) {
				// TODO Auto-generated method stub
				System.out.println("��Ϣ���ͳɹ�������");
				System.out.println("sendResult ��" + sendResult);
				
			}
			
			public void onException(Throwable e) {

				// ��������쳣 case �쳣��������Ͷ
				// ���ߵ���ҵ���߼�
				
				e.printStackTrace();
				System.out.println("�����쳣");
			}
		});
	
		
//		producer.shutdown();
		System.out.println("�Ѿ�ͣ��");
		
	}
}
